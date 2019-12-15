package com.faculdade.buddyride.Exceptions;

import androidx.annotation.Nullable;

public abstract class AbstractException extends Exception {
    public AbstractException(Enum code) {
        super(code.toString());
    }

    @Nullable
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
