package com.atc.be.gateway.response;

import com.atc.be.gateway.response.model.Dataset;
import lombok.Data;

@Data
public class ObjectDetectionLoadDatasetResponse {
    public Dataset dataset;
    public String message;

}
