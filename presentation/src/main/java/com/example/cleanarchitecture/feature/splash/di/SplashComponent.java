package com.example.cleanarchitecture.feature.splash.di;

import com.example.cleanarchitecture.di.PerActivity;
import com.example.cleanarchitecture.di.component.ActivityComponent;
import com.example.cleanarchitecture.di.component.AppComponent;
import com.example.cleanarchitecture.di.module.ActivityModule;
import com.example.cleanarchitecture.feature.splash.SplashFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, SplashModule.class})
public interface SplashComponent extends ActivityComponent {

    void inject(SplashFragment fragment);
}
