package service;

import domain.Comment;

import java.util.List;

public interface CommentService {
    /**
     * 댓글 등록
     **/
    void register(Long userId, Long postId, String content, String imageUrl);

    /**
     * 댓글 조회
     **/
    List<Comment> gets(Long postId);

    /**
     * 댓글 수정
     **/
    void update(Long id, Long userId, String content, String imageUrl);

    /**
     * 댓글 삭제
     **/
    void delete(Long id, Long userId);
}
