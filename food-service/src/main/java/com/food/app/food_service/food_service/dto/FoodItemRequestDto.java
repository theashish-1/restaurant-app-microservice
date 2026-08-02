package com.food.app.food_service.food_service.dto;

import java.util.UUID;

import com.food.app.food_service.food_service.enums.FoodType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class FoodItemRequestDto {
    private String name;
    private String description;
    private double price;
    private String quantity;
    private boolean outOfStock;
    private FoodType foodType;
    private Long categoryId;
    private Long restaurentId;
}
