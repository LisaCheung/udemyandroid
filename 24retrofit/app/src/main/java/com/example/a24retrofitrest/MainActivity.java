package com.example.a24retrofitrest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.a24retrofitrest.model.CountryModel;
import com.example.a24retrofitrest.model.Result;
import com.example.a24retrofitrest.service.GetCountryDataService;
import com.example.a24retrofitrest.service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//country api - https://api.printful.com/countries
//https://www.jsonschema2pojo.org/
/*
-model classes
-interface
-retrofit instance
 */
public class MainActivity extends AppCompatActivity {
    ArrayList<CountryModel> countries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetCountries(); 
    }

    public Object GetCountries() {
        GetCountryDataService getCountryDataService = RetrofitInstance.getService();
        Call<Result> call = getCountryDataService.getResult();
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                if(result != null && result.getResult() != null){
                    countries = (ArrayList<CountryModel>) result.getResult();
                    for(CountryModel c: countries){
                        Log.i("TAG", c.getName());
                    }
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
        return countries;
    }
}