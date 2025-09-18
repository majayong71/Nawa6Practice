package com.example.nawa6practice.controller.view.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateUserReq {
    private final Long userId = 1L;
    private final String nickname;
}
