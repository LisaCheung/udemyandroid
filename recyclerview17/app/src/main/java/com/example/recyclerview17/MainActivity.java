package com.example.recyclerview17;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        RecyclerViewModel[] lst = new RecyclerViewModel[]{
            new RecyclerViewModel("text1", R.drawable.app1),
                new RecyclerViewModel("text2", R.drawable.app1),
                new RecyclerViewModel("text3", R.drawable.app1)
        };
        CustomAdapter customAdapter = new CustomAdapter(lst);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customAdapter);
    }
}