package com.example.roomdb21.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "todos")
public class Item {

    @ColumnInfo(name="todo_id")
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name="todo_name")
    private String name;
    @ColumnInfo(name="todo_descr")
    private String description;

    @Ignore
    public Item(){

    }
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
