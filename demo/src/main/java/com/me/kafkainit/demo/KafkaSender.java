package com.me.kafkainit.demo;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender{
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSender.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topic;

    public void sendData(Car car){
        Map<String, Object> headers = new HashMap<>();
        headers.put(KafkaHeaders.TOPIC, topic);
        kafkaTemplate.send(new GenericMessage<Car>(car, headers));

        LOGGER.info(("Data - " + car.toString() + " send to Kafka Topic - "+topic));
    }
}