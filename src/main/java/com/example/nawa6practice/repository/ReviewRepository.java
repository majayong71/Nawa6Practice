package com.example.nawa6practice.repository;

import com.example.nawa6practice.domain.Restaurant;
import com.example.nawa6practice.domain.Review;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("""
        SELECT R
        FROM Review R
        WHERE r.restaurant = :restaurant AND r.status = 'ACTIVE'
        ORDER BY r.id desc
""")
    List<Review> findByRestaurant(Restaurant restaurant);

    @NonNull
    @Query("""
        SELECT R
        FROM Review R
        WHERE r.id = :id AND r.status = 'ACTIVE'
        ORDER BY r.id desc
""")
    Optional<Review> findById(@NonNull Long id);
}
