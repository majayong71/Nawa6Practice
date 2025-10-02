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
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 유저
     **/
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    /**
     * 게시글
     **/
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    /**
     * 상태
     *
     * @Enumerated Type.ORIGINAL = enum 순서(숫자)값을 DB에 저장
     * @Enumerated Type.STRING = enum 이름을 DB에 저장
     **/
    @Enumerated(EnumType.STRING)
    private BookmarkStatus status = BookmarkStatus.REGISTERED;

    /**
     * 생성 일시
     **/
    private LocalDateTime createdAt = LocalDateTime.now();

    /**
     * 삭제 일시
     **/
    private LocalDateTime deletedAt;

    public Bookmark(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public void delete(User user) {
        if (this.user != user) {
            throw new IllegalStateException("check fail");
        }

        if (this.status != BookmarkStatus.REGISTERED) {
            throw new IllegalStateException("check fail");
        }

        this.status = BookmarkStatus.DELETED;
        this.deletedAt = LocalDateTime.now();
    }
}
