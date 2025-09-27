package com.example.nawa6practice.controller;

import com.example.nawa6practice.controller.view.comment.RegisterCommentReq;
import com.example.nawa6practice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    /**
     * 등록
     */
    @PostMapping()
    public void register(@RequestBody RegisterCommentReq req) {
        commentService.register(req.getUserId(), req.getPostId(), req.getContent(), req.getImageUrl());
    }

    /**
     * 조회
     */

    /**
     * 수정
     */

    /**
     * 삭제
     */


}
