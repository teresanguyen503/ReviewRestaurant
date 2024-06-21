package com.example.restaurantReview.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.restaurantReview.entity.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

}
