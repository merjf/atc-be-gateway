package com.atc.be.gateway.util;

import com.atc.be.gateway.response.CarDetectionDatasetInfoResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class Connector {

    private final RestTemplate restTemplate;

    public <T> ResponseEntity<T> connect(String serviceURL, String serviceEndpoint, HttpMethod method, Class reponseClass, Optional body) {
        return restTemplate.exchange(serviceURL + serviceEndpoint,
                method,
                new HttpEntity<>(body, null),
                reponseClass);
    }
}
