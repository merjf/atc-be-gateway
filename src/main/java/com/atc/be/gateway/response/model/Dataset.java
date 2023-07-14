package com.atc.be.gateway.response.model;

import lombok.Data;

@Data
public class Dataset{
    public String name;
    public String id;
    public String image;
    public String[] classes;
}