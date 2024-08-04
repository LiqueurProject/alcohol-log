package com.alcohol.alcohollog.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collection;
import java.util.List;


@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
    // UUID 바꾸기
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 사용자 이메일
    private String email;

    // 사용자 비밀번호
    private String password;

    // 사용자 닉네임
    private String nickname;

    // 사용자 프로필 사진 경로
    private String profileImage;

    // 사용자 생성 시간
    private Timestamp createdAt;

    // 사용자 수정 시간
    private Timestamp updatedAt;

    // 사용자 삭제 시간
    private Timestamp removedAt;

    // 사용자 등록 타입 (일반 / 소셜)
    @Enumerated(EnumType.STRING)
    private RegisterType registerType;

    public enum RegisterType {
        STANDARD,
        OAUTH
    }

    @PrePersist
    void createdAt() {
        this.createdAt = Timestamp.from(Instant.now());
    }

    @PreUpdate
    void updatedAt() {
        this.updatedAt = Timestamp.from(Instant.now());
    }

    private User(String email, String password, String nickname, String profileImage, RegisterType registerType) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.registerType = registerType;
    }

    private User(String email, String password, String nickname,RegisterType registerType) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.registerType = registerType;
    }


    public static User of(String email, String password, String nickname, String profileImage, RegisterType registerType){
        return new User(email, password, nickname, profileImage, registerType);
    }

    public static User of(String email, String password, String nickname, RegisterType registerType){
        return new User(email, password, nickname, registerType);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(registerType.toString()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return removedAt == null;
    }

    @Override
    public boolean isAccountNonLocked() {
        return removedAt == null;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return removedAt == null;
    }

    @Override
    public boolean isEnabled() {
        return removedAt == null;
    }
}
