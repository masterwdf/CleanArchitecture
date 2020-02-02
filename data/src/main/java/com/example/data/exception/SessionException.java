package com.example.data.exception;

public class SessionException extends Exception {

    private static final String TAG = "SessionException";

    public SessionException() {
        super();
    }

    public SessionException(final String message) {
        super(message);
    }

    public SessionException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public SessionException(final Throwable cause) {
        super(cause);
    }
}
