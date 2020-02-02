package com.example.data.net.service.impl;

import android.content.Context;

import com.example.data.entity.UserEntity;
import com.example.data.exception.NetworkConnectionException;
import com.example.data.exception.ServiceException;
import com.example.data.net.RestApi;
import com.example.data.net.service.IUserService;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserService extends BaseService implements IUserService {

    private IUserService service;

    /**
     * Constructor
     *
     * @param context Contexto que llamo al Servicio
     */

    public UserService(Context context, String token) {
        super(context);
        service = RestApi.create(IUserService.class, token);
    }

    /**********************************************************/

    @Override
    public Observable<UserEntity> getUser() {
        return Observable.create(emitter -> {
            if (isThereInternetConnection()) {
                try {
                    service.getUser()
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(emitter::onNext,
                                    error -> {
                                        if (!emitter.isDisposed()) {
                                            emitter.onError(getError(error));
                                        }
                                    },
                                    emitter::onComplete);
                } catch (Exception e) {
                    emitter.onError(new ServiceException(e.getCause()));
                }
            } else if (!emitter.isDisposed()) {
                emitter.onError(new NetworkConnectionException());
            }
        });
    }
}