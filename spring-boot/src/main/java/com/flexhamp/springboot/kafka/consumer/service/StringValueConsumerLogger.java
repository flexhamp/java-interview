package com.flexhamp.springboot.kafka.consumer.service;

import com.flexhamp.springboot.kafka.consumer.model.StringValue;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class StringValueConsumerLogger implements StringValueConsumer {
    @Override
    public void accept(List<StringValue> values) {
        for (var value : values) {
            log.info("log:{}", value);
        }
    }
}
