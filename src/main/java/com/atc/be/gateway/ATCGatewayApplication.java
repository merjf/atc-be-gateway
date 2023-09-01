package com.atc.be.gateway;

import com.atc.be.gateway.config.ServiceURLs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ServiceURLs.class)
public class ATCGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ATCGatewayApplication.class, args);
	}

}