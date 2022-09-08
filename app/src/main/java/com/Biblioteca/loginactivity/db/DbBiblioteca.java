package com.Biblioteca.loginactivity.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.Biblioteca.loginactivity.RegisterUser;
import com.Biblioteca.loginactivity.entidades.Libro;
import com.Biblioteca.loginactivity.entidades.Usuario;

public class DbBiblioteca extends  DbHelper{
    Context context;
    DbHelper dbhelper;
    SQLiteDatabase db;
    Usuario user;
    public DbBiblioteca(@Nullable Context context) {

        super(context);
        this.context = context;
        dbhelper = new DbHelper(context);
        db=dbhelper.getWritableDatabase();
    }


    public long crearUsuario(Usuario usuario){

        long id = 0;
        try {
            Cursor cursor = db.rawQuery("SELECT * FROM usuario WHERE correo=? ", new String[]{usuario.getEmail()});
            if (cursor.getCount()>0){
                Toast.makeText(context, "Ya se encuentra un correo registrado", Toast.LENGTH_SHORT).show();
            }else{
                ContentValues values = new ContentValues();
                values.put("nombre", usuario.getNombre());
                values.put("correo", usuario.getEmail());
                values.put("telefono", usuario.getTelefono());
                values.put("direccion", usuario.getDirecion());
                values.put("password", usuario.getPassword());
                values.put("tip_user", usuario.getTip_user());
                id = db.insert(TABLE_USER, null, values);
            }

        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public boolean  revisarDatos(Usuario usuario){
        /*        Toast.makeText(context, "Correo :"+spreference.getCorreo()+" contraseña : "+spreference, Toast.LENGTH_SHORT).show();*/
        Cursor cursor = db.rawQuery("SELECT * FROM usuario WHERE correo=? AND password=? ", new String[]{usuario.getEmail(),usuario.getPassword()});
        if(cursor.getCount()>0){
            ContentValues values = new ContentValues();
            return  true;
        }else{
            return  false;
        }
    }
    public long agregarLibro(Libro libros){

        long id = 0;
        try {
            Cursor cursor = db.rawQuery("SELECT * FROM libro WHERE nombre_libro=? ", new String[]{libros.getNombrelibro()});
            if (cursor.getCount()>0){
                Toast.makeText(context, "Ya se encuentra un correo registrado", Toast.LENGTH_SHORT).show();
            }else{
                ContentValues values = new ContentValues();
                values.put("nombre_libro", libros.getNombrelibro());
                values.put("autor_libro", libros.getAutorlibro());
                values.put("cantidad_libro", libros.getCantidadlibro());
                values.put("url_libro", libros.getUrllibro());
                values.put("imagen_libro", libros.getUrllibro());
                values.put("descripcion_libro", libros.getDescripcionlibro());
                id = db.insert(TABLE_BOOK, null, values);
            }

        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }

}

