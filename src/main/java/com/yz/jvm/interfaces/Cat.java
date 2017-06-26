package com.yz.jvm.interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/6/25.
 */
public class Cat implements Animal {

    private String name;

    public static void main(String[] args) {
        testAAA("", "", (byte) 9);
    }


    public static void testAAA(String a, String b, byte d) {

    }

    @Override
    public void callInformation(Integer count) {

    }


    @Override
    public void testInter(String aa) {
        List<String> nums = new ArrayList<String>();
        for (String num : nums) {

        }
        if (aa == null) {

        }
        if (aa != null) {

        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
