package com.example.homework_5_kafka;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void writeMessageToTopic(@RequestParam("message") String message){
        this.kafkaProducer.writeMessage(message);

    }
}
