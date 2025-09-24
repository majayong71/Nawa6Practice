package com.example.nawa6practice.controller.view.post;

import com.example.nawa6practice.domain.PostCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostData {
    private final Long userId;
    private final String title;
    private final String content;
    private final PostCategory postCategory;
    private final String imageUrl;
    private final int commentCount;
    private final int viewCount;
}
