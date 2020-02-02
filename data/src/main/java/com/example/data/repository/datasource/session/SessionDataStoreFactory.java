package com.example.data.repository.datasource.session;

import android.content.Context;

import com.example.data.manager.ISessionManager;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.annotations.NonNull;

@Singleton
public class SessionDataStoreFactory {

    private final Context context;
    private final ISessionManager sessionManager;

    @Inject
    SessionDataStoreFactory(@NonNull Context context, @NonNull ISessionManager sessionManager) {
        this.context = context.getApplicationContext();
        this.sessionManager = sessionManager;
    }

    public SessionDataStore createLocal() {
        return new SessionLocalDataStore(this.sessionManager, context);
    }

}
