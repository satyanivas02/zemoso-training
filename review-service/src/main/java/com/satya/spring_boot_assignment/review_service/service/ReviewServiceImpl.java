package com.satya.spring_boot_assignment.review_service.service;

import com.satya.spring_boot_assignment.review_service.model.Review;
import com.satya.spring_boot_assignment.review_service.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;

    @Override
    public List<Review> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Review> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Review> findByComicId(Long comicId) {  // Updated from findByAnimeId to findByComicId
        return repository.findByComicId(comicId);
    }

    @Override
    public Review save(Review review) {
        return repository.save(review);
    }

    @Override
    public Optional<Review> update(Long id, Review newReview) {
        return repository.findById(id)
                .map(review -> {
                    review.setContent(newReview.getContent());
                    review.setRating(newReview.getRating());
                    review.setComicId(newReview.getComicId());  // Updated from setAnimeId to setComicId
                    return repository.save(review);
                });
    }

    @Override
    public boolean delete(Long id) {
        return repository.findById(id)
                .map(review -> {
                    repository.delete(review);
                    return true;
                })
                .orElse(false);
    }

    @Transactional
    @Override
    public void deleteByComicId(Long comicId) {  // Updated from deleteByAnimeId to deleteByComicId
        repository.deleteByComicId(comicId);
    }
}
