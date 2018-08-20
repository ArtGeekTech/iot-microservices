package com.artgeektech.iotmicroservices;

import com.artgeektech.iotmicroservices.model.AirData;
import com.artgeektech.iotmicroservices.repository.AirDataRepository;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;

/**
 * Created by guang on 11:42 AM 8/18/18.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableRabbit
public class DataConsumerApplication {

    @Autowired
    private static AirDataRepository airDataRepository;


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
        System.out.println("Main in Mongo");

        // save to DB
        AirData data1 = new AirData(
            1d, 1d, 1d, 1d,
            new Timestamp(System.currentTimeMillis()));
        AirData data2 = new AirData(
            1d, 1d, 1d, 1d,
            new Timestamp(System.currentTimeMillis()));
        AirData data3 = new AirData(
            2d, 1d, 1d, 1d,
            new Timestamp(System.currentTimeMillis()));
        airDataRepository.save(data1);
        airDataRepository.save(data2);
        airDataRepository.save(data3);
        airDataRepository.save(data3);

        for (AirData data: airDataRepository.findAll()) {
            System.out.println("printing Mongo DB");
            System.out.println(data);
            System.out.println(data.toString());
        }
    }
}
