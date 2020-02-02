package com.example.data.exception;

public class UnauthorizedException extends Exception {

    private static final String TAG = "UnauthorizedException";

    public UnauthorizedException() {
        super();
    }

    public UnauthorizedException(final String message) {
        super(message);
    }

    public UnauthorizedException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UnauthorizedException(final Throwable cause) {
        super(cause);
    }
}