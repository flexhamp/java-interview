package com.flexhamp.springboot.kafka.consumer.service;

import com.flexhamp.springboot.kafka.consumer.model.StringValue;

import java.util.List;

public interface StringValueConsumer {
    void accept(List<StringValue> value);
}
