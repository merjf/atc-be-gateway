package com.atc.be.gateway.controller;

import com.atc.be.gateway.response.CarDetectionDatasetInfoResponse;
import com.atc.be.gateway.service.CarDetectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "atc")
public class Gateway {

    private final CarDetectionService carDetectionService;

    @GetMapping(path = "/car-dataset-info")
    public ResponseEntity<CarDetectionDatasetInfoResponse> getCarDetectionDatasetInfo() {
        ResponseEntity<CarDetectionDatasetInfoResponse> response = carDetectionService.getDatasetInfo();
        if(response.getBody() != null){
            return ResponseEntity.ok(response.getBody());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
