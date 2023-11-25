package com.flexhamp.springboot.kafka.producer.service;

import com.flexhamp.springboot.kafka.producer.model.StringValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class StringValueSource implements ValueSource {
    private final AtomicLong nextValue = new AtomicLong(1);

    private final DataSender valueConsumer;

    public StringValueSource(DataSender valueConsumer) {
        this.valueConsumer = valueConsumer;
    }

    @Override
    public void generate() {
        var executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() -> valueConsumer.send(makeValue()), 0, 1, TimeUnit.SECONDS);
        log.info("generation started");
    }

    private StringValue makeValue() {
        var id = nextValue.getAndIncrement();
        return new StringValue(id, "stVal: " + id);
    }
}
