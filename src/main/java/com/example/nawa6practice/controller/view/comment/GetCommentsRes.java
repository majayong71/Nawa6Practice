package com.example.nawa6practice.controller.view.comment;

import com.example.nawa6practice.domain.Comment;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;


@Getter
public class GetCommentsRes {
    private final List<CommentData> comments;

    public GetCommentsRes(List<Comment> comments) {
        this.comments = comments.stream().map(comment -> new CommentData(
                        comment.getUser().getId(), comment.getPost().getId(), comment.getContent(), comment.getImageUrl()
                )
        ).collect(Collectors.toList());
    }
}
