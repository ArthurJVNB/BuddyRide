package com.faculdade.buddyride.Exceptions;

public abstract class AbstractException extends Exception {
    AbstractException(Enum code) {
        super(code.toString());
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
