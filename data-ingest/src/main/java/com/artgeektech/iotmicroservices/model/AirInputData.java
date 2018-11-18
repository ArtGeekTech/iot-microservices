package com.artgeektech.iotmicroservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirInputData implements Serializable {
//    private Double temperature;
//    private Double humidity;
//    private Double pm2p5;
//    private Double co2;

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

}
