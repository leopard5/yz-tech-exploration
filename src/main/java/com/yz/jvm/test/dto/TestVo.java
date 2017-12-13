package com.yz.jvm.test.dto;

import java.io.Serializable;
import java.util.List;

public class TestVo implements Serializable{
    private static final long serialVersionUID = -8357733950522752993L;

    private Integer id;
    private String name;
    private List<String> names;
    private List<Integer> ids;


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

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
