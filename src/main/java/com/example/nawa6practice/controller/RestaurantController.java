package com.example.nawa6practice.controller;

import com.example.nawa6practice.controller.view.restaurant.*;
import com.example.nawa6practice.domain.Restaurant;
import com.example.nawa6practice.domain.RestaurantCategory;
import com.example.nawa6practice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;


    /**
     * 레스토랑 등록 ( 관리자 or 크롤링 후 수동 등록 )
     */
    @PostMapping("/register")
    public void register(@RequestBody RegisterRestaurantReq req) {
        restaurantService.register(
                req.getName(), req.getCategory(), req.getAddress(), req.getBusinessHours(),
                req.getPhoneNumber(), req.getDescription(), req.getMainImageUrl()
        );
    }

    /**
     * 모든 레스토랑 조회
     */
    @GetMapping
    public GetRestaurantsRes getAll() {
        List<Restaurant> restaurant = restaurantService.getAll();

        return new GetRestaurantsRes(restaurant);
    }

    /**
     * 레스토랑 상세 조회
     */
    @GetMapping("{id}")
    public GetRestaurantRes get(@PathVariable Long id) {
        Restaurant restaurant = restaurantService.get(id);

        return new GetRestaurantRes(
                restaurant.getName(), restaurant.getCategory(), restaurant.getAddress(),
                restaurant.getBusinessHours(), restaurant.getPhoneNumber(), restaurant.getDescription(),
                restaurant.getMainImageUrl()
        );
    }

    /**
     * 레스토랑 조회 - 카테고리
     */
    @GetMapping
    public GetRestaurantsRes getByCategory(@RequestParam RestaurantCategory category) {
        List<Restaurant> restaurants = restaurantService.getByCategory(category);
        return new GetRestaurantsRes(restaurants);
    }

    /**
     * 레스토랑 정보 수정
     */
    @PostMapping("/update")
    public void update(@RequestBody UpdateRestaurantReq req) {
        restaurantService.update(
                req.getRestaurantId(), req.getName(), req.getCategory(), req.getAddress(), req.getBusinessHours(),
                req.getPhoneNumber(), req.getDescription(), req.getMainImageUrl(), req.isVisible()
        );
    }

    /**
     * 레스토랑 삭제
     */
    @PostMapping("/delete")
    public void delete(@RequestBody DeleteRestaurantReq req) {
        restaurantService.delete(req.getRestaurantId());
    }


}
