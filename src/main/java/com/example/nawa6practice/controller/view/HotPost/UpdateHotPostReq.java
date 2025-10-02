package com.example.nawa6practice.controller.view.HotPost;

import com.example.nawa6practice.domain.HotPostCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UpdateHotPostReq {
    private final Long id;
    private final Long postId;
    private final LocalDate date;
    private final int rank;
    private final HotPostCategory category;
}
