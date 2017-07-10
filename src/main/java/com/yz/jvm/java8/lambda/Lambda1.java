package com.yz.jvm.java8.lambda;

import java.util.*;

public class Lambda1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });

        Collections.sort(names, (a, b)-> a.compareTo(b));

        System.out.println(names);

        names.sort(Collections.reverseOrder());

        System.out.println(names);

        List<String> names2 = Arrays.asList("peter", null, "anna", "mike", "xenia");
        names2.sort(Comparator.nullsLast(String::compareTo));
        System.out.println(names2);

        List<String> names3 = null;

        Optional.ofNullable(names3).ifPresent(list -> list.sort(Comparator.naturalOrder()));

        System.out.println(names3);

    }
}
