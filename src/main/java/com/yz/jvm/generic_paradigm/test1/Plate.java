package com.yz.jvm.generic_paradigm.test1;

public class Plate<T>{
    private T item;

    public Plate(T t){
        this.item = t;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
