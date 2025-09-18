package com.example.nawa6practice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 유저
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    /**
     * 게시글
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    /**
     * 내용
     */
    private String content;

    /**
     * 이미지
     */
    private String imageUrl;

    /**
     * 상태
     */
    @Enumerated(EnumType.STRING)
    private CommentStatus status = CommentStatus.REGISTERED;

    /**
     * 생성 일시
     */
    private LocalDateTime createdAt = LocalDateTime.now();

    /**
     * 삭제 일시
     */
    private LocalDateTime deletedAt;

    public Comment(User user, Post post, String content, String imageUrl) {
        this.user = user;
        this.post = post;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public void update(Long userId, String content, String imageUrl) {
        if (!this.user.getId().equals(userId)) {
            throw new IllegalArgumentException("check fail");
        }

        this.content = content;
        this.imageUrl = imageUrl;
    }

    public void deleted(Long userId) {
        if (!this.user.getId().equals(userId)) {
            throw new IllegalArgumentException("check fail");
        }

        if (this.status != CommentStatus.REGISTERED) {
            throw new IllegalStateException("check fail");
        }

        this.status = CommentStatus.DELETED;
        this.deletedAt = LocalDateTime.now();
    }
}
