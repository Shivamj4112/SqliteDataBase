package com.android.fragmentanddatabase.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.fragmentanddatabase.ModelClass.ModelClass;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

     Context context;
     static final String Database_Name = "DataBase.db";
     static int DatabaseVersion = 1;

     public Database(@Nullable Context context) {
        super(context, Database_Name, null, DatabaseVersion);

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String que = "CREATE TABLE User(id INTEGER PRIMARY KEY AUTOINCREMENT ,Name TEXT ,Age TEXT , Mobile TEXT , Email TEXT)";
        sqLiteDatabase.execSQL(que);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void InsertData (String name, String age, String mobile, String email){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("name",name);
        values.put("age",age);
        values.put("mobile",mobile);
        values.put("email",email);

        long data = db.insert("User",null,values);

        if (data == -1){
            Toast.makeText(context, "Data Not Inserted", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Data Inserted", Toast.LENGTH_SHORT).show();
        }
    }

    public List<ModelClass> Retrieve (){

        List<ModelClass> datalist = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        String que = "SELECT * FROM User";

        Cursor cursor = db.rawQuery(que,null);
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {

            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String age = cursor.getString(2);
            String mobile = cursor.getString(3);
            String email = cursor.getString(4);

            ModelClass model = new ModelClass(id,name,age,mobile,email);
            datalist.add(model);
            cursor.moveToNext();
        }

        return datalist;
    }

    public void Update(int id , String name , String age , String mobile , String email){

        SQLiteDatabase db  = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("age",age);
        values.put("mobile",mobile);
        values.put("email",email);

        long data = db.update("student",values,"id="+id,null);

        if (data == -1){
            Toast.makeText(context, "Data Not Updated", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Data Updated", Toast.LENGTH_SHORT).show();
        }
    }

    public void Delete(int id){

        SQLiteDatabase db = getWritableDatabase();

        long data = db.delete("student","id="+id,null);

        if (data == -1){
            Toast.makeText(context, "Data Not Deleted", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Data Deleted", Toast.LENGTH_SHORT).show();
        }
    }

}
