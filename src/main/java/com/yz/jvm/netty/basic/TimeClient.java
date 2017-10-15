package com.yz.jvm.netty.basic;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TimeClient {
    private static int port = 9999;
    private static String host = "127.0.0.1";

    public static void main(String[] args) {
        new TimeClient().connect(port, host);
    }

    public void connect(int port, String host) {
        // 配置客户端的NIO线程组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel arg0)
                                throws Exception {
                            arg0.pipeline().addLast(new TimeClientHandler());
                        }
                    });
            // 发起异步连接操作
            ChannelFuture future = bootstrap.connect(host, port).sync();

            // 等待关闭连接
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}
