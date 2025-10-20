package com.example.nawa6practice.service;

import com.example.nawa6practice.domain.Restaurant;
import com.example.nawa6practice.domain.RestaurantCategory;

import java.util.List;

public interface RestaurantService {
    
    //ToDo : restaurant 리포 작성하기
    
    /**
     * 레스토랑 등록 (관리자 or 크롤링 후 수동 등록 )
     **/
    void register(
            String name, RestaurantCategory category, String address, String businessHours, String phoneNumber,
            String description, String mainImageUrl
    );

    /**
     * 모든 레스토랑 조회
     **/
    List<Restaurant> getAll();

    /**
     * 레스토랑 상세 조회 - 아이디
     **/
    Restaurant get(Long id);

    /**
     * 레스토랑 조회 - 카테고리
     **/
    List<Restaurant> getByCategory(RestaurantCategory category);

    /**
     * 레스토랑 정보 수정
     **/
    void update(
            Long id, String name, RestaurantCategory category, String address, String businessHours,
            String phoneNumber, String description, String mainImageUrl, boolean visible
    );

    /**
     * 레스토랑 삭제
     **/
    void delete(Long id);
}
