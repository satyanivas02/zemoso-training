package com.satya.spring_boot_assignment.comic_service.controller;

import com.satya.spring_boot_assignment.comic_service.dto.ReviewDTO;
import com.satya.spring_boot_assignment.comic_service.model.Comic;
import com.satya.spring_boot_assignment.comic_service.service.ComicService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@ExtendWith(MockitoExtension.class)
public class ComicControllerTest {

    @Mock
    private ComicService comicService;

    @InjectMocks
    private ComicController comicController;

    @Test
    void GetAllComic_ReturnsListOfComic_WhenComicExist() {
//        Comic comic1 = new Comic(1L, "Naruto", "Some description", "Action", LocalDate.now(), 500);
//        Comic comic2 = new Comic(2L, "One Piece", "Some description", "Adventure", LocalDate.now(), 500);
        Comic comic1 = new Comic(1L, "Spider-Man: Blue",
                "A touching retelling of Peter Parker’s love story with Gwen Stacy.",
                "Superhero",
                LocalDate.of(2002, 7, 10));

        Comic comic2 = new Comic(2L, "Batman: Year One",
                "The origin story of Batman and James Gordon’s early days in Gotham.",
                "Superhero",
                LocalDate.of(1987, 3, 1));
        List<Comic> comicList = Arrays.asList(comic1, comic2);

        when(comicService.findAll()).thenReturn(comicList);

        ResponseEntity<List<EntityModel<Comic>>> response = comicController.getAllComics();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        verify(comicService, times(1)).findAll();
    }

    @Test
    void GetComicById_ReturnsComic_WhenIdIsValid() {
        Comic comic = new Comic(1L, "Spider-Man: Blue",
                "A touching retelling of Peter Parker’s love story with Gwen Stacy.",
                "Superhero",
                LocalDate.of(2002, 7, 10));
        when(comicService.findById(1L)).thenReturn(Optional.of(comic));

        ResponseEntity<EntityModel<Comic>> response = comicController.getComicById(1L);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(comic.getId(), response.getBody().getContent().getId());
        verify(comicService, times(1)).findById(1L);
    }

