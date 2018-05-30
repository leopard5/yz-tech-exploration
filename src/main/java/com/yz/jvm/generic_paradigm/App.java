package com.yz.jvm.generic_paradigm;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        /**
         * 就算容器里装的东西之间有继承关系，但容器之间是没有继承关系的。
         * 所以我们不可以把Plate的引用传递给Plate。
         *
         */
//        Plate<Fruit> p=new Plate<Apple>(new Apple());

        /**
         *
         */
//        PECS
//        请记住PECS原则：生产者（Producer）使用extends，消费者（Consumer）使用super。
//
//        生产者使用extends
//        如果你需要一个列表提供T类型的元素（即你想从列表中读取T类型的元素），你需要把这个列表声明成<? extends T>，比如List<? extends Integer>，因此你不能往该列表中添加任何元素。
//
//        消费者使用super
//        如果需要一个列表使用T类型的元素（即你想把T类型的元素加入到列表中），你需要把这个列表声明成<? super T>，比如List<? super Integer>，因此你不能保证从中读取到的元素的类型。
//
//        即是生产者，也是消费者
//        如果一个列表即要生产，又要消费，你不能使用泛型通配符声明列表，比如List<Integer>。



        List<? extends Fruit> pp = new ArrayList<Apple>();

        Plate<? extends Fruit> p = new Plate<Apple>(new Apple());
        List<? extends Fruit> pList = new ArrayList<>();

    }
}
