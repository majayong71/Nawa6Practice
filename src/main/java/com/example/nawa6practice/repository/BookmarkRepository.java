package com.example.nawa6practice.repository;

import com.example.nawa6practice.domain.Bookmark;
import com.example.nawa6practice.domain.BookmarkStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<Bookmark> findByStatus(BookmarkStatus status);
}
