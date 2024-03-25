package com.flexhamp.rabbitmq.model;

import lombok.Data;

@Data
public class MessageModel {

    private String message;
    private String routingKey;
}