package com.example.nawa6practice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HotPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 게시글
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    /**
     * 일자
     */
    private LocalDate date;

    /**
     * 순위
     */
    @Column(name = "rank_", length = 5)
    private int rank;

    /**
     * 카테고리
     */
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private HotPostCategory category;

    /**
     * 상태
     */
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private HotPostStatus status = HotPostStatus.REGISTERED;

    /**
     * 생성 일시
     **/
    private LocalDateTime createdAt = LocalDateTime.now();

    /**
     * 삭제 일시
     **/
    private LocalDateTime deletedAt;

    public HotPost(Post post, LocalDate date, int rank, HotPostCategory category) {
        this.post = post;
        this.date = date;
        this.rank = rank;
        this.category = category;
    }

    public void update(Post post, LocalDate date, int rank, HotPostCategory category) {
        this.post = post;
        this.date = date;
        this.rank = rank;
        this.category = category;
    }

    public void deleted() {
        if (this.status != HotPostStatus.REGISTERED) {
            throw new IllegalStateException("check fail");
        }

        this.status = HotPostStatus.DELETED;
        this.deletedAt = LocalDateTime.now();
    }
}
