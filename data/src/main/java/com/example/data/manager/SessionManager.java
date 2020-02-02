package com.example.data.manager;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.annotations.NonNull;

@Singleton
public class SessionManager implements ISessionManager {

    private static final String TAG = "SessionManager";
    private final Context context;
    private static SessionManager INSTANCE;

    @Inject
    SessionManager(@NonNull Context context) {
        this.context = context.getApplicationContext();
    }

    public static synchronized SessionManager getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new SessionManager(context);
        }

        return INSTANCE;
    }

    @Override
    public String getToken() {
        return "";
    }
}
