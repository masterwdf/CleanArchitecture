package com.example.data.exception;

public class ServiceException extends Exception {

    private static final String TAG = "ServiceException";

    public ServiceException() {
        super();
    }

    public ServiceException(final String message) {
        super(message);
    }

    public ServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ServiceException(final Throwable cause) {
        super(cause);
    }
}