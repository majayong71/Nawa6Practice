package com.example.nawa6practice.controller.view.post;

import com.example.nawa6practice.domain.PostCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdatePostReq {
    private final Long postId = 1L;
    private final Long userId = 1L;
    private final PostCategory postCategory;
    private final String title;
    private final String content;
    private final String mainImageUrl;
}
