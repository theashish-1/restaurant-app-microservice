package com.food.app.food_service.food_service.controller;

import com.food.app.food_service.food_service.dto.FoodItemRequestDto;
import com.food.app.food_service.food_service.dto.FoodItemResponseDto;
import com.food.app.food_service.food_service.services.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food/items")
@RequiredArgsConstructor
public class FoodItemController {

    private final FoodService foodService;

    @PostMapping
    public ResponseEntity<FoodItemResponseDto> createFoodItem(@RequestBody FoodItemRequestDto dto) {
        return new ResponseEntity<>(foodService.createFoodItem(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FoodItemResponseDto>> getAllFoodItems() {
        return ResponseEntity.ok(foodService.getAllFoodItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodItemResponseDto> getFoodItemById(@PathVariable Long id) {
        return ResponseEntity.ok(foodService.getFoodItemById(id));
    }

    // Microservice endpoint: Fetch all food items tied to a specific restaurant ID from restaurant-service
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<FoodItemResponseDto>> getFoodItemsByRestaurant(@PathVariable String restaurantId) {
        return ResponseEntity.ok(foodService.getFoodItemsByRestaurant(restaurantId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFoodItem(@PathVariable Long id) {
        foodService.deleteFoodItem(id);
        return ResponseEntity.ok("Food Item deleted successfully.");
    }
}
