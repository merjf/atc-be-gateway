package com.atc.be.gateway.routing.factory;

import com.atc.be.gateway.config.ServiceURLs;
import lombok.Builder;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.Route.AsyncBuilder;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.function.Function;

import static org.springframework.cloud.gateway.filter.factory.DedupeResponseHeaderGatewayFilterFactory.Strategy.RETAIN_FIRST;

@Builder
public class MontecarloEstimationServiceFactory implements RoutingFactoryInterface{

    private final ServiceURLs serviceURLs;

    @Override
    public Function<PredicateSpec, Buildable<Route>> prepareRoute() {
        return predicateSpec ->
                predicateSpec
                        .path("/montecarlo-estimation/**")
                        .and()
                        .method(HttpMethod.GET, HttpMethod.POST)
                        .filters(
                                gatewayFilterSpec ->
                                        gatewayFilterSpec
                                                .dedupeResponseHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, String.valueOf(RETAIN_FIRST))
                                                .rewritePath("/montecarlo-estimation", "/")
                        )
                        .uri(serviceURLs.getMontecarloEstimationServiceURL())
                ;
    }
}
