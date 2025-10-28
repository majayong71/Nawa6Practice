package com.example.nawa6practice.repository;

import com.example.nawa6practice.domain.Banner;
import com.example.nawa6practice.domain.BannerStatus;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BannerRepository extends JpaRepository<Banner, Long> {

    // : 다음엔 파라미터값이 들어감.
    @Query("""
                    SELECT b
                    FROM Banner b
                    WHERE b.status = :status AND b.isVisible = :isVisible
                    ORDER BY b.displayOrder
            """)
    List<Banner> findByStatusAndIsVisible(BannerStatus status, boolean isVisible);

    @NonNull
    @Query("""
        SELECT b
        FROM Banner b
        WHERE b.id = :id AND b.status = 'REGISTERED'
""")
    Optional<Banner> findById(@NonNull Long id);
}
