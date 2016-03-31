package com.study.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * Description: MethodHandle
 * New reflection api of Java 7
 * <p>
 * Author: zhumengzhu
 * Create: 2016-01-12 15:07
 */
public class TestMethodHandle {

    public static void sayHello() {
        System.out.println("Hello world.");
    }

    public static void main(String[] args) throws Throwable {
        MethodType type = MethodType.methodType(void.class);
        MethodHandle sayHello = lookup()
                .findStatic(TestMethodHandle.class, "sayHello", type);
        sayHello.invoke();
    }
}
