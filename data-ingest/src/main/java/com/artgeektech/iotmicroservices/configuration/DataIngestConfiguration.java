package com.artgeektech.iotmicroservices.configuration;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by guang on 3:43 AM 8/18/18.
 */

@Configuration
public class DataIngestConfiguration {
    @Bean
    public Exchange dataExchange() {
        return new TopicExchange("DataExchange");
    }
}
