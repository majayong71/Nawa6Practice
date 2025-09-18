package com.example.nawa6practice.service;


import com.example.nawa6practice.domain.HotPost;
import com.example.nawa6practice.domain.HotPostCategory;

import java.time.LocalDate;
import java.util.List;

public interface HotPostService {

    /**
     * 인기게시글 등록
     **/
    void register(Long postId, LocalDate date, int rank, HotPostCategory category);

    /**
     * 인기게시글 전체 조회
     **/
    List<HotPost> gets();

    /**
     * 인기게시글 수정
     **/
    void update(Long id, Long postId, LocalDate date, int rank, HotPostCategory hotPostCategory);

    /**
     * 인기게시글 삭제
     **/
    void delete(Long id);
}
