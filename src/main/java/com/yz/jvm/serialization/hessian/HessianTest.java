package com.yz.jvm.serialization.hessian;

import com.alibaba.fastjson.JSON;
import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.yz.jvm.data.TestData;
import com.yz.jvm.serialization.ISerialize;

import java.io.*;

/**
 * @author yazhong.qi
 */
public class HessianTest implements ISerialize {
    private final static String SERIALIZE_FILE_PATH = "D:/output/hessian.bin";

    @Override
    public void serialize(Object data) {
        //Serialization
        Hessian2Output out = null;
        try {
            File objectFile = new File(SERIALIZE_FILE_PATH);
            out = new Hessian2Output(new FileOutputStream(objectFile));
            out.startMessage();
            out.writeObject(data);
            out.completeMessage();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Object deserialize() {
        InputStream bin = null;
        Hessian2Input in = null;
        Object data = null;
        try {
            File objectFile = new File(SERIALIZE_FILE_PATH);
            bin = new FileInputStream(objectFile);
            in = new Hessian2Input(bin);

            in.startMessage();
            data = in.readObject();
            in.completeMessage();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }


}