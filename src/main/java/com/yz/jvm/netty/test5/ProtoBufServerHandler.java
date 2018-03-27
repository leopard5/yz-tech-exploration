package com.yz.jvm.netty.test5;

import com.yz.jvm.serialization.protobuf.DataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

public class ProtoBufServerHandler extends SimpleChannelInboundHandler<DataInfo.Person> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Person msg) {
        System.out.println(ctx.channel().remoteAddress() + "," + msg);
//        ctx.channel().writeAndFlush("from server msg=" + UUID.randomUUID());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
