package com.app.hrms.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message, Long displayValue){
        super(message +" : "+ displayValue);
    }
}
