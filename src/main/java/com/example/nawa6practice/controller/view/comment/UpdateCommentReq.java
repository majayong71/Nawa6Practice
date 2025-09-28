package com.example.nawa6practice.controller.view.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateCommentReq {
    private final Long id;
    private final Long userId;
    private final String content;
    private final String imageUrl;
}
