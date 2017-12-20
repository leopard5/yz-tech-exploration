package com.yz.jvm.java8.stream;


import com.yz.jvm.data.TestData;
import scala.util.control.Exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {
        List<TestData> beanList = new ArrayList<TestData>();

        TestData bean1 = new TestData();
        bean1.setType((byte)2);
        bean1.setId(123);

        TestData bean2 = new TestData();
        bean2.setType((byte)2);
        bean2.setId(124);

        TestData bean3 = new TestData();
        bean3.setType((byte)3);
        bean3.setId(888);

        beanList.add(bean1);
        beanList.add(bean2);
        beanList.add(bean3);

        List<Integer> collect1 = beanList.stream().filter((s) -> s.getType().equals(Byte.valueOf((byte) 2))).map((s) -> s.getId()).collect(Collectors.toList());
        List<Integer> collect2 = beanList.stream().filter((s) -> s.getType().equals(Byte.valueOf((byte) 3))).map((s) -> s.getId()).collect(Collectors.toList());
        System.out.println(collect1.toString());
        System.out.println(collect2.toString());

        Map<Byte, Long> collect = beanList.stream().collect(Collectors.groupingBy(TestData::getType, Collectors.counting()));
        System.out.println(collect);

        Map<Byte, List<TestData>> collect3 = beanList.stream().collect(Collectors.groupingBy(TestData::getType));
        System.out.println(collect3);
    }
}
