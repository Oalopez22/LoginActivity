package com.Biblioteca.loginactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.Biblioteca.loginactivity.SharedPreferences.SharedPreferences;
import com.Biblioteca.loginactivity.adaptadores.ListaUsuarioLibroAdapter;
import com.Biblioteca.loginactivity.db.DbBiblioteca;
import com.Biblioteca.loginactivity.entidades.LibroPrestado;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {
    TextView viewNombreLibro,viewAutorLibro;
    ImageView imgPlus;
    RecyclerView listalibros;
    Button btnPrestar;
    LibroPrestado libroPrestado;
    ArrayList<LibroPrestado> listaArrrayLibro;
    SharedPreferences sp;
    DbBiblioteca dbBiblioteca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        dbBiblioteca = new DbBiblioteca(UserActivity.this);
        libroPrestado = new LibroPrestado();
        sp = new SharedPreferences(UserActivity.this);
        viewNombreLibro = findViewById(R.id.ViewLibroName);
        viewAutorLibro = findViewById(R.id.ViewLibroAuthor);

        listalibros = findViewById(R.id.RviewUserBooks);
        listalibros.setLayoutManager( new LinearLayoutManager(this));
        listaArrrayLibro = new ArrayList<>();



        ListaUsuarioLibroAdapter adapter = new ListaUsuarioLibroAdapter(dbBiblioteca.mostrarLibrosUsuario(sp));
        listalibros.setAdapter(adapter);
        btnPrestar = findViewById(R.id.btnPrestar);
        btnPrestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prestar();
            }
        });
    }

    private void prestar(){
        Intent intent = new Intent(this, UserAvailableBooks.class);
        startActivity(intent);
    }
}