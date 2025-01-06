package com.satya.spring_boot_assignment.comic_service.service;

import com.satya.spring_boot_assignment.comic_service.dto.ReviewDTO;
import com.satya.spring_boot_assignment.comic_service.model.Comic;
import com.satya.spring_boot_assignment.comic_service.repository.ComicRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ComicServiceTest {

    @Mock
    private ComicRepository comicRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ComicServiceImpl comicService;

    @Test
    void Find_AllComic_ReturnsListOfComic() {
        List<Comic> comicList = Arrays.asList(new Comic(), new Comic());
        when(comicRepository.findAll()).thenReturn(comicList);

        List<Comic> result = comicService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(comicRepository, times(1)).findAll();
    }

    @Test
    void Find_ComicById_ReturnsComic_WhenIdIsValid() {
        Comic comic = new Comic(1L, "Spider-Man: Blue",
                "A touching retelling of Peter Parker’s love story with Gwen Stacy.",
                "Superhero",
                LocalDate.of(2002, 7, 10));
        when(comicRepository.findById(1L)).thenReturn(Optional.of(comic));

        Optional<Comic> result = comicService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("Spider-Man: Blue", result.get().getTitle());
        verify(comicRepository, times(1)).findById(1L);
    }

    @Test
    void Find_ComicById_ReturnsEmpty_WhenIdIsInvalid() {
        when(comicRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Comic> result = comicService.findById(99L);

        assertFalse(result.isPresent());
        verify(comicRepository, times(1)).findById(99L);
    }

    @Test
    void Save_Comic_ReturnsSavedComic() {
        Comic comic = new Comic(1L, "Spider-Man: Blue",
                "A touching retelling of Peter Parker’s love story with Gwen Stacy.",
                "Superhero",
                LocalDate.of(2002, 7, 10));
        when(comicRepository.save(comic)).thenReturn(comic);

        Comic result = comicService.save(comic);

        assertNotNull(result);
        assertEquals("Spider-Man: Blue", result.getTitle());
        verify(comicRepository, times(1)).save(comic);
    }

    @Test
    void Update_comicById_UpdatesComic_WhenIdIsValid() {
        Comic existingComic = new Comic(1L, "Spider-Man: Blue",
                "A touching retelling of Peter Parker’s love story with Gwen Stacy.",
                "Superhero",
                LocalDate.of(2002, 7, 10));

        Comic updatedComic = new Comic(null, "Spider-Man: The Next Chapter",
                "An updated story arc for Spider-Man.",
                "Superhero",
                LocalDate.of(2005, 6, 15));

        when(comicRepository.findById(1L)).thenReturn(Optional.of(existingComic));
        when(comicRepository.save(any(Comic.class))).thenReturn(updatedComic);

        Optional<Comic> result = comicService.update(1L, updatedComic);

        assertTrue(result.isPresent());
        assertEquals("Spider-Man: The Next Chapter", result.get().getTitle());
        verify(comicRepository, times(1)).findById(1L);
        verify(comicRepository, times(1)).save(any(Comic.class));
    }

    @Test
    void Update_ComicById_ReturnsEmpty_WhenIdIsInvalid() {
        when(comicRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Comic> result = comicService.update(99L, new Comic());

        assertFalse(result.isPresent());
        verify(comicRepository, times(1)).findById(99L);
        verify(comicRepository, never()).save(any());
    }

    @Test
    void Delete_ComicById_DeletesComic_WhenIdIsValid() {
        Comic comic = new Comic(1L, "Spider-Man: Blue",
                "A touching retelling of Peter Parker’s love story with Gwen Stacy.",
                "Superhero",
                LocalDate.of(2002, 7, 10));
        when(comicRepository.findById(1L)).thenReturn(Optional.of(comic));

        boolean result = comicService.delete(1L);

        assertTrue(result);
        verify(comicRepository, times(1)).findById(1L);
        verify(comicRepository, times(1)).delete(comic);
        verify(restTemplate, times(1)).delete(anyString());
    }

    @Test
    void Delete_ComicById_ReturnsFalse_WhenIdIsInvalid() {
        when(comicRepository.findById(99L)).thenReturn(Optional.empty());

        boolean result = comicService.delete(99L);

        assertFalse(result);
        verify(comicRepository, times(1)).findById(99L);
        verify(comicRepository, never()).delete(any());
        verify(restTemplate, never()).delete(anyString());
    }

    @Test
    void GetReviews_ForComic_ReturnsListOfReviews_WhenComicExists() {
        Comic comic = new Comic(1L, "Spider-Man: Blue",
                "A touching retelling of Peter Parker’s love story with Gwen Stacy.",
                "Superhero",
                LocalDate.of(2002, 7, 10));
        when(comicRepository.findById(1L)).thenReturn(Optional.of(comic));
        List<ReviewDTO> reviews = Arrays.asList(new ReviewDTO(), new ReviewDTO());
        ResponseEntity<List<ReviewDTO>> responseEntity = ResponseEntity.ok(reviews);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), isNull(), any(ParameterizedTypeReference.class)))
                .thenReturn(responseEntity);

        List<ReviewDTO> result = comicService.getReviewsForComic(1L);

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(restTemplate, times(1)).exchange(anyString(), eq(HttpMethod.GET), isNull(), any(ParameterizedTypeReference.class));
    }

    @Test
    void CreateReview_ForComic_CreatesReview_WhenComicExists() {
        Comic comic = new Comic(1L, "Spider-Man: Blue",
                "A touching retelling of Peter Parker’s love story with Gwen Stacy.",
                "Superhero",
                LocalDate.of(2002, 7, 10));
        when(comicRepository.findById(1L)).thenReturn(Optional.of(comic));
        ReviewDTO reviewDTO = new ReviewDTO();
        ResponseEntity<ReviewDTO> responseEntity = ResponseEntity.ok(reviewDTO);
        when(restTemplate.postForEntity(anyString(), any(), eq(ReviewDTO.class))).thenReturn(responseEntity);

        ReviewDTO result = comicService.createReviewForComic(1L, reviewDTO);

        assertNotNull(result);
        verify(restTemplate, times(1)).postForEntity(anyString(), any(), eq(ReviewDTO.class));
    }

    @Test
    void UpdateReview_ForComic_UpdatesReview_WhenComicExists() {
        Comic comic = new Comic(1L, "Spider-Man: Blue",
                "A touching retelling of Peter Parker’s love story with Gwen Stacy.",
                "Superhero",
                LocalDate.of(2002, 7, 10));
        when(comicRepository.findById(1L)).thenReturn(Optional.of(comic));
        ReviewDTO reviewDTO = new ReviewDTO();
        ResponseEntity<ReviewDTO> responseEntity = ResponseEntity.ok(reviewDTO);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.PUT), any(HttpEntity.class), eq(ReviewDTO.class))).thenReturn(responseEntity);

        ReviewDTO result = comicService.updateReviewForComic(1L, 1L, reviewDTO);

        assertNotNull(result);
        verify(restTemplate, times(1)).exchange(anyString(), eq(HttpMethod.PUT), any(HttpEntity.class), eq(ReviewDTO.class));
    }

    @Test
    void DeleteReview_ForComic_DeletesReview_WhenComicExists() {
        Comic comic = new Comic(1L, "Spider-Man: Blue",
                "A touching retelling of Peter Parker’s love story with Gwen Stacy.",
                "Superhero",
                LocalDate.of(2002, 7, 10));
        when(comicRepository.findById(1L)).thenReturn(Optional.of(comic));

        comicService.deleteReviewForComic(1L, 1L);

        verify(restTemplate, times(1)).delete(anyString());
    }
}
