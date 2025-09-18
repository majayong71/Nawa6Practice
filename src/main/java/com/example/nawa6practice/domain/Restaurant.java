package com.example.nawa6practice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    @Column(length = 25)
    private String name;

    /**
     * 카테고리
     */
    @Enumerated(EnumType.STRING)
    private RestaurantCategory category;

    /**
     * 주소
     **/
    @Column(length = 100)
    private String address;

    /**
     * 영업 시간 [ Local Date Time 이 아닌 String 으로 바꿔야할까 ]
     * ex ) 김밥천국 09 : 00 ~ 23 : 00 월 휴무
     **/
    @Column(length = 20)
    private String businessHours;

    /**
     * 연락처
     **/
    @Column(length = 100)
    private String phoneNumber;

    /**
     * 설명
     */
    @Column(length = 100)
    private String description;

    /**
     * 대표 이미지
     */
    @Column(length = 100)
    private String mainImageUrl;

    /**
     * 노출 여부
     */
    private boolean visible = true;

    /**
     * 삭제
     */
    @Enumerated(EnumType.STRING)
    private RestaurantStatus status = RestaurantStatus.REGISTERED;

    /**
     * 생성 일시
     */
    private LocalDateTime createdAt = LocalDateTime.now();

    /**
     * 삭제 일시
     */
    private LocalDateTime deletedAt;

    public Restaurant(String name, RestaurantCategory category, String address, String businessHours, String phoneNumber, String description, String mainImageUrl) {
        this.name = name;
        this.category = category;
        this.address = address;
        this.businessHours = businessHours;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.mainImageUrl = mainImageUrl;
    }

    /**
     * 수정
     */
    public void update(String name, RestaurantCategory category, String address, String businessHours, String phoneNumber, String description, String mainImageUrl, boolean visible) {
        this.name = name;
        this.category = category;
        this.address = address;
        this.businessHours = businessHours;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.mainImageUrl = mainImageUrl;
        this.visible = visible;
    }

    /**
     * 삭제
     */
    public void delete() {
        if (this.status != RestaurantStatus.REGISTERED) {
            throw new IllegalStateException("check fail");
        }

        this.status = RestaurantStatus.DELETED;
        this.deletedAt = LocalDateTime.now();
    }
}
