package com.faculdade.buddyride.Exceptions;

import com.faculdade.buddyride.Enums.EnumRepositoryException;

public class RepositoryException extends AbstractException {
    public RepositoryException(EnumRepositoryException code) {
        super(code);
    }
}
