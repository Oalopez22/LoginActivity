package com.Biblioteca.loginactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Biblioteca.loginactivity.db.DbBiblioteca;
import com.Biblioteca.loginactivity.entidades.Usuario;

import java.util.regex.Pattern;

public class RegisterUser extends AppCompatActivity {
    EditText txtRegNombre,txtRegEmail,txtRegPhone,txtRegAddress,txtRegPassword;
    Button btnRegistrar;
    Usuario usuario;
    private  static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,15}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        usuario = new Usuario();


        txtRegNombre = findViewById(R.id.txtRegName);
        txtRegEmail = findViewById(R.id.txtRegEmail);
        txtRegPhone = findViewById(R.id.txtRegPhone);
        txtRegAddress = findViewById(R.id.txtRegAdress);
        txtRegPassword = findViewById(R.id.txtRegPassword);
       btnRegistrar = findViewById(R.id.btnRegisterUser);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(validarNombre() && validarEmail() && validarTelefono() && validardirreccion() && validarPass() ){
                    DbBiblioteca dbbiblioteca = new DbBiblioteca(RegisterUser.this);
                    usuario.setTip_user(1);
                    long id = dbbiblioteca.crearUsuario(usuario);

                    if(id > 0 ){
                        Toast.makeText(RegisterUser.this, "Usuario creado", Toast.LENGTH_LONG).show();
                        limpiar();
                    }else{
                        Toast.makeText(RegisterUser.this, "Error al crear el usuario", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(RegisterUser.this, "Error al insertar registro", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
    private boolean validarNombre(){
        String nombre = txtRegNombre.getText().toString();
        if(!nombre.isEmpty()){
            usuario.setNombre(nombre);
            return true;
        }else{
            txtRegNombre.setError("Campo obligatorio");
            return  false;
        }
    }
    private boolean validarTelefono(){
        String telefono = txtRegPhone.getText().toString();
        if(!telefono.isEmpty()){
            usuario.setTelefono(telefono);
            return true;
        }else{
            txtRegPhone.setError("Campo obligatorio");
            return  false;
        }
    }
    private  boolean validarEmail(){
        String email = txtRegEmail.getText().toString();
        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            usuario.setEmail(email);
            return true;
        }else{
            txtRegEmail.setError("E-mail obligatorio");
            return false;
        }
    }
    private boolean validardirreccion(){
        String direccion = txtRegAddress.getText().toString();
        if(!direccion.isEmpty()){
            usuario.setDirecion(direccion);
            return true;
        }else{
            txtRegAddress.setError("Campo obligatorio");
            return  false;
        }
    }

    private  boolean validarPass(){
        String passwordInput = txtRegPassword.getText().toString();
        if(!passwordInput.isEmpty()){
            usuario.setPassword(passwordInput);
            return true;
        } else if(!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterUser.this);
            builder.setMessage("La contraseña debe incluir al menos un número, una letra en mayúscula, una  en minúscula y no debe incluir espacios")
                    .setTitle("Error")
                    .setCancelable(false)
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    }).show();
            return false;
        } else {
            txtRegPassword.setError("Campo obligatorio");
            return  false;
        }
    }
    private void limpiar()
    {
        txtRegNombre.setText("");
        txtRegEmail.setText("");
        txtRegAddress.setText("");
        txtRegPhone.setText("");
        txtRegPassword.setText("");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}