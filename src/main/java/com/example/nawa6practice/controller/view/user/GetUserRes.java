package com.example.nawa6practice.controller.view.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetUserRes {

    @Schema(description = "닉네임", example = "홍길동",nullable = true)
    private final String nickname;

    @Schema(description = "이메일", example = "wotkd2647@naver.com")
    private final String email;
}
