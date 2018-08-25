package com.artgeektech.iotmicroservices;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableRabbit
public class DataIngestApplication {

    @Bean
    public Exchange airDataExchange() {
        return new TopicExchange(Constants.EXCHANGE_NAME);
    }

//    @Bean
//    public SimpMessagingTemplate simpMessagingTemplate() {
//        return new SimpMessagingTemplate();
//    }

    public static void main(String[] args) {
        SpringApplication.run(DataIngestApplication.class, args);
    }
}
