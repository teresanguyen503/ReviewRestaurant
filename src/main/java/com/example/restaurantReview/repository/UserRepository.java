package com.example.restaurantReview.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.example.restaurantReview.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
