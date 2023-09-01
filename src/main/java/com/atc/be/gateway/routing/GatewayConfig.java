package com.atc.be.gateway.routing;

import com.atc.be.gateway.config.ServiceURLs;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import static com.atc.be.gateway.routing.SpecificServiceRoutes.addSpecificServiceRoutes;

@Slf4j
@Configuration
public class GatewayConfig {

    /** Method defining routes utilizing Spring - Gateway. */
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder, ServiceURLs urisAndEndpoints) {
        return addSpecificServiceRoutes(builder.routes(), urisAndEndpoints)
                .build();
    }

    @Bean
    public List<GroupedOpenApi> apis(RouteLocator routeLocator) {
        List<GroupedOpenApi> groups = new ArrayList<>();
        List<Route> definitions = routeLocator.getRoutes().collectList().block();
        definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*-service")).forEach(routeDefinition -> {
            String name = routeDefinition.getId().replaceAll("-service", "");
            GroupedOpenApi.builder().pathsToMatch("/" + name.toLowerCase() + "/**").group(name.toLowerCase()).build();
        });
        return groups;
    }
}
