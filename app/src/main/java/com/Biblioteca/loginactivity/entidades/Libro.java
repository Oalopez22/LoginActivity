package com.Biblioteca.loginactivity.entidades;

public class Libro {
    private int idlibro;
    private  String nombrelibro;
    private String autorlibro;
    private int cantidadlibro ;
    private String urllibro;
    private  String imagenlibro;
    private String descripcionlibro;

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public String getNombrelibro() {
        return nombrelibro;
    }

    public void setNombrelibro(String nombrelibro) {
        this.nombrelibro = nombrelibro;
    }

    public String getAutorlibro() {
        return autorlibro;
    }

    public void setAutorlibro(String autorlibro) {
        this.autorlibro = autorlibro;
    }

    public int getCantidadlibro() {
        return cantidadlibro;
    }

    public void setCantidadlibro(int cantidadlibro) {
        this.cantidadlibro = cantidadlibro;
    }

    public String getUrllibro() {
        return urllibro;
    }

    public void setUrllibro(String urllibro) {
        this.urllibro = urllibro;
    }

    public String getImagenlibro() {
        return imagenlibro;
    }

    public void setImagenlibro(String imagenlibro) {
        this.imagenlibro = imagenlibro;
    }

    public String getDescripcionlibro() {
        return descripcionlibro;
    }

    public void setDescripcionlibro(String descripcionlibro) {
        this.descripcionlibro = descripcionlibro;
    }
}
