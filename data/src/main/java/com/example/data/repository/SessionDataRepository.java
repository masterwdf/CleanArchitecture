package com.example.data.repository;

import com.example.data.repository.datasource.session.SessionDataStoreFactory;
import com.example.domain.repository.SessionRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SessionDataRepository implements SessionRepository {

    private final SessionDataStoreFactory sessionDataStoreFactory;

    @Inject
    SessionDataRepository(SessionDataStoreFactory sessionDataStoreFactory) {
        this.sessionDataStoreFactory = sessionDataStoreFactory;
    }
}
