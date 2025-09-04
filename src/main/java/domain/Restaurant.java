package domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 레스토랑
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity

public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 이름
     **/
    @Column(length = 20)
    private String name;

    /**
     * 카테고리
     */
    @Enumerated(EnumType.STRING)
    private RestaurantCategory category;

    /**
     * 주소
     **/

}
