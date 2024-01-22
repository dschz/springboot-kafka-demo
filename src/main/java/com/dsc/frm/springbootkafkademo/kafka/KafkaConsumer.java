package com.dsc.frm.springbootkafkademo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author DSchneider
 */
@Service
public class KafkaConsumer {
    //cette classe doit subscribe au topic

    private static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    //la valeur du group id consumer est dans application.properties
    @KafkaListener(topics = "${dsc.spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String msg) {
        LOGGER.info(String.format("Message received : %s", msg));
    }

}
