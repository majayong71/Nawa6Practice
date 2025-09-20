package com.example.nawa6practice.controller.view.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginUserReq {
    private final String email;
    private final String password;
}
