package com.dsc.frm.springbootkafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author DSchneider
 */
@Configuration
public class KafkaTopicConfig {

    @Value("${dsc.spring.kafka.topic.name}")
    private String topicName;

    @Value("${dsc.spring.kafka.topic-json.name}")
    private String topicJsonName;


    @Bean
    public NewTopic dscTopic() {
        //nb: attribution d'un nb de partitions par defaut
        return TopicBuilder.name(topicName).build();
    }

    @Bean
    public NewTopic dscJsonTopic() {
        //nb: attribution d'un nb de partitions par defaut
        return TopicBuilder.name(topicJsonName).build();
    }

}

