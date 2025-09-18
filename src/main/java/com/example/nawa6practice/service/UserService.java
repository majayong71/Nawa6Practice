package com.example.nawa6practice.service;

import com.example.nawa6practice.domain.User;

public interface UserService {

    /**
     * 회원 가입
     **/
    void register(String email, String password, String nickname);

    /**
     * 로그인
     * 추후 JWT 토큰 , 세션 ID 를 반환
     **/
    String login(String email, String password);

    /**
     * 회원 정보 조회
     **/
    User get(Long id);

    /**
     * 회원 정보 수정
     **/
    void update(Long id, String nickname);

    /**
     * 회원 패스워드 수정
     **/
    void updatePassword(Long id, String password);

    /**
     * 회원 탈퇴
     **/
    void delete(Long id);
}
