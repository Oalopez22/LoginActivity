package com.Biblioteca.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Biblioteca.loginactivity.db.DbBiblioteca;
import com.Biblioteca.loginactivity.entidades.Libro;

public class Update_Book_Admin extends AppCompatActivity {

    EditText txtEditBookName,txtEditBookAuthor,txtEditCantidadBook,txtEditUrlBook,txtEditImgBook,txtDescBok;
    Button btnUpdateBook;
    DbBiblioteca dbBiblioteca;
    Libro libro;
    int id = 0;
    Boolean correcto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_book_admin);
            dbBiblioteca = new DbBiblioteca( Update_Book_Admin.this);
            libro = new Libro();

        txtEditBookName = findViewById(R.id.txtEditName);
        txtEditBookAuthor = findViewById(R.id.txtEditAuthor);
        txtEditCantidadBook = findViewById(R.id.txtEditCantidad);
        txtEditUrlBook = findViewById(R.id.txtEditUrl);
        txtEditImgBook = findViewById(R.id.txtEditImg);
        txtDescBok = findViewById(R.id.txtEditDesc);
        correcto = false;
        btnUpdateBook = findViewById(R.id.btnUpdateBook);

        if (savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if (extras == null){
                id = Integer.parseInt(null);
            }else{
                id = extras.getInt("id_libro");
            }
        }else{
            id = (int) savedInstanceState.getSerializable("id_libro");
        }

        libro = dbBiblioteca.verLibros(id);

        if (libro != null){
            txtEditBookName.setText(libro.getNombrelibro());
            txtEditBookAuthor.setText(libro.getAutorlibro());
            txtEditCantidadBook.setText(libro.getCantidadlibro());
            txtEditUrlBook.setText(libro.getUrllibro());
            txtEditImgBook.setText(libro.getImagenlibro());
            txtDescBok.setText(libro.getDescripcionlibro());
        }


        btnUpdateBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( validarNombreLibro()  && validarAutorLibro() && validarCantidadLibro() && validarurlLibro() && validarImgLibro() && validarDescLibro()){
                    correcto = true;
                    if (correcto){
                        correcto = dbBiblioteca.editarLibro(libro);
                        Toast.makeText(Update_Book_Admin.this, "Registro actualizado", Toast.LENGTH_LONG).show();
                        vista();
                    }else{
                        Toast.makeText(Update_Book_Admin.this, "Error al actualizar", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }


    private boolean validarNombreLibro(){
        txtEditBookName.setError(null);
        String nombre = txtEditBookName.getText().toString();
        if(!"".equals(nombre)){
            libro.setNombrelibro(nombre);
            return true;
        }else {
            txtEditBookName.setError("El campo Nombre no debe quedar vacio");
            txtEditBookName.requestFocus();
            return false;
        }
    }

    private boolean validarAutorLibro(){
        txtEditBookAuthor.setError(null);
        String autor = txtEditBookAuthor.getText().toString();
        if(!"".equals(autor)){
            libro.setAutorlibro(autor);
            return true;
        }else {
            txtEditBookAuthor.setError("El campo Autor no debe quedar vacio");
            txtEditBookAuthor.requestFocus();
            return false;
        }
    }
    private boolean validarCantidadLibro(){
        txtEditCantidadBook.setError(null);
        int cantidad = Integer.parseInt(txtEditCantidadBook.getText().toString());
        if(!"".equals(cantidad)){
            libro.setCantidadlibro(cantidad);
            return true;
        }else {
            txtEditCantidadBook.setError("El campo cantidad no debe quedar vacio");
            txtEditCantidadBook.requestFocus();
            return false;
        }
    }
    private boolean validarurlLibro(){
        txtEditUrlBook.setError(null);
        String url = txtEditUrlBook.getText().toString();
        if(!"".equals(url)){
            libro.setUrllibro(url);
            return true;
        }else {
            txtEditUrlBook.setError("El campo url no debe quedar vacio");
            txtEditUrlBook.requestFocus();
            return false;
        }
    }
    private boolean validarImgLibro(){
        txtEditImgBook.setError(null);
        String img = txtEditImgBook.getText().toString();
        if(!"".equals(img)){
            libro.setImagenlibro(img);
            return true;
        }else {
            txtEditImgBook.setError("El campo imagen no debe quedar vacio");
            txtEditImgBook.requestFocus();
            return false;
        }
    }
    private boolean validarDescLibro(){
        txtDescBok.setError(null);
        String desc = txtDescBok.getText().toString();
        if(!"".equals(desc)){
            libro.setDescripcionlibro(desc);
            return true;
        }else {
            txtDescBok.setError("El campo descripcion no debe quedar vacio");
            txtDescBok.requestFocus();
            return false;
        }
    }

    private  void vista(){
        Intent intent = new Intent(this,AdminActivity.class);
        startActivity(intent);
    }
}