package com.atc.be.gateway.response;

import lombok.Data;

@Data
public class CarDetectionDatasetInfoResponse {
    public Integer accuracy;
    public String carClass;
}
