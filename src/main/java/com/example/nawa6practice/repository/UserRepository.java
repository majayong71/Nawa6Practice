package com.example.nawa6practice.repository;

import com.example.nawa6practice.domain.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 데이터가 존재하면 true , 없으면 false boolean 형태의 값을 반환하는 쿼리 메서드.
     */
    @Query("""
                    SELECT COUNT(U) > 0
                    FROM User U
                    WHERE u.email = :email AND u.status = 'ACTIVE'
                    ORDER BY u.id desc
            """)
    boolean existsByEmail(String email);

    @NonNull
    @Query("""
                    SELECT U
                    FROM User u
                    WHERE u.id = :id AND u.status = 'ACTIVE'
                    ORDER BY u.id DESC
            """)
    Optional<User> findById(@NonNull Long id);

}
