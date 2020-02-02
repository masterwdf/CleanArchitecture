package com.example.cleanarchitecture.di.module;

import android.app.Activity;

import com.example.cleanarchitecture.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Módulo Dagger que proporciona objetos que vivirán durante el ciclo de vida de una actividad.
 */

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return this.activity;
    }
}
