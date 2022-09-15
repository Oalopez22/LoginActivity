package com.Biblioteca.loginactivity.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Biblioteca.loginactivity.R;
import com.Biblioteca.loginactivity.entidades.Libro;
import com.Biblioteca.loginactivity.entidades.LibroPrestado;

import java.util.ArrayList;

public class ListaUsuarioLibroAdapter extends RecyclerView.Adapter<ListaUsuarioLibroAdapter.ListaUsuarioViewHolder> {
    ArrayList<LibroPrestado> listalibroprestado;
    Libro libros = new Libro();
    public ListaUsuarioLibroAdapter(ArrayList<LibroPrestado> listalibroprestado){
        this.listalibroprestado = listalibroprestado;}
    @NonNull
    @Override
    public ListaUsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_librosuser,null,false);
        return new ListaUsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaUsuarioViewHolder holder, int position) {
        holder.viewfecha_prestado.setText(listalibroprestado.get(position).getFecha_prestado());
    }

    @Override
    public int getItemCount() {
        return listalibroprestado.size();
    }

    public class ListaUsuarioViewHolder extends RecyclerView.ViewHolder {
        TextView viewfecha_prestado,viewAutor;
        public ListaUsuarioViewHolder(@NonNull View itemView) {

            super(itemView);
            viewfecha_prestado = itemView.findViewById(R.id.ViewFecha_PrestamoLibro);
            viewAutor = itemView.findViewById(R.id.viewNombreLibro);
        }
    }
}
