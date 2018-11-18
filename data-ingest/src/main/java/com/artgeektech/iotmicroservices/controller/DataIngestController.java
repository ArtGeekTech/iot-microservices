package com.artgeektech.iotmicroservices.controller;

import com.artgeektech.iotmicroservices.Constants;
import com.artgeektech.iotmicroservices.model.AirData;
import com.artgeektech.iotmicroservices.model.AirInputData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;


@RestController
public class DataIngestController {

    private static final Logger logger = LoggerFactory.getLogger(DataIngestController.class);

//    @Autowired
//    private SimpMessagingTemplate messagingTemplate;


//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Exchange exchange;





    @PostMapping("/airdata/ingest")  // validate payload from request body
    public AirData ingest(@Valid @RequestBody AirInputData rawData) {
        // preprocess
        AirData airData = preprocess(rawData);

        // publish to MQ
        rabbitTemplate.convertAndSend(exchange.getName(), Constants.ROUTING_KEY_HISTORY, airData);

        rabbitTemplate.convertAndSend(exchange.getName(), Constants.ROUTING_KEY_REALTIME, airData);

        logger.info("ingested data: " + airData.toString());
        return airData;
    }



    private AirData preprocess(AirInputData rawData) {
        AirData airData = new AirData();

        // add more info from system
        airData.setTimestamp(new Date());
//        airData.setSensorId()...

        // standardize data format
        airData.setHumidity(Math.round(rawData.getHumidity() * 100.0) / 100.0);
        airData.setTemperature(Math.round(rawData.getTemperature() * 100.0) / 100.0);
        airData.setCo2(Math.round(rawData.getCo2() * 100.0) / 100.0);
        airData.setPm2p5(Math.round(rawData.getPm2p5() * 100.0) / 100.0);

        return airData;
    }
}
