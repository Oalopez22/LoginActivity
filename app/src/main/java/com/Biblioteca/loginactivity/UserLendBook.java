package com.Biblioteca.loginactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.Biblioteca.loginactivity.adaptadores.DescLibroAdapter;
import com.Biblioteca.loginactivity.adaptadores.LendBookAdapter;
import com.Biblioteca.loginactivity.db.DbBiblioteca;
import com.Biblioteca.loginactivity.entidades.Libro;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class UserLendBook extends AppCompatActivity {
    /*TextView txtNameBook, txtAuthorBook, txtDescBook;*/
    TextView txtNameBook, txtAuthorBook, txtDescBook;
    ImageView imgViewBook;
    DbBiblioteca dbBiblioteca;
    Button btnPrestarLibro;
    Libro libro;
    int id = 0;
    int contador;
    Boolean correcto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_lend_book);
        dbBiblioteca = new DbBiblioteca(UserLendBook.this);

        libro = new Libro();
        contador = 0;
        txtNameBook = findViewById(R.id.txtverBooknombre);

        txtAuthorBook = findViewById(R.id.txtverBookAutor2);
        txtDescBook = findViewById(R.id.txtverBookDescripcion);
        imgViewBook = findViewById(R.id.imgViewBook2);

/*        LendBookAdapter adapter = new LendBookAdapter(dbBiblioteca.mostrarLibros());
        datoslibro.setAdapter(adapter);*/
        correcto = false;
        if (savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if (extras == null){
                id = Integer.parseInt(null);
            }else{
                id = extras.getInt("ID");
            }
        }else{
            id = (int) savedInstanceState.getSerializable("ID");
        }
        libro = dbBiblioteca.verLibros(id);
        Toast.makeText(this, "Nombre Libro :"+libro.getNombrelibro() + " Autor libro : "+ libro.getAutorlibro(), Toast.LENGTH_SHORT).show();

        Glide.with(imgViewBook).load(libro.getImagenlibro()).into(imgViewBook);
        txtNameBook.setText(libro.getNombrelibro());
        txtAuthorBook.setText(libro.getAutorlibro());
        txtDescBook.setText(libro.getDescripcionlibro());


        btnPrestarLibro = findViewById(R.id.btnPrestarlibro);
        btnPrestarLibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            contador = libro.getCantidadlibro();
            contador = contador-1;
            libro.setCantidadlibro(contador);
            dbBiblioteca.prestarLibro(libro);

            inicio();
            }
        });
    }
    private void inicio(){
        Intent intent = new Intent(this,UserActivity.class);
        startActivity(intent);
    }
}