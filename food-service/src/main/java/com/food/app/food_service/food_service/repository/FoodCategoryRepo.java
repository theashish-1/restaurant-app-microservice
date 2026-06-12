package com.food.app.food_service.food_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.app.food_service.food_service.entities.FoodCategory;

public interface FoodCategoryRepo extends JpaRepository<FoodCategory, Long>{
    
}
