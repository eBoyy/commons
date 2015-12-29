package com.utils;

import net.sf.cglib.core.*;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Description: ZBeanCopier
 * Author: zhumengzhu
 * Create: 2015-12-03 11:07
 */
abstract public class ZBeanCopier {
    private static final ZBeanCopierKey KEY_FACTORY =
            (ZBeanCopierKey) KeyFactory.create(ZBeanCopierKey.class);
    private static final Type CONVERTER =
            TypeUtils.parseType("net.sf.cglib.core.Converter");
    private static final Type BEAN_COPIER =
            TypeUtils.parseType("com.utils.ZBeanCopier");
    private static final Signature COPY =
            new Signature("copy", Type.VOID_TYPE, new Type[]{Constants.TYPE_OBJECT, Constants.TYPE_OBJECT, CONVERTER});
    private static final Signature CONVERT =
            TypeUtils.parseSignature("Object convert(Object, Class, Object)");

    /**
     * Map with primitive wrapper type as key and corresponding primitive
     * type as value, for example: Integer.class -> int.class.
     */
    private static final Map<Class<?>, Class<?>> primitiveWrapperTypeMap = new IdentityHashMap<Class<?>, Class<?>>(8);

    /**
     * Map with primitive type as key and corresponding wrapper
     * type as value, for example: int.class -> Integer.class.
     */
    private static final Map<Class<?>, Class<?>> primitiveTypeToWrapperMap = new IdentityHashMap<Class<?>, Class<?>>(8);

    static {
        primitiveWrapperTypeMap.put(Boolean.class, boolean.class);
        primitiveWrapperTypeMap.put(Byte.class, byte.class);
        primitiveWrapperTypeMap.put(Character.class, char.class);
        primitiveWrapperTypeMap.put(Double.class, double.class);
        primitiveWrapperTypeMap.put(Float.class, float.class);
        primitiveWrapperTypeMap.put(Integer.class, int.class);
        primitiveWrapperTypeMap.put(Long.class, long.class);
        primitiveWrapperTypeMap.put(Short.class, short.class);

        for (Map.Entry<Class<?>, Class<?>> entry : primitiveWrapperTypeMap.entrySet()) {
            primitiveTypeToWrapperMap.put(entry.getValue(), entry.getKey());
        }
    }

    interface ZBeanCopierKey {
        Object newInstance(String source, String target, boolean useConverter);
    }

    public static ZBeanCopier create(Class source, Class target, boolean useConverter) {
        Generator gen = new Generator();
        gen.setSource(source);
        gen.setTarget(target);
        gen.setUseConverter(useConverter);
        return gen.create();
    }

    abstract public void copy(Object from, Object to, Converter converter);

    public static class Generator extends AbstractClassGenerator {
        private static final Source SOURCE = new Source(ZBeanCopier.class.getName());
        private Class source;
        private Class target;
        private boolean useConverter;

        public Generator() {
            super(SOURCE);
        }

        public void setSource(Class source) {
            if (!Modifier.isPublic(source.getModifiers())) {
                setNamePrefix(source.getName());
            }
            this.source = source;
        }

        public void setTarget(Class target) {
            if (!Modifier.isPublic(target.getModifiers())) {
                setNamePrefix(target.getName());
            }

            this.target = target;
        }

        public void setUseConverter(boolean useConverter) {
            this.useConverter = useConverter;
        }

        protected ClassLoader getDefaultClassLoader() {
            return source.getClassLoader();
        }

        protected ProtectionDomain getProtectionDomain() {
            return ReflectUtils.getProtectionDomain(source);
        }

        public ZBeanCopier create() {
            Object key = KEY_FACTORY.newInstance(source.getName(), target.getName(), useConverter);
            return (ZBeanCopier) super.create(key);
        }

