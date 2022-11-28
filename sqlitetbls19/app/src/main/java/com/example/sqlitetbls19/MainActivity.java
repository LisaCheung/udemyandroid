package com.example.sqlitetbls19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.sqlitetbls19.database.DatabaseHelper;
import com.example.sqlitetbls19.database.entity.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.insertDB("smith", "email@email.com");
        databaseHelper.insertDB("smith2", "email2@email.com");
        List<Contact> contacts = databaseHelper.getAll();
        for(Contact c: contacts){
            Log.i("contact_id", String.valueOf(c.getId()));
        }

    }
}