package com.example.nawa6practice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    /**
     * 제목
     */
    @Column(length = 50)
    private String title;

    /**
     * 내용
     */
    @Column(length = 300)
    private String content;

    /**
     * 카테고리
     */
    @Enumerated(EnumType.STRING)
    private PostCategory category;

    /**
     * 이미지
     */
    @Column(length = 200)
    private String imageUrl;

    /**
     * 댓글수
     */
    private int commentCount;

    /**
     * 조회수
     */
    private int viewCount;

    /**
     * 상태
     */
    @Enumerated(EnumType.STRING)
    private PostStatus status = PostStatus.REGISTERED;

    /**
     * 생성 일시
     **/
    private LocalDateTime createdAt = LocalDateTime.now();

    /**
     * 삭제 일시
     **/
    private LocalDateTime deletedAt;

    public Post(User user, String title, String content, PostCategory category, String imageUrl) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    /**
     * 수정
     */
    public void update(Long userId, String title, String content, PostCategory category, String imageUrl) {
        if (this.user.getId() != userId) {
            throw new IllegalArgumentException("check failed.");
        }

        this.title = title;
        this.content = content;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    /**
     * 삭제
     */
    public void delete(Long userId) {
        if (this.user.getId() != userId) {
            throw new IllegalArgumentException("check failed.");
        }

        if (this.status == PostStatus.DELETED) {
            throw new IllegalStateException("check failed");
        }

        this.status = PostStatus.DELETED;
        this.deletedAt = LocalDateTime.now();
    }
}
