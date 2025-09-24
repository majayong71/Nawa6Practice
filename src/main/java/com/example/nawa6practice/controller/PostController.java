package com.example.nawa6practice.controller;

import com.example.nawa6practice.controller.view.post.GetPostsRes;
import com.example.nawa6practice.controller.view.post.RegisterPostReq;
import com.example.nawa6practice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping("/register")
    public void register(@RequestBody RegisterPostReq req) {
        postService.register(
                req.getUserId(), req.getPostCategory(), req.getTitle(), req.getContent(), req.getMainImageUrl()
        );
    }

    public GetPostsRes getAll(@RequestBody GetPostsReq req) {

    }

}
