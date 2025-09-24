package com.example.nawa6practice.controller.view.post;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeletePostReq {
    private final Long postId = 1L;
    private final Long userId = 1L;

}
