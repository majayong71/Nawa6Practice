package repository;

import domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 데이터가 존재하면 true , 없으면 false boolean 형태의 값을 반환하는 쿼리 메서드.
     */
    boolean existsByEmail(String email);
}
