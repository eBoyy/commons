package com.utils.unsafe;

import com.utils.UnsafeUtil;

import java.lang.reflect.Field;

/**
 * Description: UnsafeUtilTest
 * Author: zhumengzhu
 * Create: 2016-03-31 11:39
 */
class UnsafeUtilTest {
    public static Integer staticField = 1;

    public static String str = "hi";

    private int field = 2;

    private Integer integer = 20;

    public static Integer getStaticField() {
        return staticField;
    }

    public int getField() {
        return field;
    }

    public static String getStr() {
        return str;
    }

    public Integer getInteger() {
        return integer;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // update instance field
        Field intField = UnsafeUtilTest.class.getDeclaredField("field");
        UnsafeUtilTest unsafeUtilTest = new UnsafeUtilTest();
        int field = unsafeUtilTest.getField();
        UnsafeUtil.modifyInstanceFieldVolatile(unsafeUtilTest, intField, 8888);
        System.out.println(field + " -> " + unsafeUtilTest.getField());

        Field integer = UnsafeUtilTest.class.getDeclaredField("integer");
        Integer integer1 = unsafeUtilTest.getInteger();
        UnsafeUtil.modifyInstanceFieldVolatile(unsafeUtilTest, integer, 9);
        System.out.println(integer1 + " -> " + unsafeUtilTest.getInteger());

        // update static field
        Field integerField = UnsafeUtilTest.class.getDeclaredField("staticField");
        Object source = integerField.get(UnsafeUtilTest.class);
        UnsafeUtil.modifyStaticFieldVolatile(UnsafeUtilTest.class, integerField, 4666);
        System.out.println(source + " -> " + UnsafeUtilTest.staticField);

        Field strField = UnsafeUtilTest.class.getDeclaredField("str");
        String str = UnsafeUtilTest.str;
        UnsafeUtil.modifyStaticFieldVolatile(UnsafeUtilTest.class, strField, "hello");
        System.out.println(str + " -> " + UnsafeUtilTest.str);
    }
}
