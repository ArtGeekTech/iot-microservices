package com.artgeektech.iotmicroservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "airdata")
public class AirData implements Serializable {
    private Double temperature;
    private Double humidity;
    private Double pm2p5;
    private Double co2;
    private Date timestamp;
}
