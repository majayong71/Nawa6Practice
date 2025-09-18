package com.example.nawa6practice.repository;

import com.example.nawa6practice.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
