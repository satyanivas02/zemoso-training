package com.satya.spring_boot_assignment.comic_service.controller;

import com.satya.spring_boot_assignment.comic_service.dto.ReviewDTO;
import com.satya.spring_boot_assignment.comic_service.model.Comic;
import com.satya.spring_boot_assignment.comic_service.service.ComicService;
import com.satya.spring_boot_assignment.comic_service.util.Constants;
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
@RequiredArgsConstructor
@RequestMapping(Constants.COMIC_BASE_URL)
public class ComicController {

    private final ComicService comicService;

    @GetMapping
    public ResponseEntity<List<EntityModel<Comic>>> getAllComics() {
        List<EntityModel<Comic>> comicList = comicService.findAll().stream()
                .map(comic -> EntityModel.of(comic,
                        linkTo(methodOn(ComicController.class).getComicById(comic.getId())).withSelfRel(),
                        linkTo(methodOn(ComicController.class).getReviewsForComic(comic.getId())).withRel("reviews"),
                        linkTo(methodOn(ComicController.class).getAllComics()).withRel("allComics")))
                .collect(Collectors.toList());

        return ResponseEntity.ok(comicList);
    }

    @GetMapping(Constants.COMIC_ID)
    public ResponseEntity<EntityModel<Comic>> getComicById(@PathVariable Long id) {
        return comicService.findById(id)
                .map(comic -> EntityModel.of(comic,
                        linkTo(methodOn(ComicController.class).getComicById(id)).withSelfRel(),
                        linkTo(methodOn(ComicController.class).getReviewsForComic(id)).withRel("reviews"),
                        linkTo(methodOn(ComicController.class).getAllComics()).withRel("allComics")))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EntityModel<Comic>> createComic(@RequestBody Comic comic) {
        Comic createdComic = comicService.save(comic);

        EntityModel<Comic> comicModel = EntityModel.of(createdComic,
                linkTo(methodOn(ComicController.class).getComicById(createdComic.getId())).withSelfRel(),
                linkTo(methodOn(ComicController.class).getAllComics()).withRel("allComics"));

        return ResponseEntity.status(HttpStatus.CREATED).body(comicModel);
    }

    @PutMapping(Constants.COMIC_ID)
    public ResponseEntity<EntityModel<Comic>> updateComic(@PathVariable Long id, @RequestBody Comic comicDetails) {
        return comicService.update(id, comicDetails)
                .map(updatedComic -> EntityModel.of(updatedComic,
                        linkTo(methodOn(ComicController.class).getComicById(id)).withSelfRel(),
                        linkTo(methodOn(ComicController.class).getAllComics()).withRel("allComics")))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(Constants.COMIC_ID)
    public ResponseEntity<String> deleteComic(@PathVariable Long id) {
        boolean isDeleted = comicService.delete(id);
        if (isDeleted)
            return ResponseEntity.ok("Comic and its reviews deleted successfully");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to delete comic. Comic with id " + id + " not found.");
    }

    @GetMapping(Constants.COMIC_ID_REVIEWS)
    public ResponseEntity<List<EntityModel<ReviewDTO>>> getReviewsForComic(@PathVariable Long comicId) {
        List<EntityModel<ReviewDTO>> reviews = comicService.getReviewsForComic(comicId).stream()
                .map(review -> EntityModel.of(review,
                        linkTo(methodOn(ComicController.class).getReviewsForComic(comicId)).withSelfRel(),
                        linkTo(methodOn(ComicController.class).getComicById(comicId)).withRel("comic")))
                .collect(Collectors.toList());

        return ResponseEntity.ok(reviews);
    }

    @PostMapping(Constants.COMIC_ID_REVIEWS)
    public ResponseEntity<EntityModel<ReviewDTO>> createReviewForComic(@PathVariable Long comicId, @RequestBody ReviewDTO reviewDTO) {
        ReviewDTO createdReview = comicService.createReviewForComic(comicId, reviewDTO);

        EntityModel<ReviewDTO> reviewModel = EntityModel.of(createdReview,
                linkTo(methodOn(ComicController.class).getReviewsForComic(comicId)).withRel("reviews"),
                linkTo(methodOn(ComicController.class).getComicById(comicId)).withRel("comic"));

        return ResponseEntity.status(HttpStatus.CREATED).body(reviewModel);
    }

    @PutMapping(Constants.COMIC_ID_REVIEWS_REVIEW_ID)
    public ResponseEntity<EntityModel<ReviewDTO>> updateReviewForComic(@PathVariable Long comicId, @PathVariable Long reviewId, @RequestBody ReviewDTO reviewDTO) {
        ReviewDTO updatedReview = comicService.updateReviewForComic(comicId, reviewId, reviewDTO);

        EntityModel<ReviewDTO> reviewModel = EntityModel.of(updatedReview,
                linkTo(methodOn(ComicController.class).getReviewsForComic(comicId)).withRel("reviews"),
                linkTo(methodOn(ComicController.class).getComicById(comicId)).withRel("comic"));

        return ResponseEntity.ok(reviewModel);
    }

    @DeleteMapping(Constants.COMIC_ID_REVIEWS_REVIEW_ID)
    public ResponseEntity<String> deleteReviewForComic(@PathVariable Long comicId, @PathVariable Long reviewId) {
        try {
            comicService.deleteReviewForComic(comicId, reviewId);
            return ResponseEntity.ok("Review deleted successfully for comic_id : " + comicId);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
