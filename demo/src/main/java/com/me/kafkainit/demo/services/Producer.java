package com.me.kafkainit.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "messages";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    public void sendMessage(String msg){
        LOGGER.info(String.format("Sending Message -> %s", msg));

        this.kafkaTemplate.send(TOPIC, msg);
    }
}