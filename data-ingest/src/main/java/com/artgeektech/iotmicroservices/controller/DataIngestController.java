package com.artgeektech.iotmicroservices.controller;

import com.artgeektech.iotmicroservices.Constants;
import com.artgeektech.iotmicroservices.model.AirData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.Timestamp;


@RestController
@RequestMapping("/iot/airdata")
public class DataIngestController {

    private static final Logger logger = LoggerFactory.getLogger(DataIngestController.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Exchange exchange;

    @PostMapping("/ingest")
    public AirData ingest(@Valid @RequestBody AirData airData) {
        preprocess(airData);
        rabbitTemplate.convertAndSend(exchange.getName(), Constants.ROUTING_KEY, airData);
        logger.info("ingested data: " + airData.toString());
        return airData;
    }

    private void preprocess(AirData airData) {
        airData.setTimestamp(new Timestamp(System.currentTimeMillis()));
    }
}
