package com.Biblioteca.loginactivity.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static  final int DATABASE_VERSION = 2;
    private static  final String DATABASE_NAME = "biblioteca.db";
    public static  final String TABLE_USER = "usuario";
    public static final String COLUMNA_ID = "_id";
    public static final String COLUMNA_NOMBRE = "nombre";
    public static final String COLUMNA_CORREO = "correo";
    public static final String COLUMNA_TELEFONO = "telefono";
    public static final String COLUMNA_DIRECCION = "direccion";
    public static final String COLUMNA_PASSWORD = "password";
    public static final String COLUMNA_TIP_USER = "tip_user";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "
                + TABLE_USER + "(" + COLUMNA_ID
                + " integer primary key autoincrement, " + COLUMNA_NOMBRE
                + " text not null, " + COLUMNA_CORREO
                + " text not null, " + COLUMNA_TELEFONO
                + " text not null, " + COLUMNA_DIRECCION
                + " text not null, " + COLUMNA_PASSWORD
                + " text not null, " + COLUMNA_TIP_USER
                + " integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE " + TABLE_USER);
        onCreate(db);
    }
}
