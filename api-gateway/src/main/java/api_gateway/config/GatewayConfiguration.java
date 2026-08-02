package api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes().
                route(
                    "restaurent-service",
                     r -> r.path("/restaurants/**")
                     .filters(filter->filter.rewritePath("/restaurants/?(?<remaining>.*)", "/${remaining}"))
                     .uri("lb://RESTAURENT-SERVICE")
                ).
                route(
                    "food-service",
                     r -> r.path("/foods/**")
                     .filters(filter->filter.rewritePath("/foods/?(?<remaining>.*)", "/${remaining}"))
                     .uri("lb://FOOD-SERVICE")
                ).
                build();
    }
}
