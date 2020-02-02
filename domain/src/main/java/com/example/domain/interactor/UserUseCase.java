package com.example.domain.interactor;

import com.example.domain.entity.User;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class UserUseCase extends UseCase {

    private final UserRepository userRepository;

    /**
     * Constructor del caso de uso
     *
     * @param threadExecutor      Ejecutor de un metodo
     * @param postExecutionThread Tipo de ejecucion en un hilo diferente
     */

    @Inject
    public UserUseCase(UserRepository userRepository,
                       ThreadExecutor threadExecutor,
                       PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    /**
     * Obtiene los datos del usuario
     */

    public void getUser(DisposableObserver<User> observer) {
        execute(this.userRepository.getUser(), observer);
    }
}
