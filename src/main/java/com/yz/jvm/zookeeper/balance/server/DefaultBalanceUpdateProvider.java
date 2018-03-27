package com.yz.jvm.zookeeper.balance.server;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkBadVersionException;
import org.apache.zookeeper.data.Stat;

public class DefaultBalanceUpdateProvider implements BalanceUpdateProvider {

	private String serverPath;
	private ZkClient zc;

	public DefaultBalanceUpdateProvider(String serverPath, ZkClient zkClient) {
		this.serverPath = serverPath;
		this.zc = zkClient;

	}

	public boolean addBalance(Integer step) {
		// TODO Auto-generated method stub
		Stat stat = new Stat();
		ServerData sd;

		while (true) {

			try {
				sd = zc.readData(this.serverPath, stat);
				sd.setBalance(sd.getBalance() + step);
				zc.writeData(this.serverPath, sd, stat.getVersion());
				return true;
			} catch (ZkBadVersionException e) {
				// ignore
			} catch (Exception e) {
				return false;
			}
		}

	}

	public boolean reduceBalance(Integer step) {
		// TODO Auto-generated method stub
		Stat stat = new Stat();
		ServerData sd;

		while (true) {

			try {
				sd = zc.readData(this.serverPath, stat);
				
				final Integer currBalance = sd.getBalance();
				
				sd.setBalance(currBalance>step?currBalance-step:0);
				
				zc.writeData(this.serverPath, sd, stat.getVersion());
				
				return true;
			} catch (ZkBadVersionException e) {
				// ignore
			} catch (Exception e) {
				return false;
			}
		}
	}

}
