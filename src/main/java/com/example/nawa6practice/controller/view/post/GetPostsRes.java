package com.example.nawa6practice.controller.view.post;

import com.example.nawa6practice.domain.Post;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GetPostsRes {
    private final List<PostData> posts;

    public GetPostsRes(List<Post> posts) {
        this.posts = posts.stream().map(post -> new PostData(
                        post.getId(), post.getTitle(), post.getContent(), post.getCategory(), post.getImageUrl(),
                        post.getCommentCount(), post.getViewCount()
                )
        ).collect(Collectors.toList());
    }
}
