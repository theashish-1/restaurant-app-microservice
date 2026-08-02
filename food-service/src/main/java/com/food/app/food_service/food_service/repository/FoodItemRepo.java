package com.food.app.food_service.food_service.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.app.food_service.food_service.entities.FoodItem;

public interface FoodItemRepo extends JpaRepository<FoodItem, Long>{
    List<FoodItem> findByRestaurentId(Long restaurentId);
}
