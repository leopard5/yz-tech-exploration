package com.yz.jvm.serialization;

/**
 *
 * @param <T>
 */
public interface ISerialize<T> {

    void serialize(T data);

    T deserialize();
}
