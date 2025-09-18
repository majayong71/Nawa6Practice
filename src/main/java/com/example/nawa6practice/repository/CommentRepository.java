package com.example.nawa6practice.repository;

import com.example.nawa6practice.domain.Comment;
import com.example.nawa6practice.domain.CommentStatus;
import com.example.nawa6practice.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPostAndStatus(Post post, CommentStatus status);
}
