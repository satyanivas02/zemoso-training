package com.satya.spring_boot_assignment.comic_service.dto;

import lombok.Data;

@Data
public class ReviewDTO {
    private Long id;
    private String content;
    private Double rating;
    private Long comicId;
}
