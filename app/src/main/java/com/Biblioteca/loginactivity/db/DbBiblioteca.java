package com.Biblioteca.loginactivity.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.Biblioteca.loginactivity.entidades.Usuario;

public class DbBiblioteca extends  DbHelper{
    Context context;
    public DbBiblioteca(@Nullable Context context) {
        super(context);
    }

    public long crearUsuario(Usuario usuario){
        long id = 0;
        try {
            DbHelper dbhelper = new DbHelper(context);
            SQLiteDatabase db = dbhelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nombre", usuario.getNombre());
            values.put("email", usuario.getEmail());
            values.put("telefono", usuario.getTelefono());
            values.put("direccion", usuario.getDirecion());
            values.put("password", usuario.getPassword());
            id = db.insert(TABLE_USER, null, values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}

