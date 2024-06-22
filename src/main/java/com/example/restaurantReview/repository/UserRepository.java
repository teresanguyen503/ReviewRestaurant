package com.example.restaurantReview.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.restaurantReview.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
