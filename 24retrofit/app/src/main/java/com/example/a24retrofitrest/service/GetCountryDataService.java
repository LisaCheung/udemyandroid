package com.example.a24retrofitrest.service;

import com.example.a24retrofitrest.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountryDataService {
    //Retrofit interface

    @GET("countries")
    Call<Result> getResult();
}
