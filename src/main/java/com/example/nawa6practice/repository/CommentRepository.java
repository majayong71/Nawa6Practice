package com.example.nawa6practice.repository;

import com.example.nawa6practice.domain.Comment;
import com.example.nawa6practice.domain.CommentStatus;
import com.example.nawa6practice.domain.Post;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 상태값이 등록인 게시글을 가져오는 쿼리
    @Query(value = """
                SELECT c
                FROM Comment c
                WHERE c.post = :post AND c.status = :status
                ORDER BY c.createdAt DESC
            """)
    List<Comment> findByPostAndStatus(Post post, CommentStatus status);

    @NonNull
    @Query("""
                    SELECT c
                    FROM Comment c
                    WHERE c.id = :id AND c.status = 'REGISTERED'
                    ORDER BY c.createdAt DESC
            """)
    Optional<Comment> findById(@NonNull Long id);
}
