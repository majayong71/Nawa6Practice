package com.example.nawa6practice.repository;

import com.example.nawa6practice.domain.Post;
import com.example.nawa6practice.domain.PostCategory;
import com.example.nawa6practice.domain.PostStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long id);

    List<Post> findByUserId(Long userId);

    List<Post> findByCategory(PostCategory category);

    @Query("""
           SELECT P
           FROM Post p
           WHERE p.title like %:keyword% AND p.status = :status
""")
    List<Post> searchByTitle(String keyword, PostStatus status);

    @Query("""
           SELECT P
           FROM Post p
           WHERE p.content like %:keyword% AND p.status = :status
""")
    List<Post> searchByContent(String keyword, PostStatus status);

    @Query("""
           SELECT P
           FROM Post p
           WHERE (p.title like %:keyword% OR p.content like %:keyword%) AND p.status = :status
""")
    List<Post> searchByTitleOrContent(String keyword, PostStatus status);
}
