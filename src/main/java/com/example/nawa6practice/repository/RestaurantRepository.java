package com.example.nawa6practice.repository;

import com.example.nawa6practice.domain.Restaurant;
import com.example.nawa6practice.domain.RestaurantCategory;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("""
                    SELECT R
                    FROM Restaurant R
                    WHERE r.category = :category AND r.status = 'REGISTERED'
                    ORDER BY r.category DESC
            """)
    List<Restaurant> findByCategory(RestaurantCategory category);

    @NonNull
    @Query("""
                    SELECT R
                    FROM Restaurant R
                    WHERE r.id = :id AND r.status = 'REGISTERED'
                    ORDER BY r.id DESC
            """)
    Optional<Restaurant> findById(@NonNull Long id);

    @NonNull
    @Query("""
                    SELECT R
                    FROM Restaurant R
                    WHERE r.status = 'REGISTERED'
                    ORDER BY r.id DESC
            """)
    List<Restaurant> findAll();

}
