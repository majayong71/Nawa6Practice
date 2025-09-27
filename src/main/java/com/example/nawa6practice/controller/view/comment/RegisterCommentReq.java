package com.example.nawa6practice.controller.view.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RegisterCommentReq {
    private final Long userId = 1L;
    private final Long postId;
    private final String content;
    private final String imageUrl;
}
