package com.artgeektech.iotmicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DataIngestApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataIngestApplication.class, args);
    }
}
