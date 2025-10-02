package com.example.nawa6practice.repository;

import com.example.nawa6practice.domain.Comment;
import com.example.nawa6practice.domain.CommentStatus;
import com.example.nawa6practice.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = """
                SELECT c
                FROM Comment c
                WHERE c.post = :post AND c.status = :status  
                ORDER BY c.createdAt DESC
            """)
    List<Comment> findByPostAndStatus(Post post, CommentStatus status);
}
