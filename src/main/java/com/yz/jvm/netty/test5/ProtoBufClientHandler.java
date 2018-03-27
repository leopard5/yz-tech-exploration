package com.yz.jvm.netty.test5;

import com.yz.jvm.serialization.protobuf.DataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProtoBufClientHandler extends SimpleChannelInboundHandler<DataInfo.Person> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Person msg) {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        DataInfo.Person person = DataInfo.Person.newBuilder()
                .setName("yazhong")
                .setAge(34)
                .setAddress("shanghai")
                .build();

        ctx.channel().writeAndFlush(person);
    }
}
