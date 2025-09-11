package domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 유저
     * 여러 리뷰가 하나의 유저를 참조
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    /**
     * 레스토랑
     * 여러 리뷰가 하나의 레스토랑을 참조
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

    /**
     * 내용
     */
    @Column(length = 200)
    private String content;

    /**
     * 이미지
     */
    @Column(length = 200)
    private String imageUrl;

    /**
     * 점수
     **/
    @Column(length = 5)
    private int rating;

    /**
     * 상태
     **/
    @Enumerated(EnumType.STRING)
    private ReviewStatus status = ReviewStatus.REGISTERED;

    /**
     * 생성 일시
     **/
    private LocalDateTime createdAt = LocalDateTime.now();

    /**
     * 삭제 일시
     **/
    private LocalDateTime deletedAt;

    public Review(User user, Restaurant restaurant, String content, String imageUrl, int rating) {
        this.user = user;
        this.restaurant = restaurant;
        this.content = content;
        this.imageUrl = imageUrl;
        this.rating = rating;
    }

    /**
     * 수정
     */
    public void update(Long userId, String content, String imageUrl, int rating) {
        if (this.user.getId() != userId) {
            throw new IllegalArgumentException("check fail");
        }

        this.content = content;
        this.imageUrl = imageUrl;
        this.rating = rating;
    }

    /**
     * 삭제
     */
    public void deleted(Long userId) {
        if (this.user.getId() != userId) {
            throw new IllegalStateException("check fail");
        }

        if (this.status == ReviewStatus.REGISTERED) {
            throw new IllegalStateException("check fail");
        }

        this.status = ReviewStatus.DELETED;
        this.deletedAt = LocalDateTime.now();
    }
}
