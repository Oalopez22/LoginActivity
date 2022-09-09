package com.Biblioteca.loginactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.Biblioteca.loginactivity.adaptadores.ListaLibrosAdapter;
import com.Biblioteca.loginactivity.db.DbBiblioteca;
import com.Biblioteca.loginactivity.entidades.Libro;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {
    ImageView imgPlus, imgLibro;
    RecyclerView listalibros;
    ArrayList<Libro> listaArrayLibros;
    DbBiblioteca dbBiblioteca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        dbBiblioteca = new DbBiblioteca(AdminActivity.this);

        listalibros = findViewById(R.id.RviewLibros);
        listaArrayLibros = new ArrayList<>();
        ListaLibrosAdapter adapter = new ListaLibrosAdapter(dbBiblioteca.mostrarLibros());
        listalibros.setAdapter(adapter);
       /* bM.rvMenu.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));*/
        imgPlus = findViewById(R.id.btnPlus);
        imgLibro = findViewById(R.id.imageView2);
        listalibros.setLayoutManager(new GridLayoutManager(AdminActivity.this,2));

        imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(AdminActivity.this,imgPlus);
                popupMenu.getMenuInflater().inflate(R.menu.menuadmin,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        int id = item.getItemId();
                        if (id == R.id.MenuAdd){
                            agregarLibro();
                        }else if (id == R.id.MenuPrestar){

                        }else if (id == R.id.MenuSalir){

                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

    }



    private void agregarLibro(){
        Intent intent = new Intent(this,AddBookAdmin.class);
        startActivity(intent);
    }
}