package com.faculdade.buddyride.Exceptions;

public class RepositoryException extends AbstractException {
    public RepositoryException(EnumRepositoryException code) {
        super(code);
    }
}
