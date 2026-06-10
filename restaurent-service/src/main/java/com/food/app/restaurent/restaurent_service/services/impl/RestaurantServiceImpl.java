package com.food.app.restaurent.restaurent_service.services.impl;

import com.food.app.restaurent.restaurent_service.dto.RestaurantDto;
import com.food.app.restaurent.restaurent_service.entities.Restuarant;
import com.food.app.restaurent.restaurent_service.repository.RestaurentRepository;
import com.food.app.restaurent.restaurent_service.services.RestaurantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

  private final RestaurentRepository restaurantRepository;


    // Constructor Injection
    public RestaurantServiceImpl(RestaurentRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public RestaurantDto saveRestaurant(RestaurantDto dto) {
        Restuarant restaurant = mapToEntity(dto);
        Restuarant savedRestaurant = restaurantRepository.save(restaurant);
        return mapToDto(savedRestaurant);
    }

    @Override
    public RestaurantDto updateRestaurant(Long id, RestaurantDto dto) {
        Restuarant existingRestaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + id));

        // Update fields
        existingRestaurant.setName(dto.getName());
        existingRestaurant.setAddress(dto.getAddress());
        existingRestaurant.setPhone(dto.getPhone());
        existingRestaurant.setPictures(dto.getPictures());
        existingRestaurant.setOpen(dto.isOpen());
        existingRestaurant.setOpenTime(dto.getOpenTime());
        existingRestaurant.setCloseTime(dto.getCloseTime());
        existingRestaurant.setDescription(dto.getDescription());

        Restuarant updatedRestaurant = restaurantRepository.save(existingRestaurant);
        return mapToDto(updatedRestaurant);
    }

    @Override
    public RestaurantDto getRestaurantById(Long id) {
        Restuarant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + id));
        return mapToDto(restaurant);
    }

    @Override
    public RestaurantDto getRestaurantByName(String name) {
        Restuarant restaurant = restaurantRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with name: " + name));
        return mapToDto(restaurant);
    }

    @Override
    @Transactional // Required for delete operations that aren't by ID
    public void deleteRestaurantByName(String name) {
        Restuarant restaurant = restaurantRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with name: " + name));
        restaurantRepository.delete(restaurant);
    }

    @Override
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    // --- Helper Mapper Methods ---
    private Restuarant mapToEntity(RestaurantDto dto) {
        Restuarant entity = new Restuarant();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setPhone(dto.getPhone());
        entity.setPictures(dto.getPictures());
        entity.setOpen(dto.isOpen());
        entity.setOpenTime(dto.getOpenTime());
        entity.setCloseTime(dto.getCloseTime());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    private RestaurantDto mapToDto(Restuarant entity) {
        RestaurantDto dto = new RestaurantDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setPhone(entity.getPhone());
        dto.setPictures(entity.getPictures());
        dto.setOpen(entity.isOpen());
        dto.setOpenTime(entity.getOpenTime());
        dto.setCloseTime(entity.getCloseTime());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}