package com.utils.beancopier;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Description: BuilderBean
 * Author: zhumengzhu
 * Create: 2015-12-04 20:59
 */
public class BuilderBean {
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

    public BuilderBean setIntValue(int intValue) {
        this.intValue = intValue;
        return this;
    }

    public boolean isBoolValue() {
        return boolValue;
    }

    public BuilderBean setBoolValue(boolean boolValue) {
        this.boolValue = boolValue;
        return this;
    }

    public float getFloatValue() {
        return floatValue;
    }

    public BuilderBean setFloatValue(float floatValue) {
        this.floatValue = floatValue;
        return this;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public BuilderBean setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
        return this;
    }

    public long getLongValue() {
        return longValue;
    }

    public BuilderBean setLongValue(long longValue) {
        this.longValue = longValue;
        return this;
    }

    public char getCharValue() {
        return charValue;
    }

    public BuilderBean setCharValue(char charValue) {
        this.charValue = charValue;
        return this;
    }

    public byte getByteValue() {
        return byteValue;
    }

    public BuilderBean setByteValue(byte byteValue) {
        this.byteValue = byteValue;
        return this;
    }

    public short getShortValue() {
        return shortValue;
    }

    public BuilderBean setShortValue(short shortValue) {
        this.shortValue = shortValue;
        return this;
    }

    public Integer getIntegerValue() {
        return integerValue;
    }

    public int setIntegerValue(Integer integerValue) {
        this.integerValue = integerValue;
        return 1;
    }

    public Boolean getBoolObjValue() {
        return boolObjValue;
    }

    public boolean setBoolObjValue(Boolean boolObjValue) {
        this.boolObjValue = boolObjValue;
        return true;
    }

    public Float getFloatObjValue() {
        return floatObjValue;
    }

    public float setFloatObjValue(Float floatObjValue) {
        this.floatObjValue = floatObjValue;
        return 1.0F;
    }

    public Double getDoubleObjValue() {
        return doubleObjValue;
    }

    public double setDoubleObjValue(Double doubleObjValue) {
        this.doubleObjValue = doubleObjValue;
        return 1.0D;
    }

    public Long getLongObjValue() {
        return longObjValue;
    }

    public long setLongObjValue(Long longObjValue) {
        this.longObjValue = longObjValue;
        return 1L;
    }

    public Short getShortObjValue() {
        return shortObjValue;
    }

    public short setShortObjValue(Short shortObjValue) {
        this.shortObjValue = shortObjValue;
        return (short) 1;
    }

    public Byte getByteObjValue() {
        return byteObjValue;
    }

    public byte setByteObjValue(Byte byteObjValue) {
        this.byteObjValue = byteObjValue;
        return (byte) 1;
    }

    public BigInteger getBigIntegerValue() {
        return bigIntegerValue;
    }

    public BuilderBean setBigIntegerValue(BigInteger bigIntegerValue) {
        this.bigIntegerValue = bigIntegerValue;
        return this;
    }

    public BigDecimal getBigDecimalValue() {
        return bigDecimalValue;
    }

    public BuilderBean setBigDecimalValue(BigDecimal bigDecimalValue) {
        this.bigDecimalValue = bigDecimalValue;
        return this;
    }

    public String getStringValue() {
        return stringValue;
    }

    public long setStringValue(String stringValue) {
        this.stringValue = stringValue;
        return 2L;
    }

    @Override
    public String toString() {
        return "BuilderBean{" +
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

    public static BuilderBean getDefault() {
        BuilderBean bean = new BuilderBean();
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
