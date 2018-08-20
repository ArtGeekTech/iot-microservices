package com.artgeektech.iotmicroservices;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * Created by guang on 11:42 AM 8/18/18.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableRabbit
public class DataConsumerApplication {

    @Bean
    public Exchange airDataExchange() {
        return new TopicExchange(Constants.EXCHANGE_NAME);
    }

    @Bean
    public Queue queue() {
        return new Queue(Constants.QUEUE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, Exchange dataExchange) {
        return BindingBuilder
            .bind(queue)
            .to(dataExchange)
            .with(Constants.ROUTING_KEY).noargs();
    }

    public static void main(String[] args) {
        SpringApplication.run(DataConsumerApplication.class, args);
    }
}
