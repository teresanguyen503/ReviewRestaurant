package com.example.restaurantReview.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name = "RESTAURANT")
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STREET_ADDRESS")
    private String streetAddress;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @Column(name = "CUISINE")
    private String cuisine;

    @Column(name = "RATING")
    private String rating;

    @Column(name = "COMMENT")
    private String comment;
}
