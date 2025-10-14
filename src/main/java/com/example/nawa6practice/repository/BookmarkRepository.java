package com.example.nawa6practice.repository;

import com.example.nawa6practice.domain.Bookmark;
import com.example.nawa6practice.domain.BookmarkStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    // 특정 유저의 활성화 된 북마크를 전체 조회하는 쿼리.
    @Query("""
            SELECT b
            FROM Bookmark b
            WHERE b.user = :userId AND b.status = :status
            ORDER BY b.createdAt DESC
            """)
    List<Bookmark> findByUserIdAndStatus(Long userId, BookmarkStatus status);
}
