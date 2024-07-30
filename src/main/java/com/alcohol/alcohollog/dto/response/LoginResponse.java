package com.alcohol.alcohollog.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "로그인 응답 DTO")
public record LoginResponse(
        String token
) {
}
