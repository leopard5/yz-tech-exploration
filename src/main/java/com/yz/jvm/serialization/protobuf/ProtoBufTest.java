package com.yz.jvm.serialization.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

public class ProtoBufTest {
    public static void main(String[] args) {
        try {
            DataInfo.Person person = DataInfo.Person.newBuilder()
                    .setName("Harry")
                    .setAge(12)
                    .setAddress("Tokyo")
                    .build();

            // encode
            byte[] person2ByteArray = person.toByteArray();

            // decode
            DataInfo.Person person2 = DataInfo.Person.parseFrom(person2ByteArray);

            // println
            System.out.println(person2.toString());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
