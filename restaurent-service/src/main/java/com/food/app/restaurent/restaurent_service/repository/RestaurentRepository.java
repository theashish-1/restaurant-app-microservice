package com.food.app.restaurent.restaurent_service.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.app.restaurent.restaurent_service.entities.Restuarant;

public interface RestaurentRepository extends JpaRepository<Restuarant, UUID>{

    Optional<Restuarant> findByName(String name);
    
}
