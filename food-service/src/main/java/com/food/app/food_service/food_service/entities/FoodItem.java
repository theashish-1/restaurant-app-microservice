package com.food.app.food_service.food_service.entities;

import java.lang.annotation.Target;

import com.food.app.food_service.food_service.enums.FoodType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.EnumNaming;

@Entity
@Table(name = "food_items")
@Getter
@Setter
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;
    private String quantity;
    private boolean outOfStock = true;
    @Enumerated(EnumType.STRING)
    private FoodType foodType = FoodType.VEG;

    @ManyToOne
    private FoodCategory foodCategory; 

    //to store the restaurent information inside food information example food  catergory is in this(food-service) service but restaurent name is in restaurent-service 
    @Column(nullable = false)
    private String restaurentId;



    
}
