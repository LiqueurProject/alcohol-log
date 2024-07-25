package com.alcohol.alcohollog.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AlcoholLogException extends RuntimeException{
    private final ErrorCode errorCode;
    private final String message;

    @Override
    public String getMessage() {
        if (message == null) {
            return errorCode.getMessage();
        } else {
            return String.format("%s. %s", errorCode.getMessage(), message);
        }
    }
}
