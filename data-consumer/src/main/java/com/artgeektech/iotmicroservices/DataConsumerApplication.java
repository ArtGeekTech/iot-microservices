package com.artgeektech.iotmicroservices;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by guang on 11:42 AM 8/18/18.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableRabbit
public class DataConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataConsumerApplication.class, args);
    }
}
