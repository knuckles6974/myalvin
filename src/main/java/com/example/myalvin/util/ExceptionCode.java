package com.example.myalvin.util;

public enum ExceptionCode {
    UNABLE_TO_CONVERT_LIST_TO_STRING("Unable to convert List to String"),
    UNABLE_TO_CONVERT_STRING_TO_LIST("Unable to convert String to List");

    private final String message;

    ExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
