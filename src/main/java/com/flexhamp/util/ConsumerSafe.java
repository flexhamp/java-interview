package com.flexhamp.util;

public interface ConsumerSafe<T> {
    void accept() throws Exception;
}
