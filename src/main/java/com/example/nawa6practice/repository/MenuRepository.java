package com.example.nawa6practice.repository;

import com.example.nawa6practice.domain.Menu;
import com.example.nawa6practice.domain.MenuStatus;
import com.example.nawa6practice.domain.Restaurant;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Query("""
                    SELECT m FROM Menu m
                    WHERE m.restaurant = :restaurant AND m.status = :status
                    ORDER BY m.isMain DESC, m.id ASC
            
            """)
    List<Menu> findByRestaurantAndStatus(Restaurant restaurant, MenuStatus status);

    @Query("""
            SELECT m FROM Menu m
            WHERE m.id = :id AND m.status = 'REGISTERED'
            ORDER BY m.isMain DESC, m.id ASC
            """)
    @NonNull
    Optional<Menu> findById(@NonNull Long id);

    /**
     *     또는
     *     @Query ("""
     *             SELECT m FROM Menu m
     *             WHERE m.id = :id AND m.status = 'ACTIVE'
     *             ORDER BY m.isMain DESC, m.id ASC
     *             """)
     *     Optional<Menu> findActiveMenuById(Long id);
     */
}
