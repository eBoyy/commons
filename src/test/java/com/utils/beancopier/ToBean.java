package com.utils.beancopier;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Description: ToBean
 * Author: zhumengzhu
 * Create: 2015-12-04 20:57
 */
public class ToBean {
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

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public boolean isBoolValue() {
        return boolValue;
    }

    public void setBoolValue(boolean boolValue) {
        this.boolValue = boolValue;
    }

    public float getFloatValue() {
        return floatValue;
    }

    public void setFloatValue(float floatValue) {
        this.floatValue = floatValue;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public long getLongValue() {
        return longValue;
    }

    public void setLongValue(long longValue) {
        this.longValue = longValue;
    }

    public char getCharValue() {
        return charValue;
    }

    public void setCharValue(char charValue) {
        this.charValue = charValue;
    }

    public byte getByteValue() {
        return byteValue;
    }

    public void setByteValue(byte byteValue) {
        this.byteValue = byteValue;
    }

    public short getShortValue() {
        return shortValue;
    }

    public void setShortValue(short shortValue) {
        this.shortValue = shortValue;
    }

    public Integer getIntegerValue() {
        return integerValue;
    }

    public void setIntegerValue(Integer integerValue) {
        this.integerValue = integerValue;
    }

    public Boolean getBoolObjValue() {
        return boolObjValue;
    }

    public void setBoolObjValue(Boolean boolObjValue) {
        this.boolObjValue = boolObjValue;
    }

    public Float getFloatObjValue() {
        return floatObjValue;
    }

    public void setFloatObjValue(Float floatObjValue) {
        this.floatObjValue = floatObjValue;
    }

    public Double getDoubleObjValue() {
        return doubleObjValue;
    }

    public void setDoubleObjValue(Double doubleObjValue) {
        this.doubleObjValue = doubleObjValue;
    }

    public Long getLongObjValue() {
        return longObjValue;
    }

    public void setLongObjValue(Long longObjValue) {
        this.longObjValue = longObjValue;
    }

    public Short getShortObjValue() {
        return shortObjValue;
    }

    public void setShortObjValue(Short shortObjValue) {
        this.shortObjValue = shortObjValue;
    }

    public Byte getByteObjValue() {
        return byteObjValue;
    }

    public void setByteObjValue(Byte byteObjValue) {
        this.byteObjValue = byteObjValue;
    }

    public BigInteger getBigIntegerValue() {
        return bigIntegerValue;
    }

    public void setBigIntegerValue(BigInteger bigIntegerValue) {
        this.bigIntegerValue = bigIntegerValue;
    }

    public BigDecimal getBigDecimalValue() {
        return bigDecimalValue;
    }

    public void setBigDecimalValue(BigDecimal bigDecimalValue) {
        this.bigDecimalValue = bigDecimalValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return "ToBean{" +
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

    public static ToBean getDefault() {
        ToBean bean = new ToBean();
        bean.setIntValue(1);
        bean.setBoolValue(true);
        bean.setFloatValue(1.0f);
        bean.setDoubleValue(1.0d);
        bean.setLongValue(1L);
        bean.setCharValue('a');
        bean.setShortValue((short) 1);
        bean.setByteValue((byte) 1);
        bean.setIntegerValue(new Integer("1"));
        bean.setBoolObjValue(Boolean.FALSE);
        bean.setFloatObjValue(new Float("1.0"));
        bean.setDoubleObjValue(new Double("1.0"));
        bean.setLongObjValue(new Long("1"));
        bean.setShortObjValue(new Short("1"));
        bean.setByteObjValue(new Byte("1"));
        bean.setBigIntegerValue(new BigInteger("1"));
        bean.setBigDecimalValue(new BigDecimal("1"));
        bean.setStringValue("1");
        return bean;
    }
}
