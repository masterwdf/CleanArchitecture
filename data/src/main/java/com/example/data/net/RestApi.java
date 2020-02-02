package com.example.data.net;

import com.example.data.exception.ServiceException;

/**
 * Clase encargada de realizar las llamadas a un servicio
 * aquí se configura las propiedades de la petición request
 * los interceptores y los convertidores que procesaran la respuesta
 * una vez el servicio haya devuelto un mensaje al cliente
 */

public class RestApi {

    private static final String TAG = "RestApi";

    private static final long CONNECT_TIMEOUT = 30;
    private static final long READ_TIMEOUT = 30;
    private static final long WRITE_TIMEOUT = 30;

    public static <S> S create(Class<S> clazz, String token) {
        return null;
        //return inkaApi.create(clazz, "http://www.google.com.pe", token);
    }

    public static ServiceException parseError(Throwable error) {
        try {
            //return Api.parseError(error);
            return null;
        } catch (Exception ex) {
            return new ServiceException(ex);
        }
    }

}