package com.satya.spring_boot_assignment.review_service.controller;

import com.satya.spring_boot_assignment.review_service.model.Review;
import com.satya.spring_boot_assignment.review_service.service.ReviewService;
import com.satya.spring_boot_assignment.review_service.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(Constants.REVIEW_BASE_URL)
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<EntityModel<Review>>> getAllReviews() {
        List<EntityModel<Review>> reviewList = reviewService.findAll().stream()
                .map(review -> EntityModel.of(review,
                        linkTo(methodOn(ReviewController.class).getReviewById(review.getId())).withSelfRel(),
                        linkTo(methodOn(ReviewController.class).getAllReviews()).withRel("allReviews"),
                        linkTo(methodOn(ReviewController.class).getReviewsByComicId(review.getComicId())).withRel("reviewsByComicId")))
                .collect(Collectors.toList());
        return ResponseEntity.ok(reviewList);
    }

    @GetMapping(Constants.REVIEW_ID)
    public ResponseEntity<EntityModel<Review>> getReviewById(@PathVariable Long id) {
        return reviewService.findById(id)
                .map(review -> EntityModel.of(review,
                        linkTo(methodOn(ReviewController.class).getReviewById(id)).withSelfRel(),
                        linkTo(methodOn(ReviewController.class).getAllReviews()).withRel("allReviews"),
                        linkTo(methodOn(ReviewController.class).getReviewsByComicId(review.getComicId())).withRel("reviewsByComicId")))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(Constants.COMIC_COMIC_ID)
    public ResponseEntity<List<EntityModel<Review>>> getReviewsByComicId(@PathVariable Long comicId) {
        List<EntityModel<Review>> reviews = reviewService.findByComicId(comicId).stream()
                .map(review -> EntityModel.of(review,
                        linkTo(methodOn(ReviewController.class).getReviewById(review.getId())).withSelfRel(),
                        linkTo(methodOn(ReviewController.class).getReviewsByComicId(comicId)).withRel("reviewsByComicId")))
                .collect(Collectors.toList());
        return ResponseEntity.ok(reviews);
    }

    @PostMapping
    public ResponseEntity<EntityModel<Review>> createReview(@RequestBody Review review) {
        Review savedReview = reviewService.save(review);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(EntityModel.of(savedReview,
                        linkTo(methodOn(ReviewController.class).getReviewById(savedReview.getId())).withSelfRel(),
                        linkTo(methodOn(ReviewController.class).getAllReviews()).withRel("allReviews"),
                        linkTo(methodOn(ReviewController.class).getReviewsByComicId(savedReview.getComicId())).withRel("reviewsByComicId")));
    }

    @PutMapping(Constants.REVIEW_ID)
    public ResponseEntity<EntityModel<Review>> updateReview(@PathVariable Long id, @RequestBody Review reviewDetails) {
        return reviewService.update(id, reviewDetails)
                .map(updatedReview -> EntityModel.of(updatedReview,
                        linkTo(methodOn(ReviewController.class).getReviewById(updatedReview.getId())).withSelfRel(),
                        linkTo(methodOn(ReviewController.class).getAllReviews()).withRel("allReviews"),
                        linkTo(methodOn(ReviewController.class).getReviewsByComicId(updatedReview.getComicId())).withRel("reviewsByComicId")))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(Constants.REVIEW_ID)
    public ResponseEntity<String> deleteReview(@PathVariable Long id) {
        boolean isDeleted = reviewService.delete(id);
        return isDeleted
                ? ResponseEntity.ok("Review deletion successful")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Review deletion failed: Review not found");
    }

    @DeleteMapping(Constants.COMIC_COMIC_ID)
    public ResponseEntity<String> deleteReviewsByComicId(@PathVariable Long comicId) {
        try {
            reviewService.deleteByComicId(comicId);
            return ResponseEntity.ok("All reviews for the comic deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete reviews: " + e.getMessage());
        }
    }
}
