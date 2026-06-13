package com.food.app.food_service.food_service.services;

import java.util.List;
import java.util.UUID;

import com.food.app.food_service.food_service.dto.FoodCategoryDto;
import com.food.app.food_service.food_service.dto.FoodCategoryRequestDto;
import com.food.app.food_service.food_service.dto.FoodItemRequestDto;
import com.food.app.food_service.food_service.dto.FoodItemResponseDto;

public interface FoodService {
    FoodCategoryDto createCategory(FoodCategoryRequestDto categoryDto);
    List<FoodCategoryDto> getAllCategories();
    FoodCategoryDto getCategoryById(UUID id);
    void deleteCategory(UUID id);

    // Food Item Operations
    FoodItemResponseDto createFoodItem(FoodItemRequestDto itemDto);
    List<FoodItemResponseDto> getAllFoodItems();
    FoodItemResponseDto getFoodItemById(UUID id);
    List<FoodItemResponseDto> getFoodItemsByRestaurant(UUID restaurantId);
    void deleteFoodItem(UUID id);
}
