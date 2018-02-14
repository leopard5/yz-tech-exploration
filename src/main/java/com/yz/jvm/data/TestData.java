package com.yz.jvm.data;

import java.io.Serializable;

/**
 * @author yazhong.qi
 */
public class TestData implements Serializable{
    private static final long serialVersionUID = -7726682957761736444L;

    private Byte type;
    private Integer id;
    private String name;

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
