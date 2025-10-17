package com.example.nawa6practice.service;

import com.example.nawa6practice.domain.Post;
import com.example.nawa6practice.domain.PostCategory;
import com.example.nawa6practice.domain.SearchCategory;

import java.util.List;

public interface PostService {

    //ToDo : 쿼리문 짜기

    /**
     * 등록
     **/
    void register(Long userId, PostCategory category, String title, String content, String imageUrl);

    /**
     * 서치
     */
    List<Post> search(SearchCategory category, String keyword);

    /**
     * -추후 페이징 작업
     * & 카테고리별 전체 조회
     * 전체 조회
     **/
    List<Post> gets();

    /**
     * 상세 조회
     **/
    Post get(Long id);

    List<Post> getByUserId(Long userId);
    /**
     * 수정
     */
    void update(Long id, Long userId, PostCategory category, String title, String content, String imageUrl);

    /**
     * 삭제
     **/
    void delete(Long id, Long userId);

}
