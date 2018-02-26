package com.yz.jvm.java8.stream;


import com.yz.jvm.data.TestAmount;
import com.yz.jvm.data.TestData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test2() {
        List<TestAmount> amountList = new ArrayList<>();
        TestAmount testAmount1 = new TestAmount();
        TestAmount testAmount2 = new TestAmount();
        TestAmount testAmount3 = new TestAmount();
        amountList.add(testAmount1);
        amountList.add(testAmount2);
        amountList.add(testAmount3);

        testAmount1.setChannelId((byte) 1);
        testAmount1.setSubChannelId((byte) 1);
        testAmount1.setAmount(14);

        testAmount2.setChannelId((byte) 1);
        testAmount2.setSubChannelId((byte) 2);
        testAmount2.setAmount(9);

        testAmount3.setChannelId((byte) 3);
        testAmount3.setSubChannelId((byte) 1);
        testAmount3.setAmount(20);

        int testValue = amountList
                .stream()
                .filter((s) -> s.getChannelId().equals((byte) 7))
                .map(TestAmount::getAmount)
                .collect(Collectors.toList())
                .stream()
                .reduce(0, (sum, item) -> sum + item);
        int value = Stream.of(1, 2, 3, 4).reduce(0, (sum, item) -> sum + item);
        System.out.println(value);
        System.out.println(testValue);
    }

    public static void test1() {
        List<TestData> beanList = new ArrayList<TestData>();

        TestData bean1 = new TestData();
        bean1.setType((byte) 2);
        bean1.setId(123);

        TestData bean2 = new TestData();
        bean2.setType((byte) 2);
        bean2.setId(124);

        TestData bean3 = new TestData();
        bean3.setType((byte) 3);
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

        Map<Byte, Set<Integer>> result = beanList.stream().collect(Collectors.groupingBy(TestData::getType, Collectors.mapping(TestData::getId, Collectors.toSet())));
    }
}
