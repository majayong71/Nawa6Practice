package domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 유저
 */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 이메일
     */
    @Column(length = 50)
    private String email;

    /**
     * 비밀번호
     */
    @Column(length = 100)
    private String password;

    /**
     * 닉네임
     */
    @Column(length = 50)
    private String nickname;

    /**
     * 상태 - 가입 / 인증됨(활성화) / 비활성화 / 탈퇴
     */
    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.ACTIVE;

    /**
     * 생성 일시
     */
    private LocalDateTime createdAt = LocalDateTime.now();

    /**
     * 삭제 일시
     */
    private LocalDateTime deletedAt;

    public User(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    /**
     * 마이페이지 회원 정보 수정
     **/
    private void update(String nickname) {
        this.nickname = nickname;
        // 전화번호 , 회원정보 수정 등
    }

    public void delete() {
        if (this.status != UserStatus.ACTIVE) {
            throw new IllegalStateException("check fail");
        }

        this.status = UserStatus.DELETED;
        this.deletedAt = LocalDateTime.now();
    }
}

/**
 * 컨트롤러(API) [POST] www.naver.com/user/register -> 회원가입
 *
 * @RestController
 * @RequestMapping("/user") public void register() {
 * <p>
 * <p>
 * <p>
 * }
 * <p>
 * 서비스(로직 담당)
 * <p>
 * 도메인(엔티티, 테이블)
 */
