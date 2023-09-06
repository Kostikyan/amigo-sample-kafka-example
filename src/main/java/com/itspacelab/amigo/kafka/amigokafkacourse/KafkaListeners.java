package com.itspacelab.amigo.kafka.amigokafkacourse;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "new-topic",
            groupId = "groupId"
    )
    void listener(String data){
        System.out.println("Listener received: " + data);
    }
}
