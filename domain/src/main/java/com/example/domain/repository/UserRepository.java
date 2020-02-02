package com.example.domain.repository;

import com.example.domain.entity.User;

import io.reactivex.Observable;

public interface UserRepository {

    Observable<User> getUser();
}