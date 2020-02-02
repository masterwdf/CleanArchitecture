package com.example.domain.executor;

import io.reactivex.Scheduler;

/**
 * Interface que implementa la ejecucion de un proceso en un hilo diferente al principal
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
