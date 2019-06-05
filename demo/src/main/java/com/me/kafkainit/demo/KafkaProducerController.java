package com.me.kafkainit.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/producer")
public class KafkaProducerController {
    @Autowired
    private KafkaSender sender;

    @PostMapping
    public ResponseEntity<String> sendData(@RequestBody Car car){
        sender.sendData(car);
        return new ResponseEntity<>("Data sent to Kafka Server", HttpStatus.OK);    
    }
}