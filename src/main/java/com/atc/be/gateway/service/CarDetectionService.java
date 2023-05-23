package com.atc.be.gateway.service;

import com.atc.be.gateway.response.CarDetectionDatasetInfoResponse;
import com.atc.be.gateway.util.Connector;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarDetectionService {

    private final String CAR_DETECTION_URL = "http://localhost:5003";

    private final Connector connector;
    public ResponseEntity<CarDetectionDatasetInfoResponse> getDatasetInfo(){
        return connector.connect(CAR_DETECTION_URL, "/car-dataset-info", HttpMethod.GET, CarDetectionDatasetInfoResponse.class);
    }
}
