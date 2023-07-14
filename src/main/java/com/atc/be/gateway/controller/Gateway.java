package com.atc.be.gateway.controller;

import com.atc.be.gateway.response.DashboardDataResponse;
import com.atc.be.gateway.response.DashboardLoadDataResponse;
import com.atc.be.gateway.response.ObjectDetectionLoadDatasetResponse;
import com.atc.be.gateway.response.ObjectDetectionTestModelResponse;
import com.atc.be.gateway.service.DashboardService;
import com.atc.be.gateway.service.ObjectDetectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "atc")
public class Gateway {

    private final ObjectDetectionService objectDetectionService;
    private final DashboardService dashboardService;

    @GetMapping(path = "/load-dataset")
    public ResponseEntity<ObjectDetectionLoadDatasetResponse> getLoadDatasetObjectDetection(@RequestParam("dataset") String dataset) {
        ResponseEntity<ObjectDetectionLoadDatasetResponse> response = objectDetectionService.loadDataset(dataset);
        if(response.getBody() != null){
            return ResponseEntity.ok(response.getBody());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path = "/test-object-model")
    public ResponseEntity<ObjectDetectionTestModelResponse> testModelObjectDetection(@RequestBody() MultipartFile image) throws IOException {
        ResponseEntity<ObjectDetectionTestModelResponse> response = objectDetectionService.testModel(image);
        if(response.getBody() != null){
            return ResponseEntity.ok(response.getBody());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path = "/load-data")
    public ResponseEntity<DashboardLoadDataResponse> loadDataDashboard(@RequestBody() MultipartFile file) throws IOException {
        ResponseEntity<DashboardLoadDataResponse> response = dashboardService.loadData(file);
        if(response.getBody() != null){
            return ResponseEntity.ok(response.getBody());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/compute-data")
    public ResponseEntity<DashboardDataResponse> computeDataDashboard() throws IOException {
        ResponseEntity<DashboardDataResponse> response = dashboardService.computeData();
        if(response.getBody() != null){
            return ResponseEntity.ok(response.getBody());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
