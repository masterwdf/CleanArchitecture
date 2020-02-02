package com.example.domain.interactor;

import io.reactivex.observers.DisposableObserver;

/**
 * Clase base disposable que se implementara la ejecucion de cualquier proceso
 * que necesita obtener los datos desde un repositorio externo o interno
 */

public class BaseObserver<T> extends DisposableObserver<T> {

    /**
     * Metodo que se ejecuta cuando la ejecucion fue exitosa
     *
     * @param t Generico que recibe un primitivo, objeto o una lista
     */

    @Override
    public void onNext(T t) {
        // no-op by default.
    }

    /**
     * Metodo que se ejecuta cuando ha finalizado una ejecucion sea exitosa o erronea
     */

    @Override
    public void onComplete() {
        // no-op by default.
    }

    /**
     * Metodo que se ejecuta cuando la ejecucion devolvio error
     *
     * @param exception Excepcion que devolvera a la vista para que procesa la respuesta
     *                  de acuerdo al tipo de error recibido
     */

    @Override
    public void onError(Throwable exception) {
        // no-op by default.
    }
}
