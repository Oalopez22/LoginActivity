package com.Biblioteca.loginactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.Biblioteca.loginactivity.adaptadores.DescLibroAdapter;
import com.Biblioteca.loginactivity.adaptadores.ListaLibrosAdapter;
import com.Biblioteca.loginactivity.db.DbBiblioteca;
import com.Biblioteca.loginactivity.entidades.Libro;

import java.util.ArrayList;

public class UserAvailableBooks extends AppCompatActivity {
    ImageView imgPlus, imgArrowBack;
    RecyclerView listalibros;
    DbBiblioteca dbBiblioteca;
    ArrayList<Libro> listaArrayLibros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_available_books);
        dbBiblioteca = new DbBiblioteca(UserAvailableBooks.this);

        listalibros = findViewById(R.id.RviewUserAvailableBooks);
        listaArrayLibros = new ArrayList<>();

        DescLibroAdapter adapter = new DescLibroAdapter(dbBiblioteca.mostrarLibros());
        listalibros.setAdapter(adapter);
        listalibros.setLayoutManager(new GridLayoutManager(UserAvailableBooks.this,2));

        imgArrowBack = findViewById(R.id.imgArrowBackBook);
        imgArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}