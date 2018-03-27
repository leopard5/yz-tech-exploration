
package com.yz.jvm.zookeeper.balance.server;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ServerHandler extends ChannelHandlerAdapter {
    private final BalanceUpdateProvider balanceUpdater;
    private static final Integer BALANCE_STEP = 1;


    public ServerHandler(BalanceUpdateProvider balanceUpdater) {
        this.balanceUpdater = balanceUpdater;
    }

    public BalanceUpdateProvider getBalanceUpdater() {
        return balanceUpdater;
    }

    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("one client connect...");
        balanceUpdater.addBalance(BALANCE_STEP);
    }

    public void channelInactive(ChannelHandlerContext ctx) {
        balanceUpdater.reduceBalance(BALANCE_STEP);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }


}
