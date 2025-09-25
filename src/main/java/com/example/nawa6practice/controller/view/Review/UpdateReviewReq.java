package com.example.nawa6practice.controller.view.Review;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateReviewReq {
    private final Long id = 1L;
    private final Long userId = 1L;
    private final String content;
    private final String imageUrl;
    private final int rating;
}
