package com.example.cleanarchitecture;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.example.cleanarchitecture.di.component.AppComponent;
import com.example.cleanarchitecture.di.component.DaggerAppComponent;
import com.example.cleanarchitecture.di.module.AppModule;

public class BaseApplication extends Application {

    private static BaseApplication instance;
    private AppComponent appComponent;

    public BaseApplication() {
        instance = this;
    }

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initializeInjector();
    }

    private void initializeInjector() {
        this.appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    /**********************************************************/

    public AppComponent getAppComponent() {
        return this.appComponent;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
