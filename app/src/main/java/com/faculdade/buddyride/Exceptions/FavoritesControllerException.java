package com.faculdade.buddyride.Exceptions;

public class FavoritesControllerException extends AbstractException {
    public enum EnumExceptionType {
        FAVORITE_NOT_FOUND,
        INVALID_USER
    }

    public FavoritesControllerException(EnumExceptionType code) {
        super(code);
    }
}
