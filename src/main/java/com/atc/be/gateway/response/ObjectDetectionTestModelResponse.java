package com.atc.be.gateway.response;

import lombok.Data;

import java.util.List;

@Data
public class ObjectDetectionTestModelResponse {

    public List<ObjectDetectionPrediction> predictions;
    public String message;

    @Data
    static class ObjectDetectionPrediction {
        public Float accuracy;
        public String model;
    }
}
