package com.food.app.food_service.food_service.services;

import java.util.List;

import com.food.app.food_service.food_service.dto.FoodCategoryDto;
import com.food.app.food_service.food_service.dto.FoodCategoryRequestDto;
import com.food.app.food_service.food_service.dto.FoodItemRequestDto;
import com.food.app.food_service.food_service.dto.FoodItemResponseDto;

public interface FoodService {
    FoodCategoryDto createCategory(FoodCategoryRequestDto categoryDto);
    List<FoodCategoryDto> getAllCategories();
    FoodCategoryDto getCategoryById(Long id);
    void deleteCategory(Long id);

    // Food Item Operations
    FoodItemResponseDto createFoodItem(FoodItemRequestDto itemDto);
    List<FoodItemResponseDto> getAllFoodItems();
    FoodItemResponseDto getFoodItemById(Long id);
    List<FoodItemResponseDto> getFoodItemsByRestaurant(String restaurantId);
    void deleteFoodItem(Long id);
}