    @Test
    void GetComicById_ReturnsNotFound_WhenIdIsInvalid() {
        when(comicService.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<EntityModel<Comic>> response = comicController.getComicById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(comicService, times(1)).findById(1L);
    }

    @Test
    void CreateComic_CreatesComic_WhenDataIsValid() {
        Comic comic = new Comic(1L, "Spider-Man: Blue",
                "A touching retelling of Peter Parker’s love story with Gwen Stacy.",
                "Superhero",
                LocalDate.of(2002, 7, 10));
        when(comicService.save(comic)).thenReturn(comic);

        ResponseEntity<EntityModel<Comic>> response = comicController.createComic(comic);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(comic.getId(), response.getBody().getContent().getId());
        verify(comicService, times(1)).save(comic);
    }

    @Test
    void UpdateComic_UpdatesComic_WhenIdIsValid() {
        Comic comic = new Comic(1L, "Spider-Man: Blue",
                "A touching retelling of Peter Parker’s love story with Gwen Stacy.",
                "Superhero",
                LocalDate.of(2002, 7, 10));
        when(comicService.update(1L, comic)).thenReturn(Optional.of(comic));

        ResponseEntity<EntityModel<Comic>> response = comicController.updateComic(1L, comic);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(comicService, times(1)).update(1L, comic);
    }

    @Test
    void UpdateComic_ReturnsNotFound_WhenIdIsInvalid() {
        Comic comic = new Comic(1L, "Spider-Man: Blue",
                "A touching retelling of Peter Parker’s love story with Gwen Stacy.",
                "Superhero",
                LocalDate.of(2002, 7, 10));
        when(comicService.update(1L, comic)).thenReturn(Optional.empty());

        ResponseEntity<EntityModel<Comic>> response = comicController.updateComic(1L, comic);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(comicService, times(1)).update(1L, comic);
    }

    @Test
    void DeleteComic_DeletesComic_WhenIdIsValid() {
        when(comicService.delete(1L)).thenReturn(true);

        ResponseEntity<String> response = comicController.deleteComic(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(comicService, times(1)).delete(1L);
    }

    @Test
    void DeleteComic_ReturnsNotFound_WhenIdIsInvalid() {
        when(comicService.delete(1L)).thenReturn(false);

        ResponseEntity<String> response = comicController.deleteComic(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(comicService, times(1)).delete(1L);
    }

    @Test
    void GetReviewsForComic_ReturnsListOfEntityModelReviews_WhenAnimeExists() {
        ReviewDTO review1 = new ReviewDTO();
        review1.setId(1L);
        review1.setContent("Great comic!");
        review1.setRating(5.0);
        review1.setComicId(1L);

        ReviewDTO review2 = new ReviewDTO();
        review2.setId(2L);
        review2.setContent("Awesome!");
        review2.setRating(5.0);
        review2.setComicId(1L);

        List<ReviewDTO> reviews = Arrays.asList(review1, review2);

        when(comicService.getReviewsForComic(1L)).thenReturn(reviews);

        ResponseEntity<List<EntityModel<ReviewDTO>>> response = comicController.getReviewsForComic(1L);

        assertNotNull(response);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertNotNull(response.getBody());

        assertEquals(2, response.getBody().size());

        EntityModel<ReviewDTO> entityModel1 = response.getBody().get(0);
        assertEquals(review1.getId(), entityModel1.getContent().getId());
        assertEquals(review1.getContent(), entityModel1.getContent().getContent());
        assertEquals(review1.getRating(), entityModel1.getContent().getRating());

        EntityModel<ReviewDTO> entityModel2 = response.getBody().get(1);
        assertEquals(review2.getId(), entityModel2.getContent().getId());
        assertEquals(review2.getContent(), entityModel2.getContent().getContent());
        assertEquals(review2.getRating(), entityModel2.getContent().getRating());

        verify(comicService, times(1)).getReviewsForComic(1L);
    }


    @Test
    void CreateReviewForComic_CreatesReview_WhenDataIsValid() {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(1L);
        reviewDTO.setContent("Great comic!");
        reviewDTO.setRating(5.0);
        reviewDTO.setComicId(1L);

        when(comicService.createReviewForComic(1L, reviewDTO)).thenReturn(reviewDTO);

        ResponseEntity<EntityModel<ReviewDTO>> response = comicController.createReviewForComic(1L, reviewDTO);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(comicService, times(1)).createReviewForComic(1L, reviewDTO);
    }

    @Test
    void UpdateReviewForComic_UpdatesReview_WhenReviewAndComicExist() {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(1L);
        reviewDTO.setContent("Updated review");
        reviewDTO.setRating(4.0);
        reviewDTO.setComicId(1L);

        when(comicService.updateReviewForComic(1L, 1L, reviewDTO)).thenReturn(reviewDTO);

        ResponseEntity<EntityModel<ReviewDTO>> response = comicController.updateReviewForComic(1L, 1L, reviewDTO);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(comicService, times(1)).updateReviewForComic(1L, 1L, reviewDTO);
    }

    @Test
    void DeleteReviewForComic_DeletesReview_WhenReviewExists() {
        doNothing().when(comicService).deleteReviewForComic(1L, 1L);

        ResponseEntity<String> response = comicController.deleteReviewForComic(1L, 1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(comicService, times(1)).deleteReviewForComic(1L, 1L);
    }

    @Test
    void DeleteReviewForComic_ReturnsNotFound_WhenReviewNotFound() {
        doThrow(new RuntimeException("Review not found")).when(comicService).deleteReviewForComic(1L, 1L);

        ResponseEntity<String> response = comicController.deleteReviewForComic(1L, 1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertTrue(response.getBody().contains("Review not found"));
        verify(comicService, times(1)).deleteReviewForComic(1L, 1L);
    }
}
