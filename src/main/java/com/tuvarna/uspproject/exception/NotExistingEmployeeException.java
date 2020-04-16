package com.tuvarna.uspproject.exception;

public final class NotExistingEmployeeException extends RuntimeException {

    public NotExistingEmployeeException(String message){
        super(message);
    }
}
