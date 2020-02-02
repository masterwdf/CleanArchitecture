package com.example.cleanarchitecture.di.component;

import android.app.Activity;

import com.example.cleanarchitecture.di.PerActivity;
import com.example.cleanarchitecture.di.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
