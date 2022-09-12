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
                /* tabla tipo de usuario*/
     public static  final String TABLE_TIP_USER = "tipo_user";
     public static final String COLUMNA_ID_TIPO_USER = "id";
     public static final String COLUMNA_TIPO_USER = "tipo_usuario";

                /* Tabla Libros */
    public static final String TABLE_BOOK = "libro";
    public static final String COLUMNA_ID_lIBRO = "id_libro";
    public static final String COLUMNA_NOMBRE_LIBRO = "nombre_libro";
    public static final String COLUMNA_AUTOR_LIBRO = "autor_libro";
    public static final String COLUMNA_CANTIDAD_LIBRO = "cantidad_libro";
    public static final String COLUMNA_URL_LIBRO = "url_libro";
    public static final String COLUMNA_IMAGEN_LIBRO = "imagen_libro";
    public static final String COLUMNA_DESCRIPCION_LIBRO = "descripcion_libro";




    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
                    /*tabla usuario */
        db.execSQL("create table "
                + TABLE_USER + "(" + COLUMNA_ID
                + " integer primary key autoincrement, " + COLUMNA_NOMBRE
                + " text not null, " + COLUMNA_CORREO
                + " text not null, " + COLUMNA_TELEFONO
                + " text not null, " + COLUMNA_DIRECCION
                + " text not null, " + COLUMNA_PASSWORD
                + " text not null, " + COLUMNA_TIP_USER
                + " integer)");
        db.execSQL("INSERT INTO usuario (nombre,correo,telefono,direccion,password,tip_user) VALUES ('Omar','omar-alexis40@hotmail.com','6401119','Diag 17 b','Oalopez123',0),('Andres','Alopez@hotmail.com','320201','Diag 17 b','Alopez123',1)");
                    /* Tabla tipo de usuario*/
        db.execSQL("create table "
                + TABLE_TIP_USER + "(" + COLUMNA_ID_TIPO_USER
                + " integer primary key autoincrement, " + COLUMNA_TIPO_USER
                + " text not null" +")");
        db.execSQL("INSERT INTO tipo_user (id,tipo_usuario) VALUES (0,'admin'),(1,'usuario')");

                    /*Tabla libro */
        db.execSQL("create table "
                + TABLE_BOOK + "(" + COLUMNA_ID_lIBRO
                + " integer primary key autoincrement, " + COLUMNA_NOMBRE_LIBRO
                + " text not null, " + COLUMNA_AUTOR_LIBRO
                + " integer not null, " + COLUMNA_CANTIDAD_LIBRO
                + " text not null, " + COLUMNA_URL_LIBRO
                + " text not null, " + COLUMNA_IMAGEN_LIBRO
                + " text not null, " + COLUMNA_DESCRIPCION_LIBRO
                + " text not null)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE " + TABLE_USER);
        db.execSQL(" DROP TABLE " + TABLE_TIP_USER);
        db.execSQL(" DROP TABLE " + TABLE_BOOK);
        onCreate(db);
    }
}
