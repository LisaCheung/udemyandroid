package com.example.sqlitetbls19.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sqlitetbls19.database.entity.Contact;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "contacts_db";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Contact.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contact.TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    //Insert into db
    public long insertDB(String name, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues(); ;
        contentValues.put(Contact.COLUMN_EMAIL, email);
        contentValues.put(Contact.COLUMN_NAME, name);
        long id = db.insert(Contact.TABLE_NAME, null, contentValues);
        db.close();
        return id;
    }

    //get from db by id
    public Contact getContact(long id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Contact.TABLE_NAME, new String[]{Contact.COLUMN_ID, Contact.COLUMN_NAME, Contact.COLUMN_EMAIL}, Contact.COLUMN_ID + "=?", new String[]{String.valueOf(id)},
                null, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
            Contact contact = new Contact(cursor.getInt(cursor.getColumnIndexOrThrow(Contact.COLUMN_ID)), cursor.getString(cursor.getColumnIndexOrThrow(Contact.COLUMN_NAME)), cursor.getString(cursor.getColumnIndexOrThrow(Contact.COLUMN_EMAIL)));
            cursor.close();
            return contact;
        }
        return null;
    }

    public ArrayList<Contact> getAll(){
        ArrayList<Contact> res = new ArrayList<>();
        String sql = "SELECT * FROM " + Contact.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                Contact contact = new Contact();
                contact.setId(cursor.getInt(cursor.getColumnIndexOrThrow(Contact.COLUMN_ID)));
                contact.setEmail(cursor.getString(cursor.getColumnIndexOrThrow(Contact.COLUMN_EMAIL)));
                contact.setName(cursor.getString(cursor.getColumnIndexOrThrow(Contact.COLUMN_NAME)));
                res.add(contact);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return res;
    }

    public int updateContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Contact.COLUMN_NAME, contact.getName());
        contentValues.put(Contact.COLUMN_EMAIL, contact.getEmail());
        return db.update(Contact.TABLE_NAME, contentValues, Contact.COLUMN_ID + "=?", new String[]{String.valueOf(contact.getId())});
    }
    public void deleteContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Contact.TABLE_NAME,Contact.COLUMN_ID+"=?", new String[]{String.valueOf(contact.getId())});
        db.close();
    }
}
