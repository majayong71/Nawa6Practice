package com.example.nawa6practice.repository;

import com.example.nawa6practice.domain.Restaurant;
import com.example.nawa6practice.domain.RestaurantCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("""
        SELECT R
        FROM Restaurant R
        WHERE r.category = :category AND r.status = 'ACTIVE'
        ORDER BY r.category DESC
""")
    List<Restaurant> findByCategory(RestaurantCategory category);

    Long id(Long id);

}
