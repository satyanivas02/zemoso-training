
package com.satya.spring_boot_assignment.comic_service.util;

public class Constants {
    private Constants() {
        throw new UnsupportedOperationException("This is a util class and cannot be instantiated");
    }
    public static final String COMIC_BASE_URL = "/comics";
    public static final String COMIC_ID = "/{id}";
    public static final String COMIC_ID_REVIEWS = "/{comicId}/reviews";
    public static final String COMIC_ID_REVIEWS_REVIEW_ID = "/{comicId}/reviews/{reviewId}";
}
