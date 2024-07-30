package com.alcohol.alcohollog.dto.response;

import com.alcohol.alcohollog.domain.User;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "회원가입 응답 DTO")
public record SignUpResponse(
        String nickname
) {
    public static SignUpResponse fromEntity(User user){
        return new SignUpResponse(
                user.getNickname()
        );
    }

}
