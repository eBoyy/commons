package com.utils.beancopier;

/**
 * Description: PrimitiveBean
 * Author: zhumengzhu
 * Create: 2015-12-04 00:38
 */
public class PrimitiveBean {

    private int intValue = -1;
    private boolean boolValue;
    private float floatValue;
    private double doubleValue;
    private long longValue;
    private char charValue;
    private byte byteValue;
    private short shortValue;

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

    @Override
    public String toString() {
        return "PrimitiveBean{" +
                "intValue=" + intValue +
                ", boolValue=" + boolValue +
                ", floatValue=" + floatValue +
                ", doubleValue=" + doubleValue +
                ", longValue=" + longValue +
                ", charValue=" + charValue +
                ", byteValue=" + byteValue +
                ", shortValue=" + shortValue +
                '}';
    }

    public static PrimitiveBean getDefault() {
        PrimitiveBean bean = new PrimitiveBean();

        bean.setIntValue(1);
        bean.setBoolValue(true);
        bean.setFloatValue(1.0f);
        bean.setDoubleValue(1.0d);
        bean.setLongValue(1L);
        bean.setCharValue('a');
        bean.setShortValue((short) 1);
        bean.setByteValue((byte) 1);

        return bean;
    }

}
