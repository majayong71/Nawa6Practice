package com.example.nawa6practice.controller.view.Review;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewData {
    private final Long userId;
    private final Long restaurantId;
    private final String content;
    private final String imageUrl;
    private final int rating;
}
