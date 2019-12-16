package com.faculdade.buddyride.Exceptions;

public class UserControllerException extends AbstractException {
    public enum EnumExceptionType {
        INVALID_NAME,
        INVALID_EMAIL,
        INVALID_PASSWORD,
        USER_NOT_FOUND,
        USER_ALREADY_EXISTS
    }

    public UserControllerException(EnumExceptionType code) {
        super(code);
    }
}
