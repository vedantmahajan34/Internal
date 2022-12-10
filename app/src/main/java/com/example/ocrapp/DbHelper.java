package com.example.ocrapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Date;

public class DbHelper extends SQLiteOpenHelper  {
    public DbHelper(Context context) {
        super(context, "Storage.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("Create table Textdata(Phrase TEXT,Time DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL);");
        Log.d("Table", "onCreate: created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("Drop table  if exists TextData");
    }
    public Boolean insertData(String Phrase){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put("Phrase",Phrase);
//        value.put("time",time);
        long result=db.insert("TextData",null,value);
        if(result==-1){
            return false;

        }
        else{
            return true;
        }
    }
}
