package com.example.cleanarchitecture.di.component;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.cleanarchitecture.base.BaseActivity;
import com.example.cleanarchitecture.di.module.AppModule;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.repository.SessionRepository;
import com.example.domain.repository.UserRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(BaseActivity activity);

    /**********************************************************/

    Context context();

    SharedPreferences sharedPreferences();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();

    /**********************************************************/

    SessionRepository sessionRepository();

    UserRepository userRepository();
}
