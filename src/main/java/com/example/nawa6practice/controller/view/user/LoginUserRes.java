package com.example.nawa6practice.controller.view.user;

import lombok.Getter;

@Getter
public class LoginUserRes {
    private final String accessToken;

    public LoginUserRes(String accessToken){
        this.accessToken = accessToken;
    }
}
