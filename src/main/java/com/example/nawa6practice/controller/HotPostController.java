package com.example.nawa6practice.controller;

import com.example.nawa6practice.controller.view.HotPost.DeleteHotPostReq;
import com.example.nawa6practice.controller.view.HotPost.GetHotPostsRes;
import com.example.nawa6practice.controller.view.HotPost.RegisterHotPostReq;
import com.example.nawa6practice.controller.view.HotPost.UpdateHotPostReq;
import com.example.nawa6practice.domain.HotPost;
import com.example.nawa6practice.service.HotPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotposts")
@RequiredArgsConstructor
public class HotPostController {

    private final HotPostService hotPostService;

    @PostMapping("/register")
    public void register(RegisterHotPostReq req) {
        hotPostService.register(req.getPostId(), req.getDate(), req.getRank(), req.getCategory());
    }

    @GetMapping
    public GetHotPostsRes gets() {
        List<HotPost> hotPosts = hotPostService.gets();

        return new GetHotPostsRes(hotPosts);
    }

    @PostMapping("/update")
    public void update(UpdateHotPostReq req) {
        hotPostService.update(req.getId(), req.getPostId(), req.getDate(), req.getRank(), req.getCategory());
    }

    @PostMapping("/delete")
    public void delete(DeleteHotPostReq req) {
        hotPostService.delete(req.getId());
    }
}
