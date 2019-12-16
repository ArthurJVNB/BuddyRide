package com.faculdade.buddyride.Exceptions;

import com.faculdade.buddyride.Enums.EnumControllerException;

public class ControllerException extends AbstractException {
    public ControllerException(EnumControllerException code) {
        super(code);
    }
}
