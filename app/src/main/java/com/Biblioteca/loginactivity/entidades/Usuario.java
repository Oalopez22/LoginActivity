package com.Biblioteca.loginactivity.entidades;

public class Usuario {
    private int id;
    private  String nombre;
    private String email;
    private String telefono;
    private String direcion;
    private  String password;
    private int tip_user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTip_user() {
        return tip_user;
    }

    public void setTip_user(int tip_user) {
        this.tip_user = tip_user;
    }
}
