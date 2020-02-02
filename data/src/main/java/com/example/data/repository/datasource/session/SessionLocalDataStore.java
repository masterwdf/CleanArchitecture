package com.example.data.repository.datasource.session;

import android.content.Context;

import com.example.data.manager.ISessionManager;

public class SessionLocalDataStore implements SessionDataStore {

    private final ISessionManager sessionManager;
    private Context context;

    public SessionLocalDataStore(ISessionManager sessionManager, Context context) {
        this.sessionManager = sessionManager;
        this.context = context;
    }
}
