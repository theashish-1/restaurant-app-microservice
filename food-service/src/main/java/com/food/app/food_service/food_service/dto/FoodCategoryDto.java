package com.food.app.food_service.food_service.dto;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodCategoryDto {
    private UUID id;
    private String name;
    private String description;
    private List<FoodItemResponseDto> foodItems;
}
