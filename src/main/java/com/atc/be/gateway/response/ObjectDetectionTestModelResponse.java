package com.atc.be.gateway.response;

import com.atc.be.gateway.response.model.Prediction;
import lombok.Data;

import java.util.List;

@Data
public class ObjectDetectionTestModelResponse {

    public List<Prediction> predictions;
    public String message;

}
