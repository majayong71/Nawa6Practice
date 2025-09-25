package com.example.nawa6practice.controller.view.Review;

import com.example.nawa6practice.domain.Review;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GetReviewsRes {
    private final List<ReviewData> reviews;

    public GetReviewsRes(List<Review> reviews) {
        this.reviews = reviews.stream().map(review -> new ReviewData(
                        review.getId(), review.getRestaurant().getId(), review.getContent(), review.getImageUrl(),
                        review.getRating()
                )
        ).collect(Collectors.toList());
    }
}
