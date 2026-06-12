package com.food.app.food_service.food_service.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.cdi.Eager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="food_categories")
@Setter
@Getter
public class FoodCategory {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    @OneToMany(mappedBy = "foodCategory",cascade = jakarta.persistence.CascadeType.ALL,orphanRemoval = true)
    private List<FoodItem> foodItems = new ArrayList<>();


}
