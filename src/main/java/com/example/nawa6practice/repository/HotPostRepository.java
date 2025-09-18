package com.example.nawa6practice.repository;

import com.example.nawa6practice.domain.HotPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotPostRepository extends JpaRepository<HotPost, Long> {
}
