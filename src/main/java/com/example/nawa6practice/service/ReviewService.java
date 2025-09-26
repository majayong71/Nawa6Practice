package com.example.nawa6practice.service;

import com.example.nawa6practice.domain.Review;

import java.util.List;

public interface ReviewService {

    /**
     * 리뷰 등록
     **/
    void register(Long userId, Long restaurantId, String content, String imageUrl, int rating);

    /**
     * 리뷰 조회
     **/
    List<Review> gets(Long restaurantId);

    /**
     * 리뷰 수정
     **/
    void update(Long id, Long userId, String content, String imageUrl, int rating);

    /**
     * 리뷰 삭제
     **/
    void delete(Long id, Long userId);

}
