package com.technopreneur.exceptions;

public class RepoSearchException extends RuntimeException {

    public RepoSearchException(final String message) {
        super(message);
    }

    public RepoSearchException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
