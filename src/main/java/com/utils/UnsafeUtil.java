package com.utils;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;

/**
 * Description: use `unsafe` api to update field of class
 * Author: zhumengzhu
 * Create: 2016-03-25 23:17
 */
public class UnsafeUtil {
    private static final Unsafe THE_UNSAFE;

    static {
        try {
            final PrivilegedExceptionAction<Unsafe> action = new PrivilegedExceptionAction<Unsafe>() {
                public Unsafe run() throws Exception {
                    Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
                    theUnsafe.setAccessible(true);
                    return (Unsafe) theUnsafe.get(null);
                }
            };
            THE_UNSAFE = AccessController.doPrivileged(action);
        } catch (Exception e) {
            throw new RuntimeException("Unable to load unsafe", e);
        }
    }

    public static void modifyStaticFieldVolatile(Class<?> target, Field field, Object value) {
        try {
            Class<?> type = field.getType();
            long offset = THE_UNSAFE.staticFieldOffset(field);
            if (type == int.class) {
                THE_UNSAFE.putIntVolatile(target, offset, (Integer) value);
            } else if (type == long.class) {
                THE_UNSAFE.putLongVolatile(target, offset, (Long) value);
            } else if (type == boolean.class) {
                THE_UNSAFE.putBooleanVolatile(target, offset, (Boolean) value);
            } else if (type == byte.class) {
                THE_UNSAFE.putByteVolatile(target, offset, (Byte) value);
            } else if (type == short.class) {
                THE_UNSAFE.putShortVolatile(target, offset, (Short) value);
            } else if (type == float.class) {
                THE_UNSAFE.putFloatVolatile(target, offset, (Float) value);
            } else if (type == double.class) {
                THE_UNSAFE.putDoubleVolatile(target, offset, (Double) value);
            } else if (type == String.class) {
                THE_UNSAFE.putObjectVolatile(target, offset, (String) value);
            } else {
                THE_UNSAFE.putObjectVolatile(target, offset, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void modifyInstanceFieldVolatile(Object target, Field field, Object value) {
        try {
            Class<?> type = field.getType();
            long offset = THE_UNSAFE.objectFieldOffset(field);
            if (type == int.class) {
                THE_UNSAFE.putIntVolatile(target, offset, (Integer) value);
            } else if (type == long.class) {
                THE_UNSAFE.putLongVolatile(target, offset, (Long) value);
            } else if (type == boolean.class) {
                THE_UNSAFE.putBooleanVolatile(target, offset, (Boolean) value);
            } else if (type == byte.class) {
                THE_UNSAFE.putByteVolatile(target, offset, (Byte) value);
            } else if (type == short.class) {
                THE_UNSAFE.putShortVolatile(target, offset, (Short) value);
            } else if (type == float.class) {
                THE_UNSAFE.putFloatVolatile(target, offset, (Float) value);
            } else if (type == double.class) {
                THE_UNSAFE.putDoubleVolatile(target, offset, (Double) value);
            } else if (type == String.class) {
                THE_UNSAFE.putObjectVolatile(target, offset, (String) value);
            } else {
                THE_UNSAFE.putObjectVolatile(target, offset, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

