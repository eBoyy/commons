package com.utils;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Description: SettersBean
 * Author: zhumengzhu
 * Create: 2015-12-04 00:16
 */
public class SettersBean {
    private int intValue;
    private boolean boolValue;
    private float floatValue;
    private double doubleValue;
    private long longValue;
    private char charValue;
    private byte byteValue;
    private short shortValue;
    private Integer integerValue;
    private Boolean boolObjValue;
    private Float floatObjValue;
    private Double doubleObjValue;
    private Long longObjValue;
    private Short shortObjValue;
    private Byte byteObjValue;
    private BigInteger bigIntegerValue;
    private BigDecimal bigDecimalValue;
    private String stringValue;

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public void setBoolValue(boolean boolValue) {
        this.boolValue = boolValue;
    }

    public void setFloatValue(float floatValue) {
        this.floatValue = floatValue;
    }

    public void setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public void setLongValue(long longValue) {
        this.longValue = longValue;
    }

    public void setCharValue(char charValue) {
        this.charValue = charValue;
    }

    public void setByteValue(byte byteValue) {
        this.byteValue = byteValue;
    }

    public void setShortValue(short shortValue) {
        this.shortValue = shortValue;
    }

    public void setIntegerValue(Integer integerValue) {
        this.integerValue = integerValue;
    }

    public void setBoolObjValue(Boolean boolObjValue) {
        this.boolObjValue = boolObjValue;
    }

    public void setFloatObjValue(Float floatObjValue) {
        this.floatObjValue = floatObjValue;
    }

    public void setDoubleObjValue(Double doubleObjValue) {
        this.doubleObjValue = doubleObjValue;
    }

    public void setLongObjValue(Long longObjValue) {
        this.longObjValue = longObjValue;
    }

    public void setShortObjValue(Short shortObjValue) {
        this.shortObjValue = shortObjValue;
    }

    public void setByteObjValue(Byte byteObjValue) {
        this.byteObjValue = byteObjValue;
    }

    public void setBigIntegerValue(BigInteger bigIntegerValue) {
        this.bigIntegerValue = bigIntegerValue;
    }

    public void setBigDecimalValue(BigDecimal bigDecimalValue) {
        this.bigDecimalValue = bigDecimalValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return "SettersBean{" +
                "intValue=" + intValue +
                ", boolValue=" + boolValue +
                ", floatValue=" + floatValue +
                ", doubleValue=" + doubleValue +
                ", longValue=" + longValue +
                ", charValue=" + charValue +
                ", byteValue=" + byteValue +
                ", shortValue=" + shortValue +
                ", integerValue=" + integerValue +
                ", boolObjValue=" + boolObjValue +
                ", floatObjValue=" + floatObjValue +
                ", doubleObjValue=" + doubleObjValue +
                ", longObjValue=" + longObjValue +
                ", shortObjValue=" + shortObjValue +
                ", byteObjValue=" + byteObjValue +
                ", bigIntegerValue=" + bigIntegerValue +
                ", bigDecimalValue=" + bigDecimalValue +
                ", stringValue='" + stringValue + '\'' +
                '}';
    }
}
