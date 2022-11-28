package com.example.roomdb21.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdb21.database.entities.Item;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TodoDAO {
    @Insert
    public long addTodo(Item item);

    @Update
    public void updateTodo(Item item);

    @Delete
    public void deleteTodo(Item item);

    @Query("select * from todos")
    public List<Item> getAll();

    @Query("select * from todos where todo_id ==:itemId")
    public Item getTodoByItem(long itemId);

    @Query("delete from todos")
    public void deleteAll();

    @Query("delete from todos where todo_id==:itemId")
    public void deleteById(long itemId);
}
