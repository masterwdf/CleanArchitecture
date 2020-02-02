package com.example.cleanarchitecture.feature.splash;

import android.os.Bundle;

import com.example.cleanarchitecture.R;
import com.example.cleanarchitecture.base.BaseActivity;
import com.example.cleanarchitecture.di.HasComponent;
import com.example.cleanarchitecture.feature.splash.di.DaggerSplashComponent;
import com.example.cleanarchitecture.feature.splash.di.SplashComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SplashActivity extends BaseActivity implements HasComponent<SplashComponent> {

    SplashFragment splashFragment;
    SplashComponent component;
    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        init(savedInstanceState);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initializeInjector();

        if (savedInstanceState == null) {
            splashFragment = new SplashFragment();
            addFragment(R.id.content_main, splashFragment);
        }
    }

    @Override
    protected void initializeInjector() {
        this.component = DaggerSplashComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    protected void onDestroy() {
        if (unbinder != null) {
            unbinder.unbind();
        }

        super.onDestroy();
    }

    @Override
    public SplashComponent getComponent() {
        return component;
    }
}
