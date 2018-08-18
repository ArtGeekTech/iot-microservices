package com.artgeektech.iotmicroservices.controller;

import com.artgeektech.iotmicroservices.model.AirData;
import org.springframework.web.bind.annotation.*;


@RestController
public class DataIngestController {

    @PostMapping("/iot/airdata")
    public AirData ingest(@RequestBody AirData airData) {
        return airData;
    }
}
