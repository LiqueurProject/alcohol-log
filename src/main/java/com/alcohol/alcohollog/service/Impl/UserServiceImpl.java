package com.alcohol.alcohollog.service.Impl;

import com.alcohol.alcohollog.domain.User;
import com.alcohol.alcohollog.dto.request.SignUpRequest;
import com.alcohol.alcohollog.dto.response.SignUpResponse;
import com.alcohol.alcohollog.exception.AlcoholLogException;
import com.alcohol.alcohollog.exception.ErrorCode;
import com.alcohol.alcohollog.repository.UserRepository;
import com.alcohol.alcohollog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;

    /**
     * 회원가입 처리 메서드
     *
     * @param request 사용자의 가입 요청 정보를 담은 객체
     * @return 가입된 사용자 정보를 담은 응답 객체
     * @throws AlcoholLogException 이메일이 중복된 경우 발생
     */
    @Transactional
    @Override
    public SignUpResponse signup(SignUpRequest request) {
        userRepository.findByEmail(request.email()).ifPresent(it -> {
            throw new AlcoholLogException(ErrorCode.DUPLICATED_EMAIL, String.format("email is %s", request.email()));
        });
        User savedUser = userRepository.save(User.of(
                request.email(),
                encoder.encode(request.password()),
                request.nickname(),
                User.RegisterType.STANDARD
        ));
        return SignUpResponse.fromEntity(savedUser);
    }
}
