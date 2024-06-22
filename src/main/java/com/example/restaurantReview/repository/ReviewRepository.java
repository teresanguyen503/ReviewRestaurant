package com.example.restaurantReview.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.restaurantReview.entity.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {

}
