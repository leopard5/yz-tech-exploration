package com.yz.jvm.zookeeper.curator.demo.utils;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class ClientFactory {

    public static CuratorFramework newClient() {
        String connectionString = "192.168.11.56:2180,192.168.11.56:2181,192.168.11.56:2182";
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        return CuratorFrameworkFactory.newClient(connectionString, retryPolicy);
    }
}
