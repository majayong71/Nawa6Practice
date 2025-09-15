package repository;

import domain.Menu;
import domain.MenuStatus;
import domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByRestaurantAndStatus(Restaurant restaurant, MenuStatus status);
}
