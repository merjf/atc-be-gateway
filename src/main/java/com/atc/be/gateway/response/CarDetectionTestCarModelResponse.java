package com.atc.be.gateway.response;

import lombok.Data;

import java.util.List;

@Data
public class CarDetectionTestCarModelResponse {

    public List<CarDetectionPrediction> predictions;
    public String message;

    @Data
    static class CarDetectionPrediction{
        public Float accuracy;
        public String model;
    }
}
