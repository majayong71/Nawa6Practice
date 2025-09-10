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
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 유저
     **/

    /**
     * 게시글
     **/

    /** 상태 **/
    /** @Enumerated Type.ORIGINAL = enum 순서(숫자)값을 DB에 저장  **/
    /**
     * @Enumerated Type.STRING = enum 이름을 DB에 저장
     **/

    /**
     * 생성 일시
     **/

    /**
     * 삭제 일시
     **/


}
