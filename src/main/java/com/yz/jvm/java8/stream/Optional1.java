package com.yz.jvm.java8.stream;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

public class Optional1 {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");

        optional.isPresent();           // true
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"

        List<String> names = Lists.newArrayList();
        names.stream().forEach(System.out::println);
    }

}