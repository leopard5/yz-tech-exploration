package com.yz.jvm.rpc2;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class RpcResponse implements Serializable{
    private static final long serialVersionUID = 9081870437271897855L;

    private Object value;
    private Exception exception;
    private long requestId;
    private long processTime;
    private int timeout;
    // rpc协议版本兼容时可以回传一些额外的信息
    private Map<String, String> attachments;
    private byte rpcProtocolVersion;


}
