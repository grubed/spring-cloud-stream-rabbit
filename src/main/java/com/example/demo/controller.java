package com.example.demo;

//import com.gomrwind.message.PayMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;

import org.springframework.cloud.stream.annotation.StreamListener;

import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

import org.springframework.integration.support.MessageBuilder;

import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import com.gomrwind.message.PayMessage;

@RestController
@EnableBinding(Source.class)
public class controller {

    @Autowired
    private Source source;


    @RequestMapping(value = "/sayHello", method = RequestMethod.POST)
    public void sayHello(@RequestBody Dto name) {
        source.output().send(MessageBuilder.withPayload(name).setHeader
                ("type", "a")
                .build());
    }

//    @StreamListener(LoggingSink.INPUT)
//    @SendTo(LoggingSink.OUTPUT)
////    @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
//    public String handle(String value) {
//        System.out.println("Received: " + value);
//        return value.toUpperCase();
//    }
//
//    @StreamListener(target = Sink.INPUT, condition = "headers['type']=='test'")
//    public void receiveFoo(@Headers String fooPojo) {
//        System.out.println("Received: " + fooPojo);
//        // handle the message
//    }

//    @StreamListener(Sink.INPUT)
//    public void log(String message) {
//        System.out.println(message);
//    }
}
