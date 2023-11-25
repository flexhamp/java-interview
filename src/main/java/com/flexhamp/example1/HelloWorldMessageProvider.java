package com.flexhamp.example1;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello of HelloWorldMessageProvider";
    }
}
