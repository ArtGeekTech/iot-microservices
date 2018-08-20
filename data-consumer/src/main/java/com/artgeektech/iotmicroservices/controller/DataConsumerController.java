package com.artgeektech.iotmicroservices.controller;

import com.artgeektech.iotmicroservices.Constants;
import com.artgeektech.iotmicroservices.model.AirData;
import com.artgeektech.iotmicroservices.repository.AirDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by guang on 11:56 AM 8/18/18.
 */
@Component
public class DataConsumerController {
    private static final Logger logger = LoggerFactory.getLogger(DataConsumerController.class);

    @Autowired
    private AirDataRepository airDataRepository;

    @RabbitListener(queues = Constants.QUEUE_NAME)
    public void process(AirData airData) {

        logger.info("Received message from MQ '{}'", airData);

        // simple rule engine handling
        if (airData.getTemperature() > 50) {
            triggerActionAlert("Temperature too high!!");
        }
        if (airData.getCo2() > 50) {
            triggerActionAlert("CO2 too high!!!");
        }
        if (airData.getPm2p5() > 50) {
            triggerActionAlert("Too much Dust!!!");
        }

        // save to DB
        airDataRepository.save(airData);
        logger.info("Saved message to Mongo DB '{}'", airData);
        logger.info("Total message saved in Mongo DB is:  " + airDataRepository.findAll().size());

    }

    private void triggerActionAlert(String msg) {
        System.out.println("\n\n!!!!!Sending the Email Alert: " + msg + "\n\n");
    }
}
