package com.Biblioteca.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Biblioteca.loginactivity.db.DbHelper;

public class MainActivity extends AppCompatActivity {
    EditText txtLogUSer,txtLogPassword;
    Button btnIngresar;
    Button  btnRegistrarse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbHelper dbHelper = new DbHelper(MainActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        txtLogUSer = findViewById(R.id.txtLogUser);
        txtLogPassword = findViewById(R.id.txtLogPassword);
        btnIngresar = findViewById(R.id.btnIniciarSesion);
        btnRegistrarse = findViewById(R.id.btnRegister);
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
            }
        });

    }

   private void registrarUsuario(){
        Intent intent = new Intent(this, RegisterUser.class);
        startActivity(intent);
    }
}