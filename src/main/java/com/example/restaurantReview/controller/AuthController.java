package com.example.restaurantReview.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.restaurantReview.dto.LoginRequest;
import com.example.restaurantReview.entity.User;
import com.example.restaurantReview.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(loginRequest.getPassword())) {
                // need to go back and generate a JWT token
                return ResponseEntity.ok("Login successful");
            } else {
                // go back and get the console to display what's in the body
                // might need to be a different status
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
            }
        } else {
            // go back and get the console to display what's in the body

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

}
