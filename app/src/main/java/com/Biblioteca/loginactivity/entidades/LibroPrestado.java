package com.Biblioteca.loginactivity.entidades;

public class LibroPrestado {
    private String correo_user;
    private int id_libro_ref;
    private String fecha_prestado;
    private String fecha_entrega;
    private int estado_libro;

    public String getCorreo_user() {
        return correo_user;
    }

    public void setCorreo_user(String correo_user) {
        this.correo_user = correo_user;
    }


    public String getFecha_prestado() {
        return fecha_prestado;
    }

    public void setFecha_prestado(String fecha_prestado) {
        this.fecha_prestado = fecha_prestado;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public int getEstado_libro() {
        return estado_libro;
    }

    public void setEstado_libro(int estado_libro) {
        this.estado_libro = estado_libro;
    }

    public int getId_libro_ref() {
        return id_libro_ref;
    }

    public void setId_libro_ref(int id_libro_ref) {
        this.id_libro_ref = id_libro_ref;
    }
}
