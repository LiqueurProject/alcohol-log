package com.alcohol.alcohollog.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(title = "회원가입 요청 DTO")
public record SignUpRequest(
        @NotBlank(message = "이메일을 입력해주세요.")
        @Email(message = "이메일 형식에 맞지 않습니다.")
        @Schema(description = "사용자 이메일", example = "test@gamil.com")
        String email,

        @NotBlank
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,15}$"
                , message = "비밀번호는 최소 8자에서 최대 15자 사이이며, 알파벳, 숫자, 특수 문자를 각각 최소 한 개 이상 포함해야 합니다.")
        @Schema(description = "사용자 비밀번호", example = "test123!")
        String password,

        @NotBlank(message = "닉네임을 입력해주세요.")
        @Size(min = 1, max = 20, message = "닉네임은 20글자 이하로 입력해야 합니다.")
        @Schema(description = "사용자 닉네임", example = "rko")
        String nickname
) {
}
