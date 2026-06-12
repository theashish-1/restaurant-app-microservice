package com.food.app.food_service.food_service.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.food.app.food_service.food_service.dto.FoodCategoryDto;
import com.food.app.food_service.food_service.dto.FoodCategoryRequestDto;
import com.food.app.food_service.food_service.dto.FoodItemRequestDto;
import com.food.app.food_service.food_service.dto.FoodItemResponseDto;
import com.food.app.food_service.food_service.entities.FoodCategory;
import com.food.app.food_service.food_service.entities.FoodItem;
import com.food.app.food_service.food_service.repository.FoodCategoryRepo;
import com.food.app.food_service.food_service.repository.FoodItemRepo;
import com.food.app.food_service.food_service.services.FoodService;

import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodCategoryRepo categoryRepository;
    private final FoodItemRepo itemRepository;

    @Override
    @Transactional
    public FoodCategoryDto createCategory(FoodCategoryRequestDto dto) {
        FoodCategory category = new FoodCategory();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        return mapToCategoryDto(categoryRepository.save(category));
    }

    @Override
    @Transactional(readOnly = true)
    public List<FoodCategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(this::mapToCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public FoodCategoryDto getCategoryById(Long id) {
        FoodCategory category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        return mapToCategoryDto(category);
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        FoodCategory category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        categoryRepository.delete(category);
    }

    // ===================================================================
    // FOOD ITEM METHODS
    // ===================================================================
    @Override
    @Transactional
    public FoodItemResponseDto createFoodItem(FoodItemRequestDto dto) {
        FoodCategory category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + dto.getCategoryId()));

        FoodItem item = new FoodItem();
        item.setName(dto.getName());
        item.setDescription(dto.getDescription());
        item.setPrice(dto.getPrice());
        item.setQuantity(dto.getQuantity());
        item.setOutOfStock(dto.isOutOfStock());
        item.setFoodType(dto.getFoodType());
        item.setRestaurentId(dto.getRestaurentId());
        item.setFoodCategory(category);

        return mapToItemResponseDto(itemRepository.save(item));
    }

    @Override
    @Transactional(readOnly = true)
    public List<FoodItemResponseDto> getAllFoodItems() {
        return itemRepository.findAll().stream()
                .map(this::mapToItemResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public FoodItemResponseDto getFoodItemById(Long id) {
        FoodItem item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food Item not found with id: " + id));
        return mapToItemResponseDto(item);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FoodItemResponseDto> getFoodItemsByRestaurant(String restaurantId) {
        return itemRepository.findByRestaurentId(restaurantId).stream()
                .map(this::mapToItemResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteFoodItem(Long id) {
        if (!itemRepository.existsById(id)) {
            throw new RuntimeException("Food Item not found with id: " + id);
        }
        itemRepository.deleteById(id);
    }

    private FoodCategoryDto mapToCategoryDto(FoodCategory category) {
        FoodCategoryDto dto = new FoodCategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        if (category.getFoodItems() != null) {
            dto.setFoodItems(category.getFoodItems().stream()
                    .map(this::mapToItemResponseDto)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    private FoodItemResponseDto mapToItemResponseDto(FoodItem item) {
        FoodItemResponseDto dto = new FoodItemResponseDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setDescription(item.getDescription());
        dto.setPrice(item.getPrice());
        dto.setQuantity(item.getQuantity());
        dto.setOutOfStock(item.isOutOfStock());
        dto.setFoodType(item.getFoodType());
        dto.setRestaurentId(item.getRestaurentId());
        return dto;
    }


    
}
