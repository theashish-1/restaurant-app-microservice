package com.food.app.food_service.food_service.client;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.food.app.food_service.food_service.client.dto.RestaurentDto;
import com.food.app.food_service.food_service.config.AppConstants;

@FeignClient(name = AppConstants.RESTAURENT_SERVICE_NAME)
public interface RestaurentClient {

    @GetMapping("/api/restaurants/{id}")
    public RestaurentDto getRestaurantById(@PathVariable Long id);
    
}
