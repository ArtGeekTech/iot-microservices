package com.artgeektech.iotmicroservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirData implements Serializable {
    private Double temperature;
    private Double humidity;
    private Double pm2p5;
    private Double co2;
    private Date timestamp;
}
