package com.example.data.repository.datasource.user;

import com.example.data.entity.UserEntity;
import com.example.data.net.service.IUserService;

import io.reactivex.Observable;

/**
 * Clase encargada de obtener los datos desde un servicio
 */

class UserCloudDataStore implements UserDataStore {

    private final IUserService service;

    /**
     * Constructor que recibe el servicio ha ser ejecutado
     *
     * @param service Clase encargado de ejecutar un metodo del servicio
     */

    UserCloudDataStore(IUserService service) {
        this.service = service;
    }

    @Override
    public Observable<UserEntity> getUser() {
        return this.service.getUser();
    }
}
