package com.artgeektech.iotmicroservices;

import com.artgeektech.iotmicroservices.model.AirRawData;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class DataSimulatorApplication {

    private static final String resourceUrl = "http://localhost:9001/iot/airdata/ingest";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final Random random = new Random();
    private static double minVal = 10;
    private static double maxVal = 30;
    private static Timer timer = new Timer();
    private static int interval = 1000;

    public static void main(String[] args) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                AirRawData payload = new AirRawData(genRandom(), genRandom(), genRandom(), genRandom());
                HttpEntity<AirRawData> request = new HttpEntity<>(payload);
                restTemplate.postForObject(resourceUrl, request, AirRawData.class);
            }
        }, 0, interval);
    }

    private static double genRandom() {
        int randInt = random.nextInt(5);
        if (randInt == 0) {
            return 100;
        } else {
            return minVal + random.nextDouble() * (maxVal - minVal);
        }
    }
}
