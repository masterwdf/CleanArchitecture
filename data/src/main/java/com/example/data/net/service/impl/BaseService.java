package com.example.data.net.service.impl;

import android.content.Context;

import com.example.data.exception.ForbiddenException;
import com.example.data.exception.ServiceException;
import com.example.data.exception.UnauthorizedException;
import com.example.data.net.RestApi;
import com.example.data.util.NetworkUtil;
import com.example.domain.exception.ExpiredSessionException;

/**
 * Clase base de un servicio
 * que contiene los metodos comunes que involucra cualquier servicio
 */

public class BaseService {

    protected final Context context;

    /**
     * Constructor
     *
     * @param context Contexto que llamo al servicio
     */

    BaseService(Context context) {
        if (null == context) {
            throw new IllegalArgumentException("El constructor no puede recibir parametros nulos!!!");
        }

        this.context = context;
    }

    /**
     * Metodo que valida si tiene conexion a internet
     *
     * @return boolean Valor que determina la conectividad del dispositivo
     */

    protected boolean isThereInternetConnection() {
        return NetworkUtil.isThereInternetConnection(context);
    }

    Throwable getError(Throwable error) {
        try {
            Throwable throwable = RestApi.parseError(error);

            if (throwable instanceof UnauthorizedException) {
                return new ExpiredSessionException();
            } else if (throwable instanceof ForbiddenException) {
                return new ExpiredSessionException();
            } else {
                return throwable;
            }
        } catch (Exception ex) {
            return new ServiceException(ex);
        }
    }
}
