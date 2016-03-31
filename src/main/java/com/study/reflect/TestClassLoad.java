package com.study.reflect;

import java.lang.reflect.Method;

/**
 * Description: TraceClassLoading
 * JVM flags: `-XX:+TraceClassLoading`
 * <p>
 * Author: zhumengzhu
 * Create: 2016-01-12 14:36
 */
public class TestClassLoad {
    public static void main(String[] args) throws Exception {
        Class<?> clz = Class.forName("com.study.reflect.A");
        Object o = clz.newInstance();
        Method foo = clz.getMethod("foo", String.class);
        for (int i = 0; i < 16; i++) {
            foo.invoke(o, String.valueOf(i));
        }
    }
}
