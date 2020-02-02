package com.example.cleanarchitecture.feature.splash;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cleanarchitecture.R;
import com.example.cleanarchitecture.base.BaseFragment;
import com.example.cleanarchitecture.common.error.ErrorModel;
import com.example.cleanarchitecture.feature.splash.di.SplashComponent;
import com.example.domain.entity.User;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SplashFragment extends BaseFragment implements SplashView {

    @Inject
    SplashPresenter presenter;

    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected boolean onInjectView() throws IllegalStateException {
        getComponent(SplashComponent.class).inject(this);
        return true;
    }

    @Override
    protected void onViewInjected(@Nullable Bundle savedInstanceState) {
        super.onViewInjected(savedInstanceState);
        presenter.attachView(this);
        presenter.getUser();
    }

    @Override
    public void onDestroy() {
        if (presenter != null) {
            presenter.destroy();
        }

        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        if (unbinder != null) {
            unbinder.unbind();
        }

        super.onDestroyView();
    }

    @Override
    public Context context() {
        FragmentActivity activity = getActivity();
        if (activity != null)
            return activity.getApplicationContext();
        else
            return null;
    }

    @Override
    public void onError(ErrorModel errorModel) {
        processError(errorModel);
    }

    @Override
    public void showUser(User user) {
        //show
    }
}
