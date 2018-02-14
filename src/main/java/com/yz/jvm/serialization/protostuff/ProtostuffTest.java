package com.yz.jvm.serialization.protostuff;

import com.yz.jvm.serialization.ISerialize;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

/**
 * @author yazhong.qi
 */
public class ProtostuffTest implements ISerialize {
    private final static String SERIALIZE_FILE_PATH = "D:/output/protostuff.bin";

    @Override
    public void serialize(Object data) {
        Schema<Object> schema = RuntimeSchema.getSchema(Object.class);

        LinkedBuffer buffer = LinkedBuffer.allocate();
        byte[] protostuff = null;
        // 序列化
        try {
            protostuff = ProtostuffIOUtil.toByteArray(data, schema, buffer);
            System.out.println("bytes len:" + protostuff.length);
        } finally {
            buffer.clear();
        }
    }

    @Override
    public Object deserialize() {
//        byte[] protostuff = ;
//        Schema<Object> schema = RuntimeSchema.getSchema(Object.class);
//        // 反序列化
//        Object p = schema.newMessage();
//        ProtostuffIOUtil.mergeFrom(protostuff, p, schema);
//        return p;
        return null;
    }
}
