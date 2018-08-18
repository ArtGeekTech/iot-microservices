package com.artgeektech.iotmicroservices.controller;

import com.artgeektech.iotmicroservices.model.AirData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
public class DataIngestController {

    private static final Logger logger = LoggerFactory.getLogger(DataIngestController.class);

    @PostMapping("/iot/airdata")
    public AirData ingest(@RequestBody AirData airData) {
        logger.info(airData.toString());
        return airData;
    }
}
