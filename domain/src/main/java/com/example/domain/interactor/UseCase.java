package com.example.domain.interactor;

import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;

import dagger.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Clase abstracta encargada de procesar un caso de uso del negocio
 * esta clase guardara todas las ejecuciones realizadas y posteriormente
 * finalizara todas una vez estas han sido terminadas
 */

public abstract class UseCase {

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;
    private final CompositeDisposable disposables;

    /**
     * Constructor del caso de uso
     *
     * @param threadExecutor      Ejecutor de un metodo
     * @param postExecutionThread Tipo de ejecucion en un hilo diferente
     */

    UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        this.disposables = new CompositeDisposable();
    }

    /**
     * Ejecuta el actual caso de uso
     *
     * @param observable {@link Observable}
     * @param observer   {@link DisposableObserver} which will be listening to the observable build
     *                   by observable method.
     */

    <T> void execute(Observable<T> observable, DisposableObserver<T> observer) {
        Preconditions.checkNotNull(observer);

        final Disposable disposable = observable
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribeWith(observer);

        addDisposable(disposable);
    }

    /**
     * Finaliza el actual {@link CompositeDisposable}.
     */

    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    /**
     * Agrega el {@link CompositeDisposable}.
     */

    private void addDisposable(Disposable disposable) {
        Preconditions.checkNotNull(disposable);
        Preconditions.checkNotNull(disposables);
        disposables.add(disposable);
    }

}
