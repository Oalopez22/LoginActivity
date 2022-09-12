package com.Biblioteca.loginactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.Biblioteca.loginactivity.db.DbBiblioteca;
import com.Biblioteca.loginactivity.entidades.Libro;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {
    ImageView imgPlus;
    RecyclerView listalibros;
    Button btnPrestar;
    ArrayList<Libro> listaArrayLibros;
    DbBiblioteca dbBiblioteca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        dbBiblioteca = new DbBiblioteca(UserActivity.this);
        imgPlus = findViewById(R.id.btnPlus);
        imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(UserActivity.this,imgPlus);
                popupMenu.getMenuInflater().inflate(R.menu.menuuser,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        int id = item.getItemId();
                        if (id == R.id.MenuUserSalir){

                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });


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