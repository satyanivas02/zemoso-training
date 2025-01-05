package com.satya.spring_boot_assignment.comic_service.service;

import com.satya.spring_boot_assignment.comic_service.dto.ReviewDTO;
import com.satya.spring_boot_assignment.comic_service.model.Comic;

import java.util.List;
import java.util.Optional;

public interface ComicService {
    List<Comic> findAll();
    Optional<Comic> findById(Long id);
    Comic save(Comic comic);
    Optional<Comic> update(Long id, Comic comicDetails);
    boolean delete(Long id);
    List<ReviewDTO> getReviewsForComic(Long comicId);
    ReviewDTO createReviewForComic(Long comicId, ReviewDTO reviewDTO);
    ReviewDTO updateReviewForComic(Long comicId, Long reviewId, ReviewDTO reviewDTO);
    void deleteReviewForComic(Long comicId, Long reviewId);
}
