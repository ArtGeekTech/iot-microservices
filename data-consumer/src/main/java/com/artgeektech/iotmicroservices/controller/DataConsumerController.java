package com.artgeektech.iotmicroservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by guang on 11:56 AM 8/18/18.
 */
@Component
public class DataConsumerController {
    private static final Logger logger = LoggerFactory.getLogger(DataConsumerController.class);
    private static final String routingKey = "airdata.ingested";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Exchange exchange;

    @RabbitListener(queues="DataQueue")
    public void receive1(String message) {
        logger.info("Received message '{}'", message);
    }

//    @RabbitListener(queues="DataQueue")
//    public void receive2(AirData message) {
//        logger.info("Received message '{}'", message.toString());
//    }
}
