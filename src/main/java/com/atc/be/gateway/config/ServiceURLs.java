package com.atc.be.gateway.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "url")
public class ServiceURLs {

    /* URLs */
    private String montecarloEstimationServiceURL = "http://localhost:5002";
    private String dashboardServiceURL = "http://localhost:5003";

}
