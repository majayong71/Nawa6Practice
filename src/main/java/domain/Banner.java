package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 배너 이미지
     */

    /**
     * 링크 Url
     */

    /**
     * 노출 순서
     */

    /**
     * 상태
     */

    /**
     * 노출 여부
     */

    /**
     * 노출 일시
     */

    /**
     * 생성 일시
     */

    /**
     * 삭제 일시
     */

}
