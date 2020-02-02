package com.example.data.repository;

import com.example.data.mapper.UserEntityDataMapper;
import com.example.data.repository.datasource.user.UserDataStore;
import com.example.data.repository.datasource.user.UserDataStoreFactory;
import com.example.domain.entity.User;
import com.example.domain.repository.UserRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class UserDataRepository implements UserRepository {

    private final UserDataStoreFactory userDataStoreFactory;
    private final UserEntityDataMapper userEntityDataMapper;

    @Inject
    UserDataRepository(UserDataStoreFactory userDataStoreFactory, UserEntityDataMapper userEntityDataMapper) {
        this.userDataStoreFactory = userDataStoreFactory;
        this.userEntityDataMapper = userEntityDataMapper;
    }

    @Override
    public Observable<User> getUser() {
        final UserDataStore dataStoreCloud = this.userDataStoreFactory.createCloud();
        return dataStoreCloud.getUser().map(userEntityDataMapper::transform);
    }
}
