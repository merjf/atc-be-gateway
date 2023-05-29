package com.atc.be.gateway.response;

import lombok.Data;

@Data
public class CarDetectionTestCarModelResponse {
    public Float predictions;
    public String classes;
    public String message;
}
