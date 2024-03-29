package com.dsc.frm.springbootkafkademo.kafka;

import com.dsc.frm.springbootkafkademo.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author DSchneider
 */
@Service
public class JsonKafkaConsumer {
    //cette classe doit subscribe au topic JSON

    private static Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    @KafkaListener(topics = "${dsc.spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User user) {
        LOGGER.info(String.format("User consumed : %s", user.toString()));
    }
}
