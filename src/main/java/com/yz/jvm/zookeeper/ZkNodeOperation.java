package com.yz.jvm.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class ZkNodeOperation {
	public static void main(String args[]) throws Exception {
		String zkServer = "192.168.200.199:2181";

		ZooKeeper zk = new ZooKeeper(zkServer, 6000, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
			}
		});

		// 创建节点
		System.out.println("创建testDir1节点");
		zk.create("/testDir1", "testDir1".getBytes(), Ids.OPEN_ACL_UNSAFE,
				CreateMode.PERSISTENT);

		// 创建子节点
		System.out.println("\n创建testDir1节点的子节点");
		zk.create("/testDir1/sub1", "sub1".getBytes(), Ids.OPEN_ACL_UNSAFE,
				CreateMode.PERSISTENT);
		zk.create("/testDir1/sub2", "sub2".getBytes(), Ids.OPEN_ACL_UNSAFE,
				CreateMode.PERSISTENT);

		// 取出子节点列表
		System.out.println("\ntestDir1的子节点列表为："
				+ zk.getChildren("/testDir1", true));

		// 取出节点的数据
		System.out.println("\n取出/testDir1/sub1节点的数据为："
				+ new String(zk.getData("/testDir1/sub1", false, null)));

		// 修改节点数据
		zk.setData("/testDir1/sub1", "sub3".getBytes(), -1);
		System.out.println("\n取出/testDir1/sub1节点的数据为(修改后)："
				+ new String(zk.getData("/testDir1/sub1", false, null)));

		// 删除节点
		System.out.println("\n删除节点/testDir1/sub1");
		zk.delete("/testDir1/sub1", -1);

		System.out.println("\ntestDir1的子节点列表为："
				+ zk.getChildren("/testDir1", true));
	}
}
