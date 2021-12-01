package com.example.solemne2.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {


    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //configurar el modelo de trabajo
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE clases (codigo int primary key, clase text, intensidad text)");

    }

    //me permite realizar cambios esquematicos en el modelo
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
