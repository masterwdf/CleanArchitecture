package com.example.data.exception;

public class ForbiddenException extends Exception {

    private static final String TAG = "ForbiddenException";

    public ForbiddenException() {
        super();
    }

    public ForbiddenException(final String message) {
        super(message);
    }

    public ForbiddenException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ForbiddenException(final Throwable cause) {
        super(cause);
    }
}