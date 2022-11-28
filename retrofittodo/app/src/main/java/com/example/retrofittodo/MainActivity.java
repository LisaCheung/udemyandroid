package com.example.retrofittodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofittodo.models.Item;
import com.example.retrofittodo.services.RetrofitInstance;
import com.example.retrofittodo.services.TodoHttp;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Item> items = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetTodos();
    }

    private Object GetTodos() {
        TodoHttp todoHttp = RetrofitInstance.getService();
        Call<List<Item>> call = todoHttp.getTodos();
       call.enqueue(new Callback<List<Item>>() {
           @Override
           public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if(response != null){
                    items = response.body();
                    for(Item i: items){
                        Log.i("Todo Title", i.getTitle());
                    }
                }

           }
           @Override
           public void onFailure(Call<List<Item>> call, Throwable t) {

           }
       });
       return items;
    }
}