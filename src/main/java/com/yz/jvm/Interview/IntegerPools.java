package com.yz.jvm.Interview;

public class IntegerPools {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
        System.out.println(g.equals(a + h));

        System.out.println("---------------------------");

        Integer localInteger1 = Integer.valueOf(1);
        Integer localInteger2 = Integer.valueOf(2);
        Integer localInteger3 = Integer.valueOf(3);
        Integer localInteger4 = Integer.valueOf(3);
        Integer localInteger5 = Integer.valueOf(321);
        Integer localInteger6 = Integer.valueOf(321);
        Long localLong = Long.valueOf(3L);

        // 缓存池
        System.out.println(localInteger3 == localInteger4);

        // 超出缓存池范围
        System.out.println(localInteger5 == localInteger6);

        // 存在a+b数值表达式，比较的是数值
        System.out.println(localInteger3.intValue() == localInteger1.intValue() + localInteger2.intValue());

        // equals比较的是数值
        System.out.println(localInteger3.equals(Integer.valueOf(localInteger1.intValue() + localInteger2.intValue())));
        // 存在a+b数值表达式，比较的是数值
        System.out.println(localLong.longValue() == localInteger1.intValue() + localInteger2.intValue());
        // Long的equals()先判断传递进来的是不是Long类型，而a+b自动装箱的是Integer类型
        System.out.println(localLong.equals(Integer.valueOf(localInteger1.intValue() + localInteger2.intValue())));
    }
}
