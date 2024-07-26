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

import com.example.restaurantReview.entity.User;
import com.example.restaurantReview.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
        User newUser = this.userRepository.save(user);
        return newUser;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User u) {
        Optional<User> userToUpdateOptional = this.userRepository.findById(id);

        if (!userToUpdateOptional.isPresent()) {
            return null;
        }

        User userToUpdate = userToUpdateOptional.get();
        if (u.getFirstName() != null) {
            userToUpdate.setFirstName(u.getFirstName());
        }
        if (u.getLastName() != null) {
            userToUpdate.setLastName(u.getLastName());
        }
        if (u.getEmail() != null) {
            userToUpdate.setEmail(u.getEmail());
        }
        if (u.getPassword() != null) {
            userToUpdate.setPassword(u.getPassword());
        }
        if (u.getSecurityQuestion() != null) {
            userToUpdate.setSecurityQuestion(u.getSecurityQuestion());
        }
        if (u.getSecurityAnswer() != null) {
            userToUpdate.setSecurityAnswer(u.getSecurityAnswer());
        }

        User updatedUser = this.userRepository.save(userToUpdate);
        return updatedUser;
    }

    @DeleteMapping("/{id}")
    public User deletUser(@PathVariable("id") Long id) {
        Optional<User> userToDeleteOptional = this.userRepository.findById(id);

        if (!userToDeleteOptional.isPresent()) {
            return null;
        }

        User userToDelete = userToDeleteOptional.get();
        this.userRepository.delete(userToDelete);
        return userToDelete;
    }

}
