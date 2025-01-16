package com.satya.spring_boot_assignment.review_service.repository;

import com.satya.spring_boot_assignment.review_service.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByComicId(Long comicId);
    void deleteByComicId(Long comicId);
}
