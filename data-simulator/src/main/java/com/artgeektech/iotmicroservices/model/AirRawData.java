package com.artgeektech.iotmicroservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirRawData implements Serializable {
    private double temperature;
    private double humidity;
    private double pm2p5;
    private double co2;
}
