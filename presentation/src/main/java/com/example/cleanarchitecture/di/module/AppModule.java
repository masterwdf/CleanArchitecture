package com.example.cleanarchitecture.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.cleanarchitecture.BaseApplication;
import com.example.cleanarchitecture.UIThread;
import com.example.data.executor.JobExecutor;
import com.example.data.manager.ISessionManager;
import com.example.data.manager.SessionManager;
import com.example.data.repository.SessionDataRepository;
import com.example.data.repository.UserDataRepository;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.repository.SessionRepository;
import com.example.domain.repository.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Módulo Dagger que proporciona objetos que vivirán durante el ciclo de vida de la aplicación.
 */

@Module
public class AppModule {

    private final BaseApplication app;

    /**********************************************************/

    public AppModule(BaseApplication app) {
        this.app = app;
    }

    /**********************************************************/

    @Provides
    @Singleton
    Context provideContext() {
        return this.app;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Context context) {
        return context.getSharedPreferences("", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    ISessionManager provideSessionManager(SessionManager sessionManager) {
        return sessionManager;
    }

    /**********************************************************/

    @Provides
    @Singleton
    SessionRepository provideSessionRepository(SessionDataRepository sessionDataRepository) {
        return sessionDataRepository;
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(UserDataRepository userDataRepository) {
        return userDataRepository;
    }
}
