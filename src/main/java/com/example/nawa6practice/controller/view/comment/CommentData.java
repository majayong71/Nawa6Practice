package com.example.nawa6practice.controller.view.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentData {
    private final Long userId;
    private final Long postId;
    private final String content;
    private final String imageUrl;
}
