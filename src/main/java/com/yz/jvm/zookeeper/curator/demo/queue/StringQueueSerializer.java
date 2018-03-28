package com.yz.jvm.zookeeper.curator.demo.queue;

import org.apache.curator.framework.recipes.queue.QueueSerializer;

import java.nio.charset.Charset;

public class StringQueueSerializer implements QueueSerializer<String> {
    private static final Charset charset = Charset.forName("utf-8");

    public byte[] serialize(String item) {
        return item.getBytes(charset);
    }

    public String deserialize(byte[] bytes) {
        return new String(bytes, charset);
    }
}
