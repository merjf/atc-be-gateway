package com.atc.be.gateway.service;

import com.atc.be.gateway.response.DashboardDataResponse;
import com.atc.be.gateway.response.DashboardLoadDataResponse;
import com.atc.be.gateway.response.ObjectDetectionLoadDatasetResponse;
import com.atc.be.gateway.response.ObjectDetectionTestModelResponse;
import com.atc.be.gateway.util.Connector;
import com.fasterxml.jackson.core.JsonProcessingException;
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
public class DashboardService {

    private final String DASHBOARD_SERVICE_URL = "http://localhost:5004";
    private final ObjectMapper objectMapper;
    private final Connector connector;

    public ResponseEntity<DashboardLoadDataResponse> loadData(MultipartFile file) throws IOException {
        ResponseEntity<String> response = connector.connectPostFile(DASHBOARD_SERVICE_URL, "/load-data", file);
        DashboardLoadDataResponse dashboardLoadDataResponse = objectMapper.readValue(response.getBody(), DashboardLoadDataResponse.class);
        return ResponseEntity.ok(dashboardLoadDataResponse);
    }

    public ResponseEntity<DashboardDataResponse> computeData() throws IOException {
        return connector.connect(DASHBOARD_SERVICE_URL, "/compute-data", HttpMethod.GET, DashboardDataResponse.class, Optional.empty());
    }
}
