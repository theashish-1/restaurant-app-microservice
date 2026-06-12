package com.food.app.food_service.food_service.controller;

import com.food.app.food_service.food_service.dto.FoodCategoryDto;
import com.food.app.food_service.food_service.dto.FoodCategoryRequestDto;
import com.food.app.food_service.food_service.services.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food/categories")
@RequiredArgsConstructor
public class FoodCategoryController {

    private final FoodService foodService;

    @PostMapping
    public ResponseEntity<FoodCategoryDto> createCategory(@RequestBody FoodCategoryRequestDto dto) {
        return new ResponseEntity<>(foodService.createCategory(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FoodCategoryDto>> getAllCategories() {
        return ResponseEntity.ok(foodService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodCategoryDto> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(foodService.getCategoryById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        foodService.deleteCategory(id);
        return ResponseEntity.ok("Category and its corresponding food items deleted successfully.");
    }
}
