package com.example.nawa6practice.controller;

import com.example.nawa6practice.controller.view.comment.DeleteCommentReq;
import com.example.nawa6practice.controller.view.comment.GetCommentsRes;
import com.example.nawa6practice.controller.view.comment.RegisterCommentReq;
import com.example.nawa6practice.controller.view.comment.UpdateCommentReq;
import com.example.nawa6practice.domain.Comment;
import com.example.nawa6practice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    /**
     * 등록
     */
    @PostMapping("/register")
    public void register(@RequestBody RegisterCommentReq req) {
        commentService.register(req.getUserId(), req.getPostId(), req.getContent(), req.getImageUrl());
    }

    /**
     * 조회
     */
    @GetMapping()
    public GetCommentsRes gets(@RequestParam Long postId) {
        List<Comment> comments = commentService.gets(postId);

        return new GetCommentsRes(comments);
    }


    /**
     * 수정
     */
    @PostMapping("/update")
    public void update(UpdateCommentReq req) {
        commentService.update(req.getId(), req.getUserId(), req.getContent(), req.getImageUrl());
    }

    /**
     * 삭제
     */
    @PostMapping("/delete")
    public void delete(DeleteCommentReq req) {
        commentService.delete(req.getId(), req.getUserId());
    }


}
