package com.Biblioteca.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class AdminActivity extends AppCompatActivity {
    ImageView imgPlus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        imgPlus = findViewById(R.id.btnPlus);


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