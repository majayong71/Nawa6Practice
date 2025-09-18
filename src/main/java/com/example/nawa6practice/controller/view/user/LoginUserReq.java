package com.example.nawa6practice.controller.view.user;

import lombok.Getter;

@Getter
public class LoginUserReq {
    private final String email;
    private final String password;

    public LoginUserReq(String email, String password){
        this.email = email;
        this.password = password;
    }
}
