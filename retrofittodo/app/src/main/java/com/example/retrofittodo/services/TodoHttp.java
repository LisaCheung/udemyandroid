package com.example.retrofittodo.services;

import com.example.retrofittodo.models.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TodoHttp {
    @GET("todos")
    Call<List<Item>> getTodos();

}
