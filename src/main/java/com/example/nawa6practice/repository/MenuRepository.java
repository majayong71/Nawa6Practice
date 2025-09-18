package com.example.nawa6practice.repository;

import com.example.nawa6practice.domain.Menu;
import com.example.nawa6practice.domain.MenuStatus;
import com.example.nawa6practice.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByRestaurantAndStatus(Restaurant restaurant, MenuStatus status);
}
