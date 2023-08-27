package com.atc.be.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ATCGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ATCGatewayApplication.class, args);
	}
}