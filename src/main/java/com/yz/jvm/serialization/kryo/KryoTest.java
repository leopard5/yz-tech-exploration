package com.yz.jvm.serialization.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.yz.jvm.data.TestData;
import com.yz.jvm.serialization.ISerialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class KryoTest implements ISerialize {
    private final static String SERIALIZE_FILE_PATH = "D:/output/kryo.bin";
    Kryo kryo = new Kryo();

    @Override
    public void serialize(Object data) {
        // Write Obj to File
        Output output = null;
        try {
            File file = new File(SERIALIZE_FILE_PATH);
            output = new Output(new FileOutputStream(file));
            kryo.writeObject(output, data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (KryoException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    @Override
    public Object deserialize() {
        // Read Obj from File
        Input input = null;
        Object res = null;
        try {
            File file = new File(SERIALIZE_FILE_PATH);
            input = new Input(new FileInputStream(file));
            res = kryo.readObject(input, TestData.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (KryoException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }
        }
        return res;
    }
}
