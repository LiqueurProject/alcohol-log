package com.alcohol.alcohollog.repository;

import com.alcohol.alcohollog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 이메일로 사용자를 찾는 메서드
     *
     * @param email 찾고자 하는 사용자의 이메일
     * @return 주어진 이메일을 가진 사용자가 존재하는 경우 Optional에 포함된 User 객체, 그렇지 않은 경우 빈 Optional
     */
    Optional<User> findByEmail(String email);
}
