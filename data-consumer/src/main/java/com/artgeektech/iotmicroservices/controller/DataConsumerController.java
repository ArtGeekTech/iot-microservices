package com.artgeektech.iotmicroservices.controller;

import com.artgeektech.iotmicroservices.Constants;
import com.artgeektech.iotmicroservices.model.AirData;
import com.artgeektech.iotmicroservices.repository.AirDataRepository;
import com.artgeektech.iotmicroservices.service.RuleEngineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by guang on 11:56 AM 8/18/18.
 */
@Controller
public class DataConsumerController {
    private static final Logger logger = LoggerFactory.getLogger(DataConsumerController.class);

    @Autowired
    private AirDataRepository airDataRepository;

    @Autowired
    private RuleEngineService ruleEngineService;

    @RabbitListener(queues = Constants.QUEUE_NAME)  // Subscribe to the Message Queue
    public void process(AirData airData) {

        logger.info("Received message from MQ '{}'", airData);

        // apply rule engine and trigger actions
        ruleEngineService.applyRules(airData);

        // save to DB
        airDataRepository.save(airData);

        logger.info("Saved message to Mongo DB '{}'", airData);
        logger.info("Total message saved in Mongo DB is:  " + airDataRepository.findAll().size());
    }
}
