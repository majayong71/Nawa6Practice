package com.example.nawa6practice.controller.view.HotPost;

import com.example.nawa6practice.domain.HotPost;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GetHotPostsRes {
    private final List<HotPostData> hotposts;

    public GetHotPostsRes(List<HotPost> hotposts) {
        this.hotposts = hotposts.stream().map(hotPost -> new HotPostData(
                        hotPost.getPost().getId(), hotPost.getDate(), hotPost.getRank(), hotPost.getCategory()
                )
        ).collect(Collectors.toList());
    }
}
