package com.dsc.frm.springbootkafkademo.controller;

import com.dsc.frm.springbootkafkademo.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DSchneider
 */
@RestController
@RequestMapping("/api/v1/kafka")
public class MsgController {
    private KafkaProducer kafkaProducer;

    public MsgController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    // http://localhost:8080/api/v1/kafka/publish?message=coucou
    @GetMapping("publish")
    public ResponseEntity<String> publish(@RequestParam("message") String msg){
        kafkaProducer.sendMessage(msg);
        return ResponseEntity.ok("Message sent ok");
    }
}

