package com.example.nawa6practice.controller.view.HotPost;

import com.example.nawa6practice.domain.HotPostCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class HotPostData {
    private final Long postId;
    private final LocalDate date;
    private final int rank;
    private final HotPostCategory category;
}
