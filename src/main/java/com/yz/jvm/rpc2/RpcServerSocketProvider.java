package com.yz.jvm.rpc2;

//import com.alibaba.dubbo.common.serialize.Serialization;
//import com.alibaba.dubbo.common.serialize.support.hessian.Hessian2Serialization;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RpcServerSocketProvider {
//    public static void main(String[] args) throws Exception {
//        Serialization serialization = new Hessian2Serialization();
//        ServerSocket serverSocket = new ServerSocket(8088);
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        while (true) {
//            final Socket socket = serverSocket.accept();
//            executorService.execute(() -> {
//                try {
//                    InputStream is = socket.getInputStream();
//                    OutputStream os = socket.getOutputStream();
//                    try {
//                        DataInputStream dis = new DataInputStream(is);
//                        int length = dis.readInt();
//                        byte[] requestBody = new byte[length];
//                        dis.read(requestBody);
//                        //反序列化requestBody => RpcRequest
//                        RpcRequest rpcRequest = serialization.deserialize(requestBody, RpcRequest.class);
//                        //反射调用生成响应 并组装成 rpcResponse
//                        RpcResponse rpcResponse = invoke(rpcRequest);
//                        //序列化rpcResponse => responseBody
//                        byte[] responseBody = serialization.serialize(rpcResponse);
//                        DataOutputStream dos = new DataOutputStream(os);
//                        dos.writeInt(responseBody.length);
//                        dos.write(responseBody);
//                        dos.flush();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    } finally {
//                        is.close();
//                        os.close();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    try {
//                        socket.close();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
//    }
//    public static RpcResponse invoke(RpcRequest rpcRequest) {
//        //模拟反射调用
//        RpcResponse rpcResponse = new RpcResponse();
//        rpcResponse.setRequestId(rpcRequest.getRequestId());
//        //... some operation
//        return rpcResponse;
//    }
}
