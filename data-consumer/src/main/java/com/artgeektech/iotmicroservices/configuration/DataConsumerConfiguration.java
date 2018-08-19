package com.artgeektech.iotmicroservices.configuration;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by guang on 12:00 PM 8/18/18.
 */
@Configuration
public class DataConsumerConfiguration {
    @Bean
    public Exchange dataExchange() {
        return new TopicExchange("DataExchange");
    }

    @Bean
    public Queue queue() {
        return new Queue("DataQueue");
    }

    @Bean
    public Binding binding(Queue queue, Exchange dataExchange) {
        return BindingBuilder
            .bind(queue)
            .to(dataExchange)
            .with("airdata.ingested").noargs();
    }

}
