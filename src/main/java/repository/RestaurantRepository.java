package repository;

import domain.Restaurant;
import domain.RestaurantCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByCategory(RestaurantCategory category);

    Long id(Long id);
}
