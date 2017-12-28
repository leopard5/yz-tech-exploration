package com.yz.jvm.enums;

public enum ElementTypeEnum {
    SINGLE_BUTTON   ((byte) 1, "单按钮"),
    DOUBLE_BUTTON   ((byte) 2, "双按钮"),;

    private byte value;
    private String desc;

    ElementTypeEnum(byte value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static boolean exists(Byte status) {
        if (status == null) {
            return false;
        }
        byte s = status.byteValue();
        return exists(s);
    }

    public static boolean exists(byte s) {
        for (ElementTypeEnum element : ElementTypeEnum.values()) {
            if (element.value == s) {
                return true;
            }
        }
        return false;
    }

    public boolean equal(Byte val) {
        return val != null && val.byteValue() == this.value;
    }

    public static String getDescByValue(Byte value) {
        if (value == null) {
            return "";
        }
        for (ElementTypeEnum element : ElementTypeEnum.values()) {
            if (element.value == value.byteValue()) {
                return element.desc;
            }
        }
        return "";
    }
}
