package com.food.app.restaurent.restaurent_service.dto;

import java.time.LocalTime;
import java.util.ArrayList;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantDto {
    private Long Id;
    private String address;
    private String name;
    private String phone;
    @ElementCollection
    private ArrayList<String> pictures = new ArrayList<>();
    //open time and close time are dependent on open value hence this has more priority than ope time and close time  
    private boolean open = false;

    //priority 2 
    private LocalTime openTime;
    private LocalTime closeTime;

    @Lob
    private String description;
    
}
