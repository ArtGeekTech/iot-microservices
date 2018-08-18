package com.artgeektech.iotmicroservices;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class DataSimulatorApplication {

    private static final String resourceUrl = "http://data-ingest:9001/iot/airdata/";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static double minVal = 10;
    private static double maxVal = 25;
    private static Timer timer = new Timer();
    private static int interval = 1000;

    public static void main(String[] args) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                AirData payload = new AirData(genRandomDouble(), genRandomDouble(), genRandomDouble(), genRandomDouble());
                HttpEntity<AirData> request = new HttpEntity<>(payload);
                restTemplate.postForObject(resourceUrl, request, AirData.class);
            }
        }, 0, interval);
    }

    private static double genRandomDouble() {
        return minVal + new Random().nextDouble() * (maxVal - minVal);
    }
}
