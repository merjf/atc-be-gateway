package com.atc.be.gateway.response.model;

import lombok.Data;

@Data
public class Prediction {
    public Float accuracy;
    public String model;
}