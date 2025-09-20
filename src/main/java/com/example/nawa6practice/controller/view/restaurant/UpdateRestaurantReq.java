package com.example.nawa6practice.controller.view.restaurant;

import com.example.nawa6practice.domain.RestaurantCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateRestaurantReq {
    private final Long restaurantId = 1L;
    private final String name;
    private final RestaurantCategory category;
    private final String address;
    private final String businessHours;
    private final String phoneNumber;
    private final String description;
    private final String mainImageUrl;
    private final boolean visible;
}
