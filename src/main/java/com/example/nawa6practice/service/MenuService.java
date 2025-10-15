package com.example.nawa6practice.service;

import com.example.nawa6practice.domain.Menu;

import java.util.List;

public interface MenuService {


    // TODO @QUERY 짜자


    /** 메뉴 등록 **/
    void register(Long restaurantId, String name, int price, String description, boolean isMain, String mainImageUrl);

    /** 모든 메뉴 조회 **/
    List<Menu> gets(Long restaurantId);

    /** 메뉴 상세 조회 **/
    Menu get(Long id);

    /** 메뉴 수정 **/
    void update(Long id, String name, int price, String description, boolean isMain, String mainImageUrl);

    /** 메뉴 삭제 **/
    void delete(Long id);
}
