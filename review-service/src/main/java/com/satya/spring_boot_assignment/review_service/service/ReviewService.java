package com.satya.spring_boot_assignment.review_service.service;

import com.satya.spring_boot_assignment.review_service.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> findAll();
    Optional<Review> findById(Long id);
    List<Review> findByComicId(Long comicId);
    Review save(Review review);
    Optional<Review> update(Long id, Review newReview);
    boolean delete(Long id);
    void deleteByComicId(Long comicId);
}
