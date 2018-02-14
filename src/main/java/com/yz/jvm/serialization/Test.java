package com.yz.jvm.serialization;

import com.alibaba.fastjson.JSON;
import com.yz.jvm.data.TestData;
import com.yz.jvm.serialization.hessian.HessianTest;
import com.yz.jvm.serialization.kryo.KryoTest;

public class Test {
    public static void main(String[] args) {
        TestData res = null;

        TestData data = new TestData();
        data.setId(900);
        data.setType((byte) 12);
        data.setName("tomcat");

        System.out.println("序列化:" + JSON.toJSONString(data));

        HessianTest hessianTestessianTest = new HessianTest();
        hessianTestessianTest.serialize(data);
        res = (TestData) hessianTestessianTest.deserialize();
        System.out.println("HessianTest反序列化:" + JSON.toJSONString(res));


        KryoTest kryoTest = new KryoTest();
        kryoTest.serialize(data);
        res = (TestData) kryoTest.deserialize();
        System.out.println("KryoTest反序列化:" + JSON.toJSONString(res));
    }
}
