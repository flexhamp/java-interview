package com.flexhamp.springboot.kafka.producer.service;

import com.flexhamp.springboot.kafka.producer.model.StringValue;

public interface DataSender {
    void send(StringValue value);
}
