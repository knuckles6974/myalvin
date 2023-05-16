package com.example.myalvin.domain;

import org.springframework.http.HttpStatus;

public enum ErrorContext {

    VALIDATION_FAIL("요청 파타미터가 올바르지 않음", HttpStatus.BAD_REQUEST);

    public final String message;
    public final HttpStatus httpStatus;

    ErrorContext(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }





}
