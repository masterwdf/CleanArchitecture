package com.example.cleanarchitecture.feature.splash;

import com.example.cleanarchitecture.base.mvp.LoadingView;
import com.example.cleanarchitecture.base.mvp.View;
import com.example.cleanarchitecture.common.error.ErrorModel;
import com.example.domain.entity.User;

public interface SplashView extends View, LoadingView {

    void onError(ErrorModel errorModel);

    void showUser(User user);
}
