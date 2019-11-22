package com.yz.jvm.rpc2;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class RpcRequest implements Serializable{
    private static final long serialVersionUID = -4016148802605312997L;

    private String interfaceName;
    private String methodName;
    private String parametersDesc;
    private Object[] arguments;
    private Map<String, String> attachments;
    private int retries = 0;
    private long requestId;
    private byte rpcProtocolVersion;



}
