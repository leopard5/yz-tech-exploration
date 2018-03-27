package com.yz.jvm.netty.test5;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class ProtoBufClient {
    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        try {
            bootstrap.group(bossGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ProtoBufClientInitializer());

            ChannelFuture channelFuture = bootstrap.connect("localhost", 9040).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
        }
    }
}
