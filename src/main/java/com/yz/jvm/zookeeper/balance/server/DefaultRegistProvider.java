package com.yz.jvm.zookeeper.balance.server;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNoNodeException;

public class DefaultRegistProvider implements RegistProvider {

	public void regist(Object context) {
		// TODO Auto-generated method stub
		// 1:path
		// 2:zkClient
		// 3:serverData

		ZooKeeperRegistContext registContext = (ZooKeeperRegistContext) context;
		String path = registContext.getPath();
		ZkClient zc = registContext.getZkClient();

		try {
			zc.createEphemeral(path, registContext.getData());
		} catch (ZkNoNodeException e) {

			String parentDir = path.substring(0, path.lastIndexOf('/'));
			zc.createPersistent(parentDir, true);
			regist(registContext);
		}
	}

	public void unRegist(Object context) {
		// TODO Auto-generated method stub
		return;

	}

}
