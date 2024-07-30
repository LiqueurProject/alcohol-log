package com.alcohol.alcohollog.service;

<<<<<<< Updated upstream
import com.alcohol.alcohollog.dto.request.SignUpRequest;
import com.alcohol.alcohollog.dto.response.SignUpResponse;
=======
import com.alcohol.alcohollog.dto.request.LoginRequest;
import com.alcohol.alcohollog.dto.request.SignUpRequest;
import com.alcohol.alcohollog.dto.response.SignUpResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
>>>>>>> Stashed changes

public interface UserService {
    /**
     * 회원가입 처리 메서드
     * @param request 사용자의 가입 요청 정보를 담은 객체
     * @return 가입된 사용자 정보를 담은 응답 객체
     */
    SignUpResponse signup(SignUpRequest request);
<<<<<<< Updated upstream
=======

    /**
     * 로그인 처리 메서드
     *
     * @param request 사용자의 가입 요청 정보를 담은 객체
     * @return 토큰 반환
     */
    String login(LoginRequest request);

    /**
     * 이메일로 사용자 찾기
     *
     * @param email 사용자 이메일
     * @return 사용자 객체 반환
     */
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
>>>>>>> Stashed changes
}
