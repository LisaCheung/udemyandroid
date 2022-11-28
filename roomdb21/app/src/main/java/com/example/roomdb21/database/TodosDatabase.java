package com.example.roomdb21.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roomdb21.database.entities.Item;

@Database(entities = {Item.class}, version = 1)
public abstract class TodosDatabase extends RoomDatabase {
    //link dao with database
    public abstract TodoDAO todoDAO();
}
