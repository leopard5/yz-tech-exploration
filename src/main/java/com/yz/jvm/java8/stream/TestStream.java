package com.yz.jvm.java8.stream;


import akka.dispatch.Foreach;

import java.util.ArrayList;
import java.util.List;

public class TestStream {
    public static void main(String[] args) {
        List<StreamTestBean> beanList = new ArrayList<>();

        StreamTestBean bean1 = new StreamTestBean();
        bean1.setName("aa");

        StreamTestBean bean2 = new StreamTestBean();
        bean2.setName("bb");

        StreamTestBean bean3 = new StreamTestBean();
        bean3.setName("cc");

        beanList.add(bean1);
        beanList.add(bean2);

        StringBuilder sb = new StringBuilder(100);

    }
}
