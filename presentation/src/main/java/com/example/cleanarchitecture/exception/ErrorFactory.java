package com.example.cleanarchitecture.exception;

import com.example.cleanarchitecture.common.error.ErrorModel;
import com.example.cleanarchitecture.common.type.ErrorCode;
import com.example.data.exception.NetworkConnectionException;
import com.example.data.exception.ServiceException;

import java.net.SocketTimeoutException;

public class ErrorFactory {

    private ErrorFactory() {
    }

    public static ErrorModel create(Throwable exception) {
        if (exception instanceof NetworkConnectionException) {
            return new ErrorModel(ErrorCode.NETWORK, "No hay conexión a internet.");
        } else if (exception instanceof ServiceException) {
            if (exception.getCause() instanceof SocketTimeoutException) {
                return new ErrorModel(ErrorCode.GATEWAY_TIMEOUT, "Se supero el tiempo limite de consulta");
            } else {
                return new ErrorModel(ErrorCode.SERVICE, "Ocurrió un error al ejecutar la operación.");                //return new ErrorModel(ErrorCode.SERVICE, exception.getMessage(), ((ServiceException) exception).getResponse());
            }
        } else {
            return new ErrorModel(ErrorCode.DEFAULT, "Ocurrió un error al ejecutar la operación.");
        }
    }

    private static String getMessage(int code) {
        switch (code) {
            case 400:
                return "Ocurrió un error al ejecutar la operación.";
            case 401:
                return "Su sesión ha expirado.";
            case 403:
                return "No tiene permisos necesarios.";
            case 404:
                return "No se ha encontrado el servicio.";
            case 424:
                return "Es necesario actualizar la aplicación.";
            case 500:
                return "Ocurrió un error al ejecutar la operación.";
            case 501:
                return "Ocurrió un error al ejecutar la operación.";
            case 502:
                return "Ocurrió un error al ejecutar la operación.";
            case 503:
                return "Los servicios no estan disponibles.";
            case 504:
                return "Se supero el tiempo limite de consulta";
            default:
                return "Ocurrió un error al ejecutar la operación.";
        }
    }
}