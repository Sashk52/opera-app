package com.dev.opera.app.exception;

public class AuthenticationException extends Exception {
    public AuthenticationException(String errorMessage) {
        super(errorMessage);
    }
}
