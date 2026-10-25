package dev.tech.rabbitmq_springboot.controller;

import dev.tech.rabbitmq_springboot.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitMQProducer producer;

    public MessageController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ");
    }

}
