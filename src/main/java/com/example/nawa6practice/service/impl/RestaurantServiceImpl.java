package com.example.nawa6practice.service.impl;

import com.example.nawa6practice.domain.Restaurant;
import com.example.nawa6practice.domain.RestaurantCategory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.nawa6practice.repository.RestaurantRepository;
import com.example.nawa6practice.service.RestaurantService;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Override
    public void register(String name, RestaurantCategory category, String address, String businessHours,
                         String phoneNumber, String description, String mainImageUrl
    ) {
        Restaurant restaurant = new Restaurant(
                name, category, address, businessHours, phoneNumber, description, mainImageUrl
        );

        restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant get(Long id) {
        return restaurantRepository.findById(id).get();
    }

    @Override
    public List<Restaurant> getByCategory(RestaurantCategory category) {
        return restaurantRepository.findByCategory(category);
    }

    @Override
    public void update(
            Long id, String name, RestaurantCategory category, String address, String businessHours, String phoneNumber,
            String description, String mainImageUrl, boolean visible
    ) {
        Restaurant restaurant = restaurantRepository.findById(id).get();

        restaurant.update(name, category, address, businessHours, phoneNumber, description, mainImageUrl, visible);
    }

    @Override
    public void delete(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).get();

        restaurant.delete();

        BigDecimal num1 = new BigDecimal(200);
        BigDecimal num2 = new BigDecimal("100");

        System.out.println(num1.add(num2));
    }
}
