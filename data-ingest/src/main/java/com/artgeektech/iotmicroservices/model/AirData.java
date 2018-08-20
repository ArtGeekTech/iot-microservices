package com.artgeektech.iotmicroservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirData implements Serializable {

    @NotNull
    @Min(1)
    @Max(100)
    private Double temperature;

    @NotNull
    @Min(1)
    @Max(100)
    private Double humidity;

    @NotNull
    @Min(1)
    @Max(100)
    private Double pm2p5;

    @NotNull
    @Min(1)
    @Max(100)
    private Double co2;

    private Date timestamp;
}
