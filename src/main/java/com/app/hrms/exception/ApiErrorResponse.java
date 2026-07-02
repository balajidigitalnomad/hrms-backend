package com.app.hrms.exception;

public class ApiErrorResponse extends RuntimeException {
    public ApiErrorResponse(String message) {
        super(message);
    }
}
