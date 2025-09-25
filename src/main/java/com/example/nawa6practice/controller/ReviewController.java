package com.example.nawa6practice.controller;

import com.example.nawa6practice.controller.view.Review.GetReviewsRes;
import com.example.nawa6practice.controller.view.Review.RegisterReviewReq;
import com.example.nawa6practice.domain.Review;
import com.example.nawa6practice.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/register")
    public void register(RegisterReviewReq req) {
        reviewService.register(
                req.getUserId(), req.getRestaurantId(), req.getContent(), req.getImageUrl(),
                req.getRating()
        );
    }

    @GetMapping()
    public GetReviewsRes gets(@RequestParam Long restaurantId) {
        List<Review> reviews = reviewService.gets(restaurantId);

        return new GetReviewsRes(reviews);
    }

    @PostMapping("/update")
    public void update(@RequestBody RegisterReviewReq req) {
        reviewService.update(
                req.getUserId(), req.getRestaurantId(), req.getContent(), req.getImageUrl(),
                req.getRating()
        );
    }

    @PostMapping("/delete")
    public void delete(@RequestBody RegisterReviewReq req) {
        reviewService.delete(
                req.getUserId(), req.getRestaurantId()
        );
    }

}
