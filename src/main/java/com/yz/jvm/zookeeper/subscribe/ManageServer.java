package com.yz.jvm.zookeeper.subscribe;

import com.alibaba.fastjson.JSON;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNoNodeException;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;

import java.util.List;

public class ManageServer {

	private String serversPath;
	private String commandPath;
	private String configPath;
	private ZkClient zkClient;
	private ServerConfig config;
	private IZkChildListener childListener;
	private IZkDataListener dataListener;
	private List<String> workServerList;

	public ManageServer(String serversPath, String commandPath,
			String configPath, ZkClient zkClient, ServerConfig config) {
		this.serversPath = serversPath;
		this.commandPath = commandPath;
		this.zkClient = zkClient;
		this.config = config;
		this.configPath = configPath;
		this.childListener = new IZkChildListener() {

			public void handleChildChange(String parentPath,
					List<String> currentChilds) {
				// TODO Auto-generated method stub
				workServerList = currentChilds;
				
				System.out.println("work server list changed, new list is ");
				execList();

			}
		};
		this.dataListener = new IZkDataListener() {

			public void handleDataDeleted(String dataPath) {
				// TODO Auto-generated method stub
				// ignore;
			}

			public void handleDataChange(String dataPath, Object data) {
				// TODO Auto-generated method stub
				String cmd = new String((byte[]) data);
				System.out.println("cmd:"+cmd);
				exeCmd(cmd);

			}
		};

	}

	private void initRunning() {
		zkClient.subscribeDataChanges(commandPath, dataListener);
		zkClient.subscribeChildChanges(serversPath, childListener);
	}

	/*
	 * 1: list 2: create 3: modify
	 */
	private void exeCmd(String cmdType) {
		if ("list".equals(cmdType)) {
			execList();

		} else if ("create".equals(cmdType)) {
			execCreate();
		} else if ("modify".equals(cmdType)) {
			execModify();
		} else {
			System.out.println("error command!" + cmdType);
		}

	}

	private void execList() {
		System.out.println(workServerList.toString());
	}

	private void execCreate() {
		if (!zkClient.exists(configPath)) {
			try {
				zkClient.createPersistent(configPath, JSON.toJSONString(config)
						.getBytes());
			} catch (ZkNodeExistsException e) {
				zkClient.writeData(configPath, JSON.toJSONString(config)
						.getBytes());
			} catch (ZkNoNodeException e) {
				String parentDir = configPath.substring(0,
						configPath.lastIndexOf('/'));
				zkClient.createPersistent(parentDir, true);
				execCreate();
			}
		}
	}

	private void execModify() {
		config.setDbUser(config.getDbUser() + "_modify");

		try {
			zkClient.writeData(configPath, JSON.toJSONString(config).getBytes());
		} catch (ZkNoNodeException e) {
			execCreate();
		}
	}

	public void start() {
		initRunning();
	}

	public void stop() {
		zkClient.unsubscribeChildChanges(serversPath, childListener);
		zkClient.unsubscribeDataChanges(commandPath, dataListener);
	}
}
