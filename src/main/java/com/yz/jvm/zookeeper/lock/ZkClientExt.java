package com.yz.jvm.zookeeper.lock;

import java.util.concurrent.Callable;

import org.I0Itec.zkclient.IZkConnection;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;
import org.I0Itec.zkclient.serialize.ZkSerializer;
import org.apache.zookeeper.data.Stat;

public class ZkClientExt extends ZkClient {

    public ZkClientExt(String zkServers, int sessionTimeout, int connectionTimeout, ZkSerializer zkSerializer) {
        super(zkServers, sessionTimeout, connectionTimeout, zkSerializer);
    }

    @Override
    public void watchForData(final String path) {
        retryUntilConnected(new Callable<Object>() {

			public Object call() throws Exception {
				Stat stat = new Stat(); 
                _connection.readData(path, stat, true);
                return null;
			}

        });
    }   
    
}
