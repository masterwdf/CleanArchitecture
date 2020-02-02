package com.example.data.mapper;

import com.example.data.entity.UserEntity;
import com.example.domain.entity.User;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Clase encarga de realizar el mapeo de la entidad loginOnline(tabla o json) a
 * una entidad del dominio
 */

@Singleton
public class UserEntityDataMapper {

    @Inject
    UserEntityDataMapper() {

    }

    /**
     * Transforma la entidad a una entidad del dominio.
     *
     * @param input Entidad tipo tabla o json
     * @return object Entidad de dominio
     */

    public User transform(UserEntity input) {
        User output = null;

        if (null != input) {
            output = new User();
        }

        return output;
    }
}
