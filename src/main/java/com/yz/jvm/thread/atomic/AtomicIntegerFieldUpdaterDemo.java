package com.yz.jvm.thread.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterDemo {
    class DemoData {
        public volatile int value1 = 1;
        public volatile int value2 = 2;
        public volatile int value3 = 3;
        public volatile int value4 = 4;
    }

    AtomicIntegerFieldUpdater<DemoData> getUpdater(String fieldName) {
        return AtomicIntegerFieldUpdater.newUpdater(DemoData.class, fieldName);
    }

    void doit() {
        DemoData data = new DemoData();
        getUpdater("value1").getAndSet(data, 10);
        getUpdater("value2").incrementAndGet(data);
        getUpdater("value3").decrementAndGet(data);
        getUpdater("value4").compareAndSet(data, 4, 5);

        System.out.println("value1=" + data.value1);
        System.out.println("value2=" + data.value2);
        System.out.println("value3=" + data.value3);
        System.out.println("value4=" + data.value4);
    }

    public static void main(String[] args) {
        AtomicIntegerFieldUpdaterDemo demo = new AtomicIntegerFieldUpdaterDemo();
        demo.doit();

    }
}
