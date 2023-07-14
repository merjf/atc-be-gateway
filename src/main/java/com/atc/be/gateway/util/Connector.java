package com.atc.be.gateway.util;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class Connector {

    private final RestTemplate restTemplate;

    public <T> ResponseEntity<T> connect(String serviceURL, String serviceEndpoint, HttpMethod method, Class reponseClass, Optional body) {
        return restTemplate.exchange(serviceURL + serviceEndpoint,
                method,
                new HttpEntity<>(body.orElse(null), null),
                reponseClass);
    }

    public ResponseEntity<String> connectPost(String serviceURL, String serviceEndpoint) {
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        return restTemplate.postForEntity(serviceURL + serviceEndpoint,
                requestEntity,
                String.class);
    }

    public ResponseEntity<String> connectPostFile(String serviceURL, String serviceEndpoint, MultipartFile file) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, String> fileMap = new LinkedMultiValueMap<>();
        ContentDisposition contentDisposition = ContentDisposition
                .builder("form-data")
                .name("file")
                .filename(file.getOriginalFilename())
                .build();

        fileMap.add(HttpHeaders.CONTENT_DISPOSITION, contentDisposition.toString());
        HttpEntity<byte[]> fileEntity = new HttpEntity<>(file.getBytes(), fileMap);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", fileEntity);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        return restTemplate.postForEntity(serviceURL + serviceEndpoint,
                requestEntity,
                String.class);
    }
}
