package com.atc.be.gateway.routing.factory;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import java.util.function.Function;

public interface RoutingFactoryInterface {

    Function<PredicateSpec, Buildable<Route>> prepareRoute();
}
