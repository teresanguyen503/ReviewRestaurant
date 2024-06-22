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

import com.example.restaurantReview.entity.Review;
import com.example.restaurantReview.repository.ReviewRepository;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewRepository reviewRepository;

    public ReviewController(final ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @GetMapping()
    public Iterable<Review> getAllReviews() {
        return this.reviewRepository.findAll();
    }

    @PostMapping()
    public Review createReview(@RequestBody Review review) {
        Review newReview = this.reviewRepository.save(review);
        return newReview;
    }

    @PutMapping("/{id}")
    public Review updatReview(@PathVariable("id") Long id, @RequestBody Review r) {
        Optional<Review> reviewToUpdateOptional = this.reviewRepository.findById(id);

        if (!reviewToUpdateOptional.isPresent()) {
            return null;
        }

        Review reviewToUpdate = reviewToUpdateOptional.get();
        if (r.getRating() != null) {
            reviewToUpdate.setRating(r.getRating());
        }
        if (r.getComeAgain() != null) {
            reviewToUpdate.setComeAgain(r.getComeAgain());
        }
        if (r.getComment() != null) {
            reviewToUpdate.setComment(r.getComment());
        }

        Review updatedReview = this.reviewRepository.save(reviewToUpdate);
        return updatedReview;
    }

    @DeleteMapping("/{id}")
    public Review deleteReview(@PathVariable("id") Long id) {
        Optional<Review> reviewToDeleteOptional = this.reviewRepository.findById(id);

        if (!reviewToDeleteOptional.isPresent()) {
            return null;
        }

        Review reviewToDelete = reviewToDeleteOptional.get();
        this.reviewRepository.delete(reviewToDelete);
        return reviewToDelete;
    }

}
