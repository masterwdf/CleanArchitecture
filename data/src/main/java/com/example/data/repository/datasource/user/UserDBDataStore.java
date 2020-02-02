package com.example.data.repository.datasource.user;

import android.content.Context;

import com.example.data.entity.UserEntity;

import io.reactivex.Observable;

/**
 * Clase encargada de obtener la data desde el SQLite
 * dicha clase se instancaria una sola vez y se mantendra mientras la aplicacion este viva
 */

class UserDBDataStore implements UserDataStore {

    private final Context context;

    /**
     * Constructor
     *
     * @param context contexto que llamo al SQLite
     */

    UserDBDataStore(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    @Override
    public Observable<UserEntity> getUser() {
        throw new UnsupportedOperationException("No se va a implementar");
    }
}
