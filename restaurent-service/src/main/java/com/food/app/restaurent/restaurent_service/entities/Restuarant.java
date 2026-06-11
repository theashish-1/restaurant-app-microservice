package com.food.app.restaurent.restaurent_service.entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Entity
@Table(name = "restaurents")
@Getter
@Setter
public class Restuarant {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private String address;
    private String name;
    private String phone;
    @ElementCollection
    private List<String> pictures = new ArrayList<>();
    //open time and close time are dependent on open value hence this has more priority than ope time and close time  
    private boolean open = false;

    //priority 2 
    private LocalTime openTime;
    private LocalTime closeTime;

    @Lob
    private String description;
    


    
}
