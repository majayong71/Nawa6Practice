package repository;

import domain.HotPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotPostRepository extends JpaRepository<HotPost, Long> {
}
