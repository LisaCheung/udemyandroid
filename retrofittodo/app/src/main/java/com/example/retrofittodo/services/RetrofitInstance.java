package com.example.retrofittodo.services;

import com.example.retrofittodo.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static Retrofit retrofit = null;
    public static String URL = "https://jsonplaceholder.typicode.com/";
    public static TodoHttp getService(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(TodoHttp.class);
    }
}
