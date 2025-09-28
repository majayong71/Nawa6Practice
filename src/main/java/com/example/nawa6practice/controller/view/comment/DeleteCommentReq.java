package com.example.nawa6practice.controller.view.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteCommentReq {
    private final Long id;
    private final Long userId;
}
