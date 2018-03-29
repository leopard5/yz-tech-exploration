package com.yz.jvm.netty.test5;

import com.yz.jvm.serialization.protobuf.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProtoBufServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) {
        System.out.println(ctx.channel().remoteAddress() + "," + msg);

        MyDataInfo.MyMessage.DataType dataType = msg.getDataType();
        switch (dataType) {
            case PersonType:
                System.out.println(msg.getPerson().toString());
                break;
            case DogType:
                System.out.println(msg.getDog().toString());
                break;
            case CatType:
                System.out.println(msg.getCat().toString());
                break;
            default:
        }
//        ctx.channel().writeAndFlush("from server msg=" + UUID.randomUUID());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
