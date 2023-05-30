package com.atc.be.gateway.service;

import com.atc.be.gateway.response.CarDetectionDatasetInfoResponse;
import com.atc.be.gateway.response.CarDetectionTestCarModelResponse;
import com.atc.be.gateway.util.Connector;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarDetectionService {

    private final String CAR_DETECTION_SERVICE_URL = "http://localhost:5003";
    private final ObjectMapper objectMapper;
    private final Connector connector;

    public ResponseEntity<CarDetectionDatasetInfoResponse> getDatasetInfo(){
        return connector.connect(CAR_DETECTION_SERVICE_URL, "/car-dataset-info", HttpMethod.GET, CarDetectionDatasetInfoResponse.class, Optional.empty());
    }

    public ResponseEntity<CarDetectionTestCarModelResponse> testCarModel(MultipartFile image) throws IOException {
        ResponseEntity<String> response = connector.connectPostFile(CAR_DETECTION_SERVICE_URL, "/test-model", image);
        CarDetectionTestCarModelResponse carDetectionTestCarModelResponse = objectMapper.readValue(response.getBody(), CarDetectionTestCarModelResponse.class);
        return ResponseEntity.ok(carDetectionTestCarModelResponse);
    }
}
