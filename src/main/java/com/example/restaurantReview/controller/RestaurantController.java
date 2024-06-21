package com.example.restaurantReview.controller;

import java.lang.Iterable;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.restaurantReview.entity.Restaurant;
import com.example.restaurantReview.repository.RestaurantRepository;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;

    public RestaurantController(final RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping()
    public Iterable<Restaurant> getAllRestaurants() {
        return this.restaurantRepository.findAll();
    }

    @PostMapping()
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant newRestaurant = this.restaurantRepository.save(restaurant);
        return newRestaurant;
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable("id") Long id, @RequestBody Restaurant r) {
        Optional<Restaurant> restaurantToUpdateOptional = this.restaurantRepository.findById(id);

        if (!restaurantToUpdateOptional.isPresent()) {
            return null;
        }

        Restaurant restaurantToUpdate = restaurantToUpdateOptional.get();
        if (r.getName() != null) {
            restaurantToUpdate.setName(r.getName());
        }
        if (r.getStreetAddress() != null) {
            restaurantToUpdate.setStreetAddress(r.getStreetAddress());
        }
        if (r.getZipCode() != null) {
            restaurantToUpdate.setZipCode(r.getZipCode());
        }
        if (r.getCuisine() != null) {
            restaurantToUpdate.setCuisine(r.getCuisine());
        }
        if (r.getAverageRating() != null) {
            restaurantToUpdate.setAverageRating(r.getAverageRating());
        }
        if (r.getComment() != null) {
            restaurantToUpdate.setComment(r.getComment());
        }

        Restaurant updatedRestaurant = this.restaurantRepository.save(restaurantToUpdate);
        return updatedRestaurant;
    }

    @DeleteMapping("/{id}")
    public Restaurant deleteRestaurant(@PathVariable("id") Long id) {
        Optional<Restaurant> restaurantToDeleteOptional = this.restaurantRepository.findById(id);

        if (!restaurantToDeleteOptional.isPresent()) {
            return null;
        }

        Restaurant restaurantToDelete = restaurantToDeleteOptional.get();
        this.restaurantRepository.delete(restaurantToDelete);
        return restaurantToDelete;
    }

}
