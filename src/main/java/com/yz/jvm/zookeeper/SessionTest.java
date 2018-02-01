package com.yz.jvm.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * @author yazhong.qi
 */
public class SessionTest implements Watcher {
    final static String SERVER_LIST = "localhost:2182";

    static ZooKeeper zookeeper = null;

    public static void main(String[] args) {

        try {
            zookeeper = new ZooKeeper(SERVER_LIST, 20000, new SessionTest());
            while (zookeeper.getState() != ZooKeeper.States.CONNECTED) {
                Thread.sleep(3000);
                System.out.println("...");
            }

            System.out.println("完成数据获取：" + zookeeper.setData("/test", "test".getBytes(), -1));
            Thread.sleep(10000000L);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    static void priint_session(ZooKeeper zookeeper) {

        System.out.println("zookeeper: " + zookeeper);
        System.out.println("sessionId: " + zookeeper.getSessionId());
        System.out.println("pwd: " + print_byte(zookeeper.getSessionPasswd()));

    }

    static String print_byte(byte[] b) {
        StringBuilder sb = new StringBuilder("[");
        for (byte _b : b) {
            sb.append(_b).append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println(event.getState());
        System.out.println(event.getType());
    }
}
