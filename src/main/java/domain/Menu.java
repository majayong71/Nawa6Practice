package domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 레스토랑
     * 다대일구조 Restaurant (1) ←──── Menu (N)
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

    /**
     * 이름
     */
    @Column(length = 20)
    private String name;

    /**
     * 가격
     */
    @Column(length = 20)
    private int price;

    /**
     * 설명
     */
    @Column(length = 100)
    private String description;

    /**
     * 대표 여부
     */
    private boolean isMain;

    /**
     * 이미지
     */
    @Column(length = 200)
    private String imageUrl;

    /**
     * 상태
     */
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private MenuStatus status = MenuStatus.REGISTERED;

    /**
     * 노출 여부
     */
    private boolean visible = true;

    /**
     * 생성 일시
     */
    private LocalDateTime createdAt = LocalDateTime.now();

    /**
     * 삭제 일시
     */
    private LocalDateTime deletedAt;

    public Menu(
            Restaurant restaurant, String name, int price, String description, boolean isMain, String imageUrl
    ) {
        this.restaurant = restaurant;
        this.name = name;
        this.price = price;
        this.description = description;
        this.isMain = isMain;
        this.imageUrl = imageUrl;
    }

    /**
     * 수정
     */
    public void update(
            String name, int price, String description, boolean isMain, String imageUrl
    ) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.isMain = isMain;
        this.imageUrl = imageUrl;
    }

    /**
     * 삭제
     */
    public void delete() {
        if (this.status != MenuStatus.REGISTERED) {
            throw new IllegalStateException("check fail");
        }

        this.visible = false;
        this.status = MenuStatus.DELETED;
        this.deletedAt = LocalDateTime.now();
    }
}
