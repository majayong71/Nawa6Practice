package repository;

import domain.Restaurant;
import domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    /**
     * 레스토랑에 해당하는 리뷰 찾기
     **/
    List<Review> findByRestaurant(Restaurant restaurant);
}
