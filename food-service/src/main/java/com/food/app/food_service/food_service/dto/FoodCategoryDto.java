package com.food.app.food_service.food_service.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodCategoryDto {
    private Long id;
    private String name;
    private String description;
    private List<FoodItemResponseDto> foodItems;
}
