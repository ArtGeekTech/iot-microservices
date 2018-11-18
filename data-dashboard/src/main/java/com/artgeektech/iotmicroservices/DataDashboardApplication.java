package com.artgeektech.iotmicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by guang on 1:31 PM 8/26/18.
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
public class DataDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataDashboardApplication.class, args);
    }
}
