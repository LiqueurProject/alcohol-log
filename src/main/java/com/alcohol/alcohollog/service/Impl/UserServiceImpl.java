package com.alcohol.alcohollog.service.Impl;

<<<<<<< Updated upstream
import com.alcohol.alcohollog.domain.User;
=======
import com.alcohol.alcohollog.config.jwt.JwtTokenUtils;
import com.alcohol.alcohollog.domain.User;
import com.alcohol.alcohollog.dto.request.LoginRequest;
>>>>>>> Stashed changes
import com.alcohol.alcohollog.dto.request.SignUpRequest;
import com.alcohol.alcohollog.dto.response.SignUpResponse;
import com.alcohol.alcohollog.exception.AlcoholLogException;
import com.alcohol.alcohollog.exception.ErrorCode;
import com.alcohol.alcohollog.repository.UserRepository;
import com.alcohol.alcohollog.service.UserService;
import lombok.RequiredArgsConstructor;
<<<<<<< Updated upstream
=======
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
>>>>>>> Stashed changes
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
<<<<<<< Updated upstream
public class UserServiceImpl implements UserService {
    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;

=======
public class UserServiceImpl implements UserService, UserDetailsService {
    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;

    // jwt 시크릿 키
    @Value("${jwt.token.secret}")
    private String secretKey;
    // 만료 기간 (24시)
    @Value("${jwt.token.expired}")
    private Long expiredTimeMs;

>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======

    /**
     * 로그인 처리 메서드
     *
     * @param request 사용자의 가입 요청 정보를 담은 객체
     * @return 토큰 반환
     */
    @Override
    public String login(LoginRequest request) {
        UserDetails savedUser = loadUserByUsername(request.email());
        if (!encoder.matches(request.password(), savedUser.getPassword())) {
            throw new AlcoholLogException(ErrorCode.INVALID_PASSWORD);
        }
        return JwtTokenUtils.generateAccessToken(request.email(), secretKey, expiredTimeMs);
    }

    /**
     * 이메일로 사용자 찾기
     *
     * @param email 사용자 이메일
     * @return 사용자 객체 반환
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new AlcoholLogException(ErrorCode.USER_NOT_FOUND, String.format("email is %s", email)));
    }
>>>>>>> Stashed changes
}
