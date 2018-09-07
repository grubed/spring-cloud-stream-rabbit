package com.example.demo;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

@EnableBinding(Sink.class)
public class LoggingSink {

//    @StreamListener(Sink.INPUT)
@StreamListener(target = Sink.INPUT, condition = "headers['type']=='a'")
    public void log(Dto message) {
        System.out.println("get message:");
        System.out.println(message.getName());
        System.out.println(message.getA());
    }
}