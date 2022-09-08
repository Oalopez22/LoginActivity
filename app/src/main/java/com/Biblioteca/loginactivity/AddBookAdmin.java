package com.Biblioteca.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.Biblioteca.loginactivity.SharedPreferences.SharedPreferences;
import com.Biblioteca.loginactivity.db.DbBiblioteca;
import com.Biblioteca.loginactivity.db.DbHelper;
import com.Biblioteca.loginactivity.entidades.Libro;
import com.Biblioteca.loginactivity.entidades.Usuario;

public class AddBookAdmin extends AppCompatActivity {
    EditText txtAddName,txtAddAuthor,txtAddCantidad,txtAddUrl,txtAddImg,txtAddDescripcion;
    Button btnAddBook;
    Usuario user;
    Libro libros;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_admin);
        DbHelper dbHelper = new DbHelper(AddBookAdmin.this);
        DbBiblioteca dbBiblioteca = new DbBiblioteca(AddBookAdmin.this);
        user = new Usuario();
        libros = new Libro();
        sp = new SharedPreferences(AddBookAdmin.this);
        txtAddName = findViewById(R.id.txtAddName);
        txtAddAuthor = findViewById(R.id.txtAddAuthor);
        txtAddCantidad = findViewById(R.id.txtAddCantidad);
        txtAddUrl = findViewById(R.id.txtAddUrl);
        txtAddImg = findViewById(R.id.txtAddImg);
        txtAddDescripcion = findViewById(R.id.txtAddDescripcion);
        btnAddBook = findViewById(R.id.btnAddBook);
        btnAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validarNombreLibro() && validarAutorLibro() && validarCantidadLibro() && validarUrlLibro() && validarImgLibro() && validarDescLibro() ){
                    DbBiblioteca dbbiblioteca = new DbBiblioteca(AddBookAdmin.this);
                    long id = dbbiblioteca.agregarLibro(libros);
                    if(id > 0 ){
                        Toast.makeText(AddBookAdmin.this, "Libro agregado", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(AddBookAdmin.this, "Error al agregar el libro", Toast.LENGTH_LONG).show();
                    }
            }
            }
        });
    }

    private boolean validarNombreLibro(){
        String nombre = txtAddName.getText().toString();
        nombre.toUpperCase().charAt(0);
        if(!nombre.isEmpty()){
            libros.setNombrelibro(nombre);
            return true;
        }else{
            txtAddName.setError("Campo obligatorio");
            return  false;
        }
    }

    private boolean validarAutorLibro(){
        String autor = txtAddAuthor.getText().toString().toLowerCase();
        if(!autor.isEmpty()){
            libros.setAutorlibro(autor);
            return true;
        }else{
            txtAddName.setError("Campo obligatorio");
            return  false;
        }
    }

    private boolean validarCantidadLibro(){

        String cantidad = txtAddCantidad.getText().toString();
        int cantidadLibro = Integer.parseInt(cantidad);
        if(cantidadLibro >0){
            libros.setCantidadlibro(cantidadLibro);
            return true;
        }else{
            txtAddName.setError("Campo obligatorio");
            return  false;
        }
    }
    private boolean validarUrlLibro(){

        String url = txtAddUrl.getText().toString();
        if(!url.isEmpty()){
            libros.setUrllibro(url);
            return true;
        }else{
            txtAddUrl.setError("Campo obligatorio");
            return  false;
        }
    }
    private boolean validarImgLibro(){
        String img = txtAddImg.getText().toString();
        if(!img.isEmpty()){
            libros.setImagenlibro(img);
            return true;
        }else{
            txtAddImg.setError("Campo obligatorio");
            return  false;
        }
    }
    private boolean validarDescLibro(){

        String descripcion = txtAddDescripcion.getText().toString().toLowerCase();
        if(!descripcion.isEmpty()){
            libros.setDescripcionlibro(descripcion);
            return true;
        }else{
            txtAddName.setError("Campo obligatorio");
            return  false;
        }
    }

    private void cargarimagen(){

    }

}