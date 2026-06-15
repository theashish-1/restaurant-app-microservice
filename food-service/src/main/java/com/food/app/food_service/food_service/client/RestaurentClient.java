package com.food.app.food_service.food_service.client;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.food.app.food_service.food_service.client.dto.RestaurentDto;

@FeignClient(name = "restaurent-service", url = "http://localhost:9091")
public interface RestaurentClient {

    @GetMapping("/api/restaurants/{id}")
    public RestaurentDto getRestaurantById(@PathVariable UUID id);
    
}
