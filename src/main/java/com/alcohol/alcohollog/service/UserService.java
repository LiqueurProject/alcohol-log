package com.alcohol.alcohollog.service;

import com.alcohol.alcohollog.dto.request.SignUpRequest;
import com.alcohol.alcohollog.dto.response.SignUpResponse;

public interface UserService {
    /**
     * 회원가입 처리 메서드
     * @param request 사용자의 가입 요청 정보를 담은 객체
     * @return 가입된 사용자 정보를 담은 응답 객체
     */
    SignUpResponse signup(SignUpRequest request);
}
