package com.Biblioteca.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Biblioteca.loginactivity.SharedPreferences.SharedPreferences;
import com.Biblioteca.loginactivity.db.DbBiblioteca;
import com.Biblioteca.loginactivity.db.DbHelper;
import com.Biblioteca.loginactivity.entidades.Usuario;

public class MainActivity extends AppCompatActivity {
    EditText txtLogUSer,txtLogPassword;
    Button btnIngresar;
    Button  btnRegistrarse;
    Usuario user;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbHelper dbHelper = new DbHelper(MainActivity.this);
        DbBiblioteca dbBiblioteca = new DbBiblioteca(MainActivity.this);
        user = new Usuario();
        sp = new SharedPreferences(MainActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        txtLogUSer = findViewById(R.id.txtLogUser);
        txtLogPassword = findViewById(R.id.txtLogPassword);
        btnIngresar = findViewById(R.id.btnIniciarSesion);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correo = txtLogUSer.getText().toString();
                String password = txtLogPassword.getText().toString();

                if (correo.equals("") || password.equals("")) {
                    Toast.makeText(MainActivity.this, "Campos correo y contraseña obligatorios", Toast.LENGTH_SHORT).show();
                } else {
                    user.setEmail(correo);
                    user.setPassword(password);

                    Boolean revisarDatos = dbBiblioteca.revisarDatos(user);
                    if (revisarDatos) {
                        sp.setCorreo(correo);
                        ingresarUser();
                    } else {
                        Toast.makeText(MainActivity.this, "Error al iniciar sesion", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


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
    private void ingresarUser(){
        if (user.getTip_user()==0){
            Intent intent = new Intent(this,AdminActivity.class);
            startActivity(intent);
        }
    }
}