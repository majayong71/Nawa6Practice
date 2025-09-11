package controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    /**
     * 회원 가입
     */
    PostMapping
    public void register(@RequestBody) {

    }


    /**
     * 로그인
     */

    /**
     * 회원 조회
     */

    /**
     * 정보 수정
     */

    /**
     * 비밀번호 수정
     * userId -> Token
     */

    /**
     * 삭제
     */

}
