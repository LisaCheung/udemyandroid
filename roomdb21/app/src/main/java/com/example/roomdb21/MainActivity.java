package com.example.roomdb21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.roomdb21.database.TodoDAO;
import com.example.roomdb21.database.TodosDatabase;
import com.example.roomdb21.database.entities.Item;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TodosDatabase todosDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        todosDatabase = Room.databaseBuilder(getApplicationContext(),
                TodosDatabase.class, "todosDb").allowMainThreadQueries().build();
        TodoDAO todoDAO = todosDatabase.todoDAO();
        todoDAO.addTodo(new Item("jane", "cleaning"));
        todoDAO.addTodo(new Item("smith", "shopping"));
        todoDAO.addTodo(new Item("jane2", "cleaning2"));
        todoDAO.addTodo(new Item("smith2", "shopping2"));
        List<Item> all = todoDAO.getAll();
        for(Item i: all){
            Log.i("todo_descr", i.getDescription());
        }
        todoDAO.deleteAll();

    }
}