package com.yz.jvm.zookeeper.subscribe;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.BytesPushThroughSerializer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class SubscribeZkClient {

    private static final int CLIENT_QTY = 5;
    private static final String ZOOKEEPER_SERVER = "192.168.1.105:2181";
    private static final String CONFIG_PATH = "/config";
    private static final String COMMAND_PATH = "/command";
    private static final String SERVERS_PATH = "/servers";

    public static void main(String[] args) throws Exception {

        List<ZkClient> clients = new ArrayList<ZkClient>();
        List<WorkServer> workServers = new ArrayList<WorkServer>();
        ManageServer manageServer = null;
        try {
            ServerConfig initConfig = new ServerConfig();
            initConfig.setDbPwd("123456");
            initConfig.setDbUrl("jdbc:mysql://localhost:3306/mydb");
            initConfig.setDbUser("root");

            ZkClient clientManage = new ZkClient(ZOOKEEPER_SERVER, 5000, 5000, new BytesPushThroughSerializer());
            manageServer = new ManageServer(SERVERS_PATH, COMMAND_PATH, CONFIG_PATH, clientManage, initConfig);
            manageServer.start();

            for (int i = 0; i < CLIENT_QTY; ++i) {
                ZkClient client = new ZkClient(ZOOKEEPER_SERVER, 5000, 5000, new BytesPushThroughSerializer());
                clients.add(client);
                ServerData serverData = new ServerData();
                serverData.setId(i);
                serverData.setName("WorkServer#" + i);
                serverData.setAddress("192.168.1." + i);

                WorkServer workServer = new WorkServer(CONFIG_PATH, SERVERS_PATH, serverData, client, initConfig);
                workServers.add(workServer);
                workServer.start();

            }
            System.out.println("敲回车键退出！\n");
            new BufferedReader(new InputStreamReader(System.in)).readLine();

        } finally {
            System.out.println("Shutting down...");

            for (WorkServer workServer : workServers) {
                try {
                    workServer.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (ZkClient client : clients) {
                try {
                    client.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
