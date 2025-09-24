package com.example.nawa6practice.controller;

import com.example.nawa6practice.controller.view.post.*;
import com.example.nawa6practice.domain.Post;
import com.example.nawa6practice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/search")
    public GetPostsRes search(SearchPostReq req) {
        List<Post> post = postService.search(req.getSearchCategory(), req.getKeyword());

        return new GetPostsRes(post);
    }


    @GetMapping()
    public GetPostsRes gets() {
        List<Post> post = postService.gets();

        return new GetPostsRes(post);
    }

    @GetMapping("/{id}")
    public GetPostRes get(@PathVariable Long id) {
        Post post = postService.get(id);

        return new GetPostRes(
                post.getTitle(), post.getContent(), post.getCategory(), post.getImageUrl(),
                post.getCommentCount(), post.getViewCount()
        );
    }

    @GetMapping("/users/{id}")
    public GetPostsRes getByUserId(@PathVariable Long id) {
        List<Post> post = postService.getByUserId(id);

        return new GetPostsRes(post);
    }

    @PostMapping("/update")
    public void update(@RequestBody UpdatePostReq req) {
        postService.update(
                req.getPostId(), req.getUserId(), req.getPostCategory(), req.getTitle(), req.getContent(),
                req.getMainImageUrl()
        );
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeletePostReq req) {
        postService.delete(req.getPostId(), req.getUserId());
    }


}
