package com.yz.jvm.test.dto;

import java.io.Serializable;
import java.util.List;

public class TestVo implements Serializable{
    private Integer id;
    private String name;
    private List<String> ids;

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

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }
}
