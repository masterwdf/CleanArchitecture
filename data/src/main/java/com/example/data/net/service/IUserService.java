package com.example.data.net.service;

import com.example.data.entity.UserEntity;
import com.example.data.util.Constant;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface IUserService {

    @Headers({Constant.APP_VERSION, Constant.APP_SOURCE})
    @GET(value = "getuser")
    Observable<UserEntity> getUser();

}