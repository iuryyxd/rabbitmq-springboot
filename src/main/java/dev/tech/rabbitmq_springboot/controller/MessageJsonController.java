package dev.tech.rabbitmq_springboot.controller;

import dev.tech.rabbitmq_springboot.dto.User;
import dev.tech.rabbitmq_springboot.publisher.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/json")
public class MessageJsonController {

    private RabbitMQJsonProducer jsonProducer;

    public MessageJsonController(RabbitMQJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody() User user) {
        this.jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to RabbitMQ");
    }
}
