package com.food.app.restaurent.restaurent_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.TimeZone;

@SpringBootApplication
public class RestaurentServiceApplication {

	public static void main(String[] args) {
		// Set JVM timezone to UTC to prevent PostgreSQL timezone initialization errors
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(RestaurentServiceApplication.class, args);
	}

}
