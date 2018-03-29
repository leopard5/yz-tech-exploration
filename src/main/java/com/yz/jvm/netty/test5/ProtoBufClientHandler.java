package com.yz.jvm.netty.test5;

import com.yz.jvm.serialization.protobuf.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class ProtoBufClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        int randomInt = new Random().nextInt(3);

        MyDataInfo.MyMessage myMessage = null;
        switch (randomInt) {
            case 0:
                MyDataInfo.Person person = MyDataInfo.Person.newBuilder()
                        .setName("harry")
                        .setAge(34)
                        .setAddress("shanghai")
                        .build();

                myMessage = MyDataInfo.MyMessage.newBuilder()
                        .setDataType(MyDataInfo.MyMessage.DataType.PersonType)
                        .setPerson(person)
                        .build();
                break;
            case 1:
                MyDataInfo.Dog dog = MyDataInfo.Dog.newBuilder()
                        .setName("Dog")
                        .setAge(5)
                        .build();

                myMessage = MyDataInfo.MyMessage.newBuilder()
                        .setDataType(MyDataInfo.MyMessage.DataType.DogType)
                        .setDog(dog)
                        .build();
                break;
            case 2:
                MyDataInfo.Cat cat = MyDataInfo.Cat.newBuilder()
                        .setName("cat")
                        .setCity("xian")
                        .build();

                myMessage = MyDataInfo.MyMessage.newBuilder()
                        .setDataType(MyDataInfo.MyMessage.DataType.CatType)
                        .setCat(cat)
                        .build();
                break;
            default:
        }

        ctx.channel().writeAndFlush(myMessage);
    }
}
