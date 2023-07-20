package com.example.myalvin.util;

import com.example.myalvin.util.ExceptionCode;

public class BusinessLogicException extends RuntimeException {


    public BusinessLogicException(ExceptionCode code) {
        super(code.getMessage());
    }
}