        public void generateClass(ClassVisitor v) {
            Type sourceType = Type.getType(source);
            Type targetType = Type.getType(target);
            ClassEmitter ce = new ClassEmitter(v);
            ce.begin_class(Constants.V1_2,
                    Constants.ACC_PUBLIC,
                    getClassName(),
                    BEAN_COPIER,
                    null,
                    Constants.SOURCE_FILE);

            EmitUtils.null_constructor(ce);
            CodeEmitter e = ce.begin_method(Constants.ACC_PUBLIC, COPY, null);
//            PropertyDescriptor[] getters = ReflectUtils.getBeanGetters(source);
//            PropertyDescriptor[] setters = ReflectUtils.getBeanSetters(target);
            PropertyDescriptor[] getters = org.springframework.beans.BeanUtils.getPropertyDescriptors(source);
            PropertyDescriptor[] setters = org.springframework.beans.BeanUtils.getPropertyDescriptors(target);

            Map names = new HashMap();
            for (int i = 0; i < getters.length; i++) {
                names.put(getters[i].getName(), getters[i]);
            }
            Local targetLocal = e.make_local();
            Local sourceLocal = e.make_local();
            if (useConverter) {
                e.load_arg(1);
                e.checkcast(targetType);
                e.store_local(targetLocal);
                e.load_arg(0);
                e.checkcast(sourceType);
                e.store_local(sourceLocal);
            } else {
                e.load_arg(1);
                e.checkcast(targetType);
                e.load_arg(0);
                e.checkcast(sourceType);
            }
            for (PropertyDescriptor setter : setters) {
                PropertyDescriptor getter = (PropertyDescriptor) names.get(setter.getName());
                if (getter != null) {
                    Method readMethod = getter.getReadMethod();
                    Method writeMethod = setter.getWriteMethod();
                    if (readMethod == null || writeMethod == null) {
                        continue;
                    }

                    MethodInfo read = ReflectUtils.getMethodInfo(getter.getReadMethod());
                    MethodInfo write = ReflectUtils.getMethodInfo(setter.getWriteMethod());
                    if (useConverter) {
                        Type setterType = write.getSignature().getArgumentTypes()[0];
                        e.load_local(targetLocal);
                        e.load_arg(2);
                        e.load_local(sourceLocal);
                        e.invoke(read);
                        e.box(read.getSignature().getReturnType());
                        EmitUtils.load_class(e, setterType);
                        e.push(write.getSignature().getName());
                        e.invoke_interface(CONVERTER, CONVERT);
                        e.unbox_or_zero(setterType);
                        e.invoke(write);
                    } else if (isAssignable(readMethod.getReturnType(), writeMethod.getParameterTypes()[0])) {
                        Type getterType = read.getSignature().getReturnType();
                        Type setterType = write.getSignature().getArgumentTypes()[0];
                        e.dup2();
                        e.invoke(read);

                        Type returnType = write.getSignature().getReturnType();
                        if (TypeUtils.isPrimitive(getterType)) {    // getter 为基本类型
                            if (TypeUtils.isPrimitive(setterType)) {
                                e.invoke(write);
                            } else {
                                e.box(getterType);
                                e.invoke(write);
                            }

                            // 如果 setter 有返回值, 将该返回值从栈上丢弃
                            dropIfNotNull(e, returnType);
                        } else {    // getter 为引用类型
                            Label nonNull = e.make_label();
                            Label end = e.make_label();
                            e.dup();
                            e.ifnonnull(nonNull);
                            e.pop2();
                            e.goTo(end);
                            e.mark(nonNull);
                            e.unbox(setterType);
                            e.invoke(write);

                            // 如果 setter 有返回值, 将该值从栈上丢弃
                            dropIfNotNull(e, returnType);

                            e.mark(end);
                        }
                    }
                }
            }
            e.return_value();
            e.end_method();
            ce.end_class();
        }

        /**
         * 帮助函数, 根据返回值大小丢弃栈顶元素个数;
         * <p/>
         * 其中, 返回值大小为1, 丢弃一个值; 为2, 丢弃栈顶的两个值; 其它情况, 不需要处理.
         *
         * @param emitter    代码生成器
         * @param returnType 返回类型
         */
        private void dropIfNotNull(CodeEmitter emitter, Type returnType) {
            int size = returnType.getSize();
            if (size == 1) {
                emitter.pop();
            } else if (size == 2) {
                emitter.pop2();
            }
        }

        private static boolean compatible(PropertyDescriptor getter, PropertyDescriptor setter) {
            // TODO: allow automatic widening conversions?

            return setter.getPropertyType().isAssignableFrom(getter.getPropertyType());
        }

        private static boolean isAssignable(Class<?> lhsType, Class<?> rhsType) {
            if (lhsType.isAssignableFrom(rhsType)) {
                return true;
            } else {
                Class resolvedWrapper;
                if (lhsType.isPrimitive()) {
                    resolvedWrapper = (Class) primitiveWrapperTypeMap.get(rhsType);
                    if (lhsType == resolvedWrapper) {
                        return true;
                    }
                } else {
                    resolvedWrapper = (Class) primitiveTypeToWrapperMap.get(rhsType);
                    if (resolvedWrapper != null && lhsType.isAssignableFrom(resolvedWrapper)) {
                        return true;
                    }
                }

                return false;
            }
        }

        protected Object firstInstance(Class type) {
            return ReflectUtils.newInstance(type);
        }

        protected Object nextInstance(Object instance) {
            return instance;
        }
    }

}
