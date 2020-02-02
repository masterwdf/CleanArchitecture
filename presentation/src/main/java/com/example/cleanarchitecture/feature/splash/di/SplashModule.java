package com.example.cleanarchitecture.feature.splash.di;

import com.example.cleanarchitecture.di.PerActivity;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.interactor.UserUseCase;
import com.example.domain.repository.UserRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Módulo Dagger que proporciona los casos de usos del Splash.
 */

@Module
public class SplashModule {

    public SplashModule() {
    }

    @Provides
    @PerActivity
    UserUseCase providesUserUseCase(UserRepository userRepository,
                                    ThreadExecutor threadExecutor,
                                    PostExecutionThread postExecutionThread) {
        return new UserUseCase(userRepository, threadExecutor, postExecutionThread);
    }
}
