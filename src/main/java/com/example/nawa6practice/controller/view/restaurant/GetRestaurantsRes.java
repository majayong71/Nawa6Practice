package com.example.nawa6practice.controller.view.restaurant;

import com.example.nawa6practice.domain.Restaurant;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GetRestaurantsRes {
    private final List<RestaurantData> restaurants;

    public GetRestaurantsRes (List<Restaurant> restaurants) {
        this.restaurants = restaurants.stream().map(restaurant -> new RestaurantData(
                restaurant.getName(), restaurant.getCategory(), restaurant.getAddress(), restaurant.getBusinessHours(),
                restaurant.getPhoneNumber(), restaurant.getDescription(), restaurant.getMainImageUrl(),
                restaurant.isVisible()
            )
        ).collect(Collectors.toList());
    }
}
