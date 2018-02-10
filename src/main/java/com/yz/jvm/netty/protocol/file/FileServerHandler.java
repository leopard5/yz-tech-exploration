package com.yz.jvm.netty.protocol.file;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.FileRegion;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileServerHandler extends SimpleChannelInboundHandler<String> {

    private static final String CR = System.getProperty("line.separator");

    public void messageReceived(ChannelHandlerContext ctx, String msg)
            throws Exception {
        RandomAccessFile randomAccessFile = null;
        try {
            File file = new File(msg);
            if (file.exists()) {
                if (!file.isFile()) {
                    ctx.writeAndFlush("Not a file : " + file + CR);
                    return;
                }
                ctx.write(file + " " + file.length() + CR);
                randomAccessFile = new RandomAccessFile(msg, "r");
                FileRegion region = new DefaultFileRegion(
                        randomAccessFile.getChannel(), 0, randomAccessFile.length());
                ctx.write(region);
                ctx.writeAndFlush(CR);
                randomAccessFile.close();
            } else {
                ctx.writeAndFlush("File not found: " + file + CR);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) {
        return;
    }
}
