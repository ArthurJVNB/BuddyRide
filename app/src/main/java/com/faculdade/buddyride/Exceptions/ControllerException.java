package com.faculdade.buddyride.Exceptions;

public class ControllerException extends AbstractException {
    public ControllerException(EnumControllerException code) {
        super(code);
    }
}
