package com.satya.spring_boot_assignment.comic_service.service;

import com.satya.spring_boot_assignment.comic_service.dto.ReviewDTO;
import com.satya.spring_boot_assignment.comic_service.model.Comic;
import com.satya.spring_boot_assignment.comic_service.repository.ComicRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ComicServiceImpl implements ComicService {

    private final ComicRepository comicRepository;
    private final RestTemplate restTemplate;
    private final String reviewServiceUrl;

    public ComicServiceImpl(ComicRepository comicRepository, RestTemplate restTemplate,
                            @Value("http://review-service") String reviewServiceUrl) {
        this.comicRepository = comicRepository;
        this.restTemplate = restTemplate;
        this.reviewServiceUrl = reviewServiceUrl;
    }

    @Override
    public List<Comic> findAll() {
        return comicRepository.findAll();
    }

    @Override
    public Optional<Comic> findById(Long id) {
        return comicRepository.findById(id);
    }

    @Override
    public Comic save(Comic comic) {
        return comicRepository.save(comic);
    }

    @Override
    public Optional<Comic> update(Long id, Comic comicDetails) {
        return comicRepository.findById(id)
                .map(comic -> {
                    comic.setTitle(comicDetails.getTitle());
                    comic.setDescription(comicDetails.getDescription());
                    comic.setGenre(comicDetails.getGenre());
                    comic.setReleaseDate(comicDetails.getReleaseDate());
                    return comicRepository.save(comic);
                });
    }

    @Override
    public boolean delete(Long id) {
        return comicRepository.findById(id)
                .map(comic -> {
                    // Delete reviews related to the comic
                    restTemplate.delete(reviewServiceUrl + "/reviews/comic/" + id);

                    // Now delete the comic
                    comicRepository.delete(comic);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public List<ReviewDTO> getReviewsForComic(Long comicId) {
        Comic comic = comicRepository.findById(comicId)
                .orElseThrow(() -> new RuntimeException("Comic not found"));
        ResponseEntity<List<ReviewDTO>> response = restTemplate.exchange(
                reviewServiceUrl + "/reviews/comic/" + comicId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ReviewDTO>>() {}
        );
        return response.getBody();
    }

    @Override
    public ReviewDTO createReviewForComic(Long comicId, ReviewDTO reviewDTO) {
        Comic comic = comicRepository.findById(comicId)
                .orElseThrow(() -> new RuntimeException("Comic not found"));
        reviewDTO.setComicId(comicId);  // We should adjust this field name as necessary for reviews
        ResponseEntity<ReviewDTO> response = restTemplate.postForEntity(
                reviewServiceUrl + "/reviews",
                reviewDTO,
                ReviewDTO.class
        );
        return response.getBody();
    }

    @Override
    public ReviewDTO updateReviewForComic(Long comicId, Long reviewId, ReviewDTO reviewDTO) {
        Comic comic = comicRepository.findById(comicId)
                .orElseThrow(() -> new RuntimeException("Comic not found"));
        reviewDTO.setComicId(comicId);

        ResponseEntity<ReviewDTO> response = restTemplate.exchange(
                reviewServiceUrl + "/reviews/" + reviewId,
                HttpMethod.PUT,
                new HttpEntity<>(reviewDTO),
                ReviewDTO.class
        );
        return response.getBody();
    }

    @Override
    public void deleteReviewForComic(Long comicId, Long reviewId) {
        Comic comic = comicRepository.findById(comicId)
                .orElseThrow(() -> new RuntimeException("Comic not found"));
        restTemplate.delete(reviewServiceUrl + "/reviews/" + reviewId);
    }
}
