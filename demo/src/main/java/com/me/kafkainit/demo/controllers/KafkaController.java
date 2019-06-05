package com.me.kafkainit.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.me.kafkainit.demo.services.Producer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/kafka")
public class KafkaController {
    private final Producer producer;

    @Autowired
    public KafkaController(Producer producer){
        this.producer = producer;
    }

    @PostMapping(value = "/send")
    public void SendToTopic(@RequestParam("message")String msg){
        this.producer.sendMessage(msg);
    }
}