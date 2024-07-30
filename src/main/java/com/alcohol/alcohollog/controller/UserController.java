package com.alcohol.alcohollog.controller;

<<<<<<< Updated upstream
import com.alcohol.alcohollog.dto.request.SignUpRequest;
=======
import com.alcohol.alcohollog.dto.request.LoginRequest;
import com.alcohol.alcohollog.dto.request.SignUpRequest;
import com.alcohol.alcohollog.dto.response.LoginResponse;
>>>>>>> Stashed changes
import com.alcohol.alcohollog.dto.response.Response;
import com.alcohol.alcohollog.dto.response.SignUpResponse;
import com.alcohol.alcohollog.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User API", description = "유저 관련 api")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * 회원 가입 API 엔드포인트
     * 사용자의 회원 가입 요청을 처리
     *
     * @param request 회원 가입 요청 정보를 담은 객체
     * @return 회원 가입 결과를 담은 응답 객체
     */
    @Operation(summary = "회원 가입 API")
    @PostMapping("/signup")
    public Response<SignUpResponse> signUp(@RequestBody SignUpRequest request){
        return Response.success(userService.signup(request));
    }
<<<<<<< Updated upstream
=======

    /**
     * 로그인 API 엔드포인트
     * 사용자 로그인 요청을 처리
     *
     * @param request 로그인 요청 정보를 담은 객체
     * @return 토큰 반환
     */
    @Operation(summary = "로그인 API")
    @PostMapping("/login")
    public Response<LoginResponse> login(@RequestBody LoginRequest request) {
        String token = userService.login(request);
        return Response.success(new LoginResponse(token));
    }
>>>>>>> Stashed changes
}
