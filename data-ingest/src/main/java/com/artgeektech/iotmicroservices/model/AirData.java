package com.artgeektech.iotmicroservices.model;

import lombok.Data;

@Data
public class AirData {
    private String temperature;
    private String humidity;
    private String voc;
    private String pm2p5;
    private String co2;

}
