package com.example.cleanarchitecture.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.cleanarchitecture.BaseApplication;
import com.example.cleanarchitecture.common.error.ErrorModel;
import com.example.cleanarchitecture.common.type.ErrorCode;
import com.example.cleanarchitecture.di.component.AppComponent;
import com.example.cleanarchitecture.di.module.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getAppComponent().inject(this);
    }

    /**********************************************************/

    protected abstract void init(Bundle savedInstanceState);

    protected abstract void initializeInjector();

    /**********************************************************/

    public Context context() {
        return getApplicationContext();
    }

    protected void addFragment(int containerViewId, Fragment fragment) {
        addFragment(containerViewId, fragment, true);
    }

    protected void addFragment(int containerViewId, Fragment fragment, boolean isFirst) {
        addFragment(containerViewId, fragment, isFirst, "");
    }

    protected void addFragment(int containerViewId, Fragment fragment, boolean isFirst, String name) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        if (name == null || name.isEmpty())
            fragmentTransaction.add(containerViewId, fragment);
        else
            fragmentTransaction.add(containerViewId, fragment, name);
        if (!isFirst)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    protected void replaceFragment(int containerViewId, Fragment fragment, boolean isFirst) {
        replaceFragment(containerViewId, fragment, isFirst, "");
    }

    protected void replaceFragment(int containerViewId, Fragment fragment, boolean isFirst, String name) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        if (name == null || name.isEmpty())
            fragmentTransaction.replace(containerViewId, fragment);
        else
            fragmentTransaction.replace(containerViewId, fragment, name);
        if (!isFirst)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    protected Fragment getCurrentFragment(@IdRes int id) {
        return getSupportFragmentManager().findFragmentById(id);
    }

    /**********************************************************/

    protected AppComponent getAppComponent() {
        return ((BaseApplication) getApplication()).getAppComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    /**********************************************************/

    protected void processError(ErrorModel errorModel) {
        if (!isFinishing()) {
            error(errorModel);
        }
    }

    private void error(ErrorModel errorModel) {
        switch (errorModel.getCode()) {

            case ErrorCode.NETWORK:
                //showDialog
                break;

            case ErrorCode.UPDATE_APP:
                //showDialog
                break;

            case ErrorCode.HTTP:
            case ErrorCode.BAD_REQUEST:
            case ErrorCode.SERVICE:
            default:
                //showDialog
                break;
        }
    }
}
