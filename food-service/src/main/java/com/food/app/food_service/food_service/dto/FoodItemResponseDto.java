package com.food.app.food_service.food_service.dto;

import com.food.app.food_service.food_service.enums.FoodType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodItemResponseDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String quantity;
    private boolean outOfStock;
    private FoodType foodType;
    private String restaurentId;
}
