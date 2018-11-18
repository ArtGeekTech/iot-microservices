package com.artgeektech.iotmicroservices.service;

import com.artgeektech.iotmicroservices.model.AirData;
import org.springframework.stereotype.Component;

/**
 * Created by guang on 7:16 PM 8/21/18.
 */
@Component
public class RuleEngineService {

    public void applyRules(AirData airData) {

        if (airData.getTemperature() > 50) {
            triggerActionAlert("Temperature too high!!");
        }
        if (airData.getCo2() > 50) {
            triggerActionAlert("CO2 too high!!!");
        }
        if (airData.getPm2p5() > 50) {
            triggerActionAlert("Too much Dust!!!");
        }
    }

    private void triggerActionAlert(String msg) {
        System.out.println("\n\n!!!!!Sending the Email Alert: " + msg + "\n\n");
    }
}
