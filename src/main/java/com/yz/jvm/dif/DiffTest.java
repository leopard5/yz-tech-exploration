package com.yz.jvm.dif;

import com.alibaba.fastjson.JSON;
import com.github.dadiyang.equator.Equator;
import com.github.dadiyang.equator.FieldInfo;
import com.google.common.collect.Lists;
import com.yz.jvm.dif.model.ContainerDiff;
import com.yz.jvm.dif.model.User;
import org.apache.commons.lang3.builder.Diff;
import org.apache.commons.lang3.builder.DiffResult;

import java.util.Iterator;
import java.util.List;

public class DiffTest {
    public static void main(String[] args) {
        diffAbleTest();
//        equatorTest();
    }

    private static void diffAbleTest() {
        User user1 = new User(12L, "yao", "55");
        User user2 = new User(123L, "yao3", "55");
        DiffResult result = user1.diff(user2);
        System.out.println(result.getNumberOfDiffs());
        List<Diff<?>> list = result.getDiffs();
        for (Iterator<Diff<?>> it = list.iterator(); it.hasNext(); ) {
            Diff<?> diff = it.next();
//            System.out.println(diff.getFieldName() + ":" + diff.getValue() + "--" + diff.getLeft() + "--" + diff.getRight() + "--" + diff.getKey() + ":" + diff.getType());
            System.out.println(diff.getFieldName() + ":" + diff.getLeft() + "--" + diff.getRight() + ":" + diff.getType());
        }
        System.out.println();
    }

    private static void equatorTest() {
        Equator equator = new ContainerDiff();

        ContainerDiff o1 = new ContainerDiff();
        o1.setBlNo("12");


        ContainerDiff o2 = new ContainerDiff();
        o2.setBlNo("34");

        // 判断属性是否完全相等
        System.out.println(equator.isEquals(o1, o2));

        // 获取不同的属性
        List<FieldInfo> diff = equator.getDiffFields(o1, o2);
        diff.forEach(s -> System.out.println(JSON.toJSONString(s)));
    }
}
