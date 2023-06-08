package com.atc.be.gateway.response;

import lombok.Data;

@Data
public class ObjectDetectionLoadDatasetResponse {
    public Dataset dataset;
    public String message;

    @Data
    public class Dataset{
        public String name;
        public String id;
        public String image;
        public String[] classes;
    }
}
