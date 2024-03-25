package com.flexhamp.rabbitmq.producer;

public interface RabbitMQProducerService {

    void sendMessage(String message, String routingKey);
}