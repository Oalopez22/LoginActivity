package com.Biblioteca.loginactivity.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.Biblioteca.loginactivity.RegisterUser;
import com.Biblioteca.loginactivity.SharedPreferences.SharedPreferences;
import com.Biblioteca.loginactivity.entidades.Libro;
import com.Biblioteca.loginactivity.entidades.LibroPrestado;
import com.Biblioteca.loginactivity.entidades.Usuario;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class DbBiblioteca extends  DbHelper{
    Context context;
    DbHelper dbhelper;
    SQLiteDatabase db;
    SharedPreferences sp;
    Libro libro;
    Usuario user;
    public DbBiblioteca(@Nullable Context context) {

        super(context);
        this.context = context;
        dbhelper = new DbHelper(context);
        db=dbhelper.getWritableDatabase();
        libro = new Libro();
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
        Cursor cursor;
                cursor = db.rawQuery("SELECT * FROM usuario WHERE correo=? AND password=? ", new String[]{usuario.getEmail(),usuario.getPassword()});
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

    public ArrayList<Libro> mostrarLibros(){
        ArrayList<Libro> listaLibros = new ArrayList<>();
        Libro libros = null;
        Cursor cursorLibros = null;
        cursorLibros =db.rawQuery("SELECT * FROM " +TABLE_BOOK ,null);
        if (cursorLibros.moveToFirst()){
            do{
                libros = new Libro();
                libros.setIdlibro(cursorLibros.getInt(0));
                libros.setNombrelibro(cursorLibros.getString(1));
                libros.setAutorlibro(cursorLibros.getString(2));
                libros.setCantidadlibro(cursorLibros.getInt(3));
                libros.setUrllibro(cursorLibros.getString(4));
                libros.setImagenlibro(cursorLibros.getString(5));
                libros.setDescripcionlibro(cursorLibros.getString(6));
                listaLibros.add(libros);
            }while (cursorLibros.moveToNext());
        }
        cursorLibros.close();
        return listaLibros;
    }


    public ArrayList<LibroPrestado> mostrarLibrosUsuario(SharedPreferences sp){

        ArrayList<Libro> datoslibro = new ArrayList<>();
        Libro libroData = null;

        ArrayList<LibroPrestado> listaLibros = new ArrayList<>();
        LibroPrestado libros = null;
        Cursor cursorLibros = null;
        cursorLibros =db.rawQuery("SELECT bk.nombre_libro, bk.autor_libro, bk.imagen_libro, db.*  FROM " + TABLE_DETAIL_BOOK + " db" + " INNER JOIN "+ TABLE_BOOK + " bk " + " ON " + " bk." + COLUMNA_ID_lIBRO + " = " + " db. " +COLUMNA_ID_LIBRO_USER  + " WHERE " + COLUMNA_USER_CORREO + "= '" + sp.getCorreo() + "'" /*+ " AND " + COLUMNA_ESTADO_LIBRO + " =" + 0*/,null);
        if (cursorLibros.moveToFirst()){
            do{
                libroData = new Libro();
                libroData.setNombrelibro(cursorLibros.getString(0));
                libroData.setAutorlibro(cursorLibros.getString(1));
                libroData.setImagenlibro(cursorLibros.getString(3));
                libros = new LibroPrestado();
                libros.setCorreo_user(cursorLibros.getString(3));
                libros.setId_libro_ref(cursorLibros.getInt(4));
                libros.setFecha_prestado(cursorLibros.getString(3));
                libros.setFecha_entrega(cursorLibros.getString(5));
                datoslibro.add(libroData);
                listaLibros.add(libros);
            }while (cursorLibros.moveToNext());
        }
        cursorLibros.close();


        return listaLibros;
    }


    public Libro verLibros(int id){
        libro = null;
        Cursor cursorLibros = null;
        cursorLibros =db.rawQuery("SELECT * FROM " +TABLE_BOOK + " WHERE "+COLUMNA_ID_lIBRO+" = " + id,null);
        if (cursorLibros.moveToFirst()){
                libro = new Libro();
                libro.setIdlibro(cursorLibros.getInt(0));
                libro.setNombrelibro(cursorLibros.getString(1));
                libro.setAutorlibro(cursorLibros.getString(2));
                libro.setCantidadlibro(cursorLibros.getInt(3));
                libro.setUrllibro(cursorLibros.getString(4));
                libro.setImagenlibro(cursorLibros.getString(5));
                libro.setDescripcionlibro(cursorLibros.getString(6));
            }
        cursorLibros.close();
        return libro;
    }

    public boolean editarLibro(Libro libro){
        boolean correcto = true;
        long id = 0;
        try {
            db.execSQL("UPDATE " + TABLE_BOOK + " SET nombre_libro = '" + libro.getNombrelibro() + "', autor_libro = '" + libro.getAutorlibro() + "', cantidad_libro = '" + libro.getCantidadlibro() + "', url_libro = '" + libro.getUrllibro() + "', imagen_libro = '" + libro.getImagenlibro() + "', descripcion_libro = '" + libro.getDescripcionlibro() + "' WHERE id_libro='" + libro.getIdlibro() + "' ");
            correcto = true;
        }catch (Exception ex){
            ex.toString();
            correcto = false;
        }finally {
            db.close();
        }
        return correcto;
    }
    public  boolean prestarLibro(SharedPreferences sp , Libro libro){
        String CurrentDate;
        long id = 0;
        boolean correcto = true;
        try{
            Calendar calendar = Calendar.getInstance();
            CurrentDate = DateFormat.getDateInstance().format(calendar.getTime());

            ContentValues values = new ContentValues();
            values.put("correo_usuario",sp.getCorreo());
            values.put("id_libro_referencia", libro.getIdlibro());
            values.put("fecha_prestado", CurrentDate);
            values.put("estado_libro", 0);
            id = db.insert(TABLE_DETAIL_BOOK, null, values);
            db.execSQL(" UPDATE " + TABLE_BOOK + " SET cantidad_libro = " + libro.getCantidadlibro() + " WHERE " + COLUMNA_ID_lIBRO + " = " + libro.getIdlibro()  );
            correcto = true;
        }catch (Exception ex){
            ex.toString();
            correcto = false;
        }finally {
            db.close();
        }
        return correcto;
    }
}

