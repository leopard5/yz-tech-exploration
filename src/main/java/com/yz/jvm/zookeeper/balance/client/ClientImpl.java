package com.yz.jvm.zookeeper.balance.client;

import com.yz.jvm.zookeeper.balance.server.ServerData;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientImpl implements Client {

    private final BalanceProvider<ServerData> provider;
    private EventLoopGroup group = null;
    private Channel channel = null;

    private final Logger log = LoggerFactory.getLogger(getClass());

    public ClientImpl(BalanceProvider<ServerData> provider) {
        this.provider = provider;
    }

    public BalanceProvider<ServerData> getProvider() {
        return provider;
    }

    public void connect() {
        try {
            ServerData serverData = provider.getBalanceItem();
            System.out.println("connecting to " + serverData.getHost() + ":" + serverData.getPort() + ", it's balance:" + serverData.getBalance());

            group = new NioEventLoopGroup();
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new ClientHandler());
                        }
                    });
            ChannelFuture f = b.connect(serverData.getHost(), serverData.getPort()).syncUninterruptibly();
            channel = f.channel();
            System.out.println("started success!");
        } catch (Exception e) {
            System.out.println("连接异常:" + e.getMessage());
        }
    }

    public void disConnect() {
        try {
            if (channel != null) {
                channel.close().syncUninterruptibly();
            }
            group.shutdownGracefully();
            group = null;

            log.debug("disconnected!");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
