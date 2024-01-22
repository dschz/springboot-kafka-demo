package com.dsc.frm.springbootkafkademo.controller;

import com.dsc.frm.springbootkafkademo.kafka.JsonKafkaProducer;
import com.dsc.frm.springbootkafkademo.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DSchneider
 */
@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMsgController {

    private JsonKafkaProducer kafkaProducer;

    public JsonMsgController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("publish JSON user to topic");
    }
}
