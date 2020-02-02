package com.example.cleanarchitecture.common.type;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@IntDef({
        ErrorCode.DEFAULT,
        ErrorCode.NETWORK,
        ErrorCode.SERVICE,
        ErrorCode.SQL,
        ErrorCode.SESSION,
        ErrorCode.BAD_REQUEST,
        ErrorCode.UNAUTHORIZED,
        ErrorCode.FORBIDDEN,
        ErrorCode.NOT_FOUND,
        ErrorCode.UPDATE_USER_INFO,
        ErrorCode.UPDATE_APP,
        ErrorCode.INTERNAL_SERVER,
        ErrorCode.NOT_IMPLEMENTED,
        ErrorCode.BAD_GATEWAY,
        ErrorCode.SERVICE_UNAVAIABLE,
        ErrorCode.GATEWAY_TIMEOUT
})

public @interface ErrorCode {
    int DEFAULT = 0;
    int NETWORK = 1;
    int SERVICE = 2;
    int SQL = 3;
    int SESSION = 4;
    int HTTP = 5;
    int BAD_REQUEST = 400;
    int UNAUTHORIZED = 401;
    int FORBIDDEN = 403;
    int NOT_FOUND = 404;
    int UPDATE_USER_INFO = 417;
    int UPDATE_APP = 424;
    int INTERNAL_SERVER = 500;
    int NOT_IMPLEMENTED = 501;
    int BAD_GATEWAY = 502;
    int SERVICE_UNAVAIABLE = 503;
    int GATEWAY_TIMEOUT = 504;
}
