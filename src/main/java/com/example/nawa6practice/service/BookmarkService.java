package com.example.nawa6practice.service;

import com.example.nawa6practice.domain.Bookmark;

import java.util.List;

public interface BookmarkService {

    /**
     * 북마크 전체 조회
     **/
    List<Bookmark> gets();

    /**
     * 북마크 등록
     **/
    void register(Long userId, Long postId);

    /**
     * 북마크 삭제
     **/
    void delete(Long id, Long userId);
}
