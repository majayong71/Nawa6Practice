package domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 여러 리뷰가 하나의 유저를 참조
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    /**
     * 여러 리뷰가 하나의 레스토랑을 참조
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;
}
