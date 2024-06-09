package com.example.homework_5_kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumer {

    /*@KafkaListener(topics="my_topic", groupId="my_group_id")
    public void getMessage(String message){

        System.out.println(message);

    }*/
    @KafkaListener(topicPartitions = @TopicPartition(topic = "my_topic", partitions = {"0", "1", "2"}), groupId="my_group_id")
    public void getMessage(@Header(KafkaHeaders.OFFSET ) long offset,
                           @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                           @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                           @Payload String message){

        System.out.println("Consume message (" + topic + "): " + message + "\nOffset: " + offset + "\nPartition: " + partition);

    }


}
