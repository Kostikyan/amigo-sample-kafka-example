package com.itspacelab.amigo.kafka.amigokafkacourse;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;


    @PostMapping
    public void publish(@RequestBody MessageRequest messageRequest){
        String message = messageRequest.message();
        if (message != null && !message.isEmpty()) {
            kafkaTemplate.send("new-topic", message);
        } else {
            throw new RuntimeException("wrong data");
        }
    }
}
