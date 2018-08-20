package com.artgeektech.iotmicroservices.repository;

import com.artgeektech.iotmicroservices.model.AirData;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by guang on 7:04 AM 8/19/18.
 */
public interface AirDataRepository extends MongoRepository<AirData, String> {
}
