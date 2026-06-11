package com.food.app.restaurent.restaurent_service.controller;

import com.food.app.restaurent.restaurent_service.dto.RestaurantDto;
import com.food.app.restaurent.restaurent_service.services.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    // 1. Create a new Restaurant
    @PostMapping
    public ResponseEntity<RestaurantDto> createRestaurant(@RequestBody RestaurantDto restaurantDto) {
        RestaurantDto savedRestaurant = restaurantService.saveRestaurant(restaurantDto);
        return new ResponseEntity<>(savedRestaurant, HttpStatus.CREATED);
    }

    // 2. Update an existing Restaurant
    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDto> updateRestaurant(@PathVariable UUID id, @RequestBody RestaurantDto restaurantDto) {
        RestaurantDto updatedRestaurant = restaurantService.updateRestaurant(id, restaurantDto);
        return ResponseEntity.ok(updatedRestaurant);
    }

    // 3. Get Restaurant by ID
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable UUID id) {
        RestaurantDto restaurantDto = restaurantService.getRestaurantById(id);
        return ResponseEntity.ok(restaurantDto);
    }

    // 4. Find Restaurant by Name
    // Endpoint look like: /api/restaurants/search?name=PizzaHut
    @GetMapping("/search")
    public ResponseEntity<RestaurantDto> getRestaurantByName(@RequestParam String name) {
        RestaurantDto restaurantDto = restaurantService.getRestaurantByName(name);
        return ResponseEntity.ok(restaurantDto);
    }

    // 5. Delete Restaurant by Name
    @DeleteMapping("/search")
    public ResponseEntity<String> deleteRestaurantByName(@RequestParam String name) {
        restaurantService.deleteRestaurantByName(name);
        return ResponseEntity.ok("Restaurant with name '" + name + "' deleted successfully.");
    }

    // 6. Get All Restaurants
    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
        List<RestaurantDto> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }
}
