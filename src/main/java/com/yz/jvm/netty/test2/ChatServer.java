package com.yz.jvm.netty.test2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author yazhong
 * mutil client connect ,one server demo
 */
public class ChatServer {
    private final static int SERVER_PORT = 9010;

    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
//                    .localAddress(new InetSocketAddress(SERVER_PORT))
                    .childHandler(new ChatServerInitializer());

            ChannelFuture future = b.bind(SERVER_PORT).sync();
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
