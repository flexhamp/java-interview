package com.flexhamp.example1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        final ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context.xml");
        final MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}
