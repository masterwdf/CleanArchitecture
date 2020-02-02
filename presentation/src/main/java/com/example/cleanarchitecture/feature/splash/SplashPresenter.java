package com.example.cleanarchitecture.feature.splash;

import android.support.annotation.NonNull;

import com.example.cleanarchitecture.base.mvp.Presenter;
import com.example.cleanarchitecture.exception.ErrorFactory;
import com.example.domain.entity.User;
import com.example.domain.interactor.BaseObserver;
import com.example.domain.interactor.UserUseCase;

import javax.inject.Inject;

public class SplashPresenter implements Presenter<SplashView> {

    private final UserUseCase userUseCase;
    private SplashView splashView;

    @Inject
    SplashPresenter(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @Override
    public void attachView(@NonNull SplashView view) {
        splashView = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        userUseCase.dispose();
        splashView = null;
    }

    /**********************************************************/

    /**
     * CUS 1:   Verifica la versión de la app.
     * Esto es importante para determinar si el flujo se cancelara o dejara continuar
     */

    public void getUser() {
        this.userUseCase.getUser(new VerifyVersionObserver());
    }

    /**********************************************************/

    private final class VerifyVersionObserver extends BaseObserver<User> {

        User user;

        @Override
        public void onNext(User user) {
            this.user = user;
        }

        @Override
        public void onComplete() {
            if (splashView != null) {
                splashView.showUser(user);
            }
        }

        @Override
        public void onError(Throwable exception) {
            super.onError(exception);

            if (splashView != null) {
                splashView.onError(ErrorFactory.create(exception));
            }
        }
    }
}
