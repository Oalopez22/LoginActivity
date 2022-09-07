package com.Biblioteca.loginactivity.SharedPreferences;

import android.content.Context;

public class SharedPreferences {
    Context context;
    android.content.SharedPreferences datos;
    android.content.SharedPreferences.Editor editor;

    public SharedPreferences(Context context) {
        this.context = context;
        datos = context.getSharedPreferences("base_sp", Context.MODE_PRIVATE);
        editor = datos.edit();
    }

    public void setCorreo(String correo) {
        editor.putString("correo", correo);
        editor.apply();
    }

    public String getCorreo() {
        return datos.getString("correo", "Dato no encontrado");
    }
}
