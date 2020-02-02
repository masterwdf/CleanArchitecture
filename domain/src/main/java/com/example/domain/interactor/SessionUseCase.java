package com.example.domain.interactor;

import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.repository.SessionRepository;

import javax.inject.Inject;

public class SessionUseCase extends UseCase {

    private final SessionRepository repository;

    /**
     * Constructor del caso de uso
     *
     * @param threadExecutor      Ejecutor de un metodo
     * @param postExecutionThread Tipo de ejecucion en un hilo diferente
     */
    @Inject
    public SessionUseCase(SessionRepository sessionRepository,
                          ThreadExecutor threadExecutor,
                          PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = sessionRepository;
    }
}
