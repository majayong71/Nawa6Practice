package com.example.nawa6practice.service;

import com.example.nawa6practice.domain.Banner;
import com.example.nawa6practice.domain.BannerStatus;

import java.util.List;

public interface BannerService {
    /**
     * 모든 배너 조회
     **/
    List<Banner> gets();

    /**
     * 배너 수정
     **/
    void update(Long id, String imageUrl, String linkUrl, int displayOrder);

    /**
     * 배너 삭제
     **/
    void delete(Long id);
}
