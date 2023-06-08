package com.atc.be.gateway.service;

import com.atc.be.gateway.response.ObjectDetectionLoadDatasetResponse;
import com.atc.be.gateway.response.ObjectDetectionTestModelResponse;
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
public class ObjectDetectionService {

    private final String OBJECT_DETECTION_SERVICE_URL = "http://localhost:5003";
    private final ObjectMapper objectMapper;
    private final Connector connector;

    public ResponseEntity<ObjectDetectionLoadDatasetResponse> loadDataset(String dataset){
        return connector.connect(OBJECT_DETECTION_SERVICE_URL, "/load-dataset?dataset="+dataset, HttpMethod.GET, ObjectDetectionLoadDatasetResponse.class, Optional.empty());
    }

    public ResponseEntity<ObjectDetectionTestModelResponse> testModel(MultipartFile image) throws IOException {
        ResponseEntity<String> response = connector.connectPostFile(OBJECT_DETECTION_SERVICE_URL, "/test-model", image);
        ObjectDetectionTestModelResponse objectDetectionTestModelResponse = objectMapper.readValue(response.getBody(), ObjectDetectionTestModelResponse.class);
        return ResponseEntity.ok(objectDetectionTestModelResponse);
    }
}
