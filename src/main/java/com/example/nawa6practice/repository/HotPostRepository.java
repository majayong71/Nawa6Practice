package com.example.nawa6practice.repository;

import com.example.nawa6practice.domain.HotPost;
import com.example.nawa6practice.domain.HotPostCategory;
import com.example.nawa6practice.domain.HotPostStatus;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HotPostRepository extends JpaRepository<HotPost, Long> {
    @Query("""
                    SELECT h
                    FROM HotPost h
                    WHERE h.category = :category AND h.date = :date AND h.status = :status
                    ORDER BY h.rank
            """)
    List<HotPost> findByCategoryAndDate(HotPostCategory category, LocalDate date, HotPostStatus status);

    @NonNull
    @Query("""
                    SELECT h
                    FROM HotPost h
                    WHERE h.id = :id AND h.status = 'REGISTERED'
                    ORDER BY h.rank
            """)
    Optional<HotPost> findById(@NonNull Long id);
}
