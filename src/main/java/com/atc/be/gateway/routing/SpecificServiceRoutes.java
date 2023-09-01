package com.atc.be.gateway.routing;

import com.atc.be.gateway.config.ServiceURLs;
import com.atc.be.gateway.routing.factory.MontecarloEstimationServiceFactory;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder.Builder;

public class SpecificServiceRoutes {
    private SpecificServiceRoutes() {}

    public static Builder addSpecificServiceRoutes(Builder builder, ServiceURLs serviceURLs) {

        return builder
                .route(
                        "ATC-BE-MONTECARLOESTIMATION",
                        MontecarloEstimationServiceFactory.builder()
                                .serviceURLs(serviceURLs)
                                .build()
                                .prepareRoute());
    }
}