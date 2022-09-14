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
    ImageView imgPlus;
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


/*        imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(UserAvailableBooks.this,imgPlus);
                popupMenu.getMenuInflater().inflate(R.menu.menuuser,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        int id = item.getItemId();
                        if (id == R.id.MenuSalir){
                            return true;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });*/

    }
}