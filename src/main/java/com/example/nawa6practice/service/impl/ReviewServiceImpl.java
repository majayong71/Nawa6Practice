package com.example.nawa6practice.service.impl;

import com.example.nawa6practice.domain.Restaurant;
import com.example.nawa6practice.domain.Review;
import com.example.nawa6practice.domain.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.nawa6practice.repository.RestaurantRepository;
import com.example.nawa6practice.repository.ReviewRepository;
import com.example.nawa6practice.repository.UserRepository;
import com.example.nawa6practice.service.ReviewService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public void register(Long userId, Long restaurantId, String content, String imageUrl, int rating) {
        User user = userRepository.findById(userId).get();
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        Review review = new Review(user, restaurant, content, imageUrl, rating);

        reviewRepository.save(review);
    }

    @Override
    public List<Review> gets(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        return reviewRepository.findByRestaurant(restaurant);
    }

    @Override
    public void update(Long id, Long userId, String content, String imageUrl, int rating) {
        Review review = reviewRepository.findById(id).get();

        review.update(userId, content, imageUrl, rating);
    }

    @Override
    public void delete(Long id, Long userId) {
        Review review = reviewRepository.findById(id).get();

        review.deleted(userId);
    }
}
