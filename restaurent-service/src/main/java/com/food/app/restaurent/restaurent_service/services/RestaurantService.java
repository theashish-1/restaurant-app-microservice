package com.food.app.restaurent.restaurent_service.services;

import java.util.List;
import java.util.UUID;

import com.food.app.restaurent.restaurent_service.dto.RestaurantDto;

public interface RestaurantService {
    RestaurantDto saveRestaurant(RestaurantDto restaurantDto);
    RestaurantDto updateRestaurant(UUID id, RestaurantDto restaurantDto);
    RestaurantDto getRestaurantById(UUID id);
    RestaurantDto getRestaurantByName(String name);
    void deleteRestaurantByName(String name);
    List<RestaurantDto> getAllRestaurants(); // Added for completeness
}
