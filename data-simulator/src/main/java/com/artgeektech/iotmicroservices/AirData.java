package com.artgeektech.iotmicroservices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirData {
    private double temperature;
    private double humidity;
    private double pm2p5;
    private double co2;
}
