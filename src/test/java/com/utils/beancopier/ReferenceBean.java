package com.utils.beancopier;

/**
 * Description: ReferenceBean
 * Author: zhumengzhu
 * Create: 2015-12-04 00:39
 */
public class ReferenceBean {
    private Integer intValue;
    private Boolean boolValue;
    private Float floatValue;
    private Double doubleValue;
    private Long longValue;
    private Character charValue;
    private Byte byteValue;
    private Short shortValue;

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    public Boolean getBoolValue() {
        return boolValue;
    }

    public void setBoolValue(Boolean boolValue) {
        this.boolValue = boolValue;
    }

    public Float getFloatValue() {
        return floatValue;
    }

    public void setFloatValue(Float floatValue) {
        this.floatValue = floatValue;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public Long getLongValue() {
        return longValue;
    }

    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }

    public Character getCharValue() {
        return charValue;
    }

    public void setCharValue(Character charValue) {
        this.charValue = charValue;
    }

    public Byte getByteValue() {
        return byteValue;
    }

    public void setByteValue(Byte byteValue) {
        this.byteValue = byteValue;
    }

    public Short getShortValue() {
        return shortValue;
    }

    public void setShortValue(Short shortValue) {
        this.shortValue = shortValue;
    }

    @Override
    public String toString() {
        return "ReferenceBean{" +
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

    public static ReferenceBean getDefault() {
        ReferenceBean bean = new ReferenceBean();

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
