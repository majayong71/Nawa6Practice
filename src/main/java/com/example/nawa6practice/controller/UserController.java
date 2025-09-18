package com.example.nawa6practice.controller;

import com.example.nawa6practice.controller.view.user.*;
import com.example.nawa6practice.domain.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.nawa6practice.service.UserService;

@Tag(name = "User-Controller", description = "User CRUD API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    /**
     * 회원 가입
     */
    @PostMapping
    public void register(@RequestBody RegisterUserReq req) {
        userService.register(req.getEmail(), req.getPassword(), req.getNickname());
    }

    /**
     * 로그인
     */
    @PostMapping("/login")
    public LoginUserRes login(@RequestBody LoginUserReq req) {
        String accessToken = userService.login(req.getEmail(), req.getPassword());

        return new LoginUserRes(accessToken);
    }

    /**
     * 회원 조회
     */
    @GetMapping("/{id}")
    @Operation(summary = "회원 조회", description = "회원 조회합니다")
    @ApiResponse(responseCode = "200", description = "ok", content = @Content(schema = @Schema(implementation = GetUserRes.class)))
    public GetUserRes get(@PathVariable Long id) {
        User user = userService.get(id);

        return new GetUserRes(user.getNickname(), user.getEmail());
    }

    /**
     * 정보 수정
     */
    @PostMapping("/update")
    public void update(@RequestBody UpdateUserReq req) {
        userService.update(req.getUserId(), req.getNickname());
    }

    /**
     * 비밀번호 수정
     * userId -> Token
     */
    @PostMapping("/updatePassword")
    public void updatePassword(@RequestBody updatePasswordReq req) {
        userService.updatePassword(req.getUserId(), req.getPassword());
    }

    /**
     * 삭제
     */
    @PostMapping("/delete")
    public void delete(@RequestBody DeleteUserReq req) {
        userService.delete(req.getUserId());
    }

}
