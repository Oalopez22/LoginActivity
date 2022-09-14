package com.Biblioteca.loginactivity.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Biblioteca.loginactivity.AdminActivity;
import com.Biblioteca.loginactivity.R;
import com.Biblioteca.loginactivity.Update_Book_Admin;
import com.Biblioteca.loginactivity.UserLendBook;
import com.Biblioteca.loginactivity.entidades.Libro;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListaLibrosAdapter extends RecyclerView.Adapter<ListaLibrosAdapter.LibroViewHolder> {

    ArrayList<Libro> ListaLibros;
    public ListaLibrosAdapter(ArrayList<Libro> listaLibros){
        this.ListaLibros = listaLibros;
    }
    @NonNull
    @Override
    public LibroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_libros,null,false);
/*        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.descripcion_libro,null,false);*/
        return new LibroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibroViewHolder holder, int position) {
        Glide.with(holder.imgimagen).load(ListaLibros.get(position).getImagenlibro()).into(holder.imgimagen);
        holder.viewNombreLibro.setText(ListaLibros.get(position).getNombrelibro());
        holder.viewAutorLibro.setText(ListaLibros.get(position).getAutorlibro());
    }

    @Override
    public int getItemCount() {
        return ListaLibros.size();

    }

    public class LibroViewHolder extends RecyclerView.ViewHolder {
        TextView viewNombreLibro,viewAutorLibro;
        ImageView imgimagen;
        ImageView imagenLibro;
        public LibroViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNombreLibro = itemView.findViewById(R.id.viewNombreLibro);
            viewAutorLibro = itemView.findViewById(R.id.viewAutor);
            imgimagen = itemView.findViewById(R.id.imageView2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, AdminActivity.class);
                    intent.putExtra("ID",ListaLibros.get(getAdapterPosition()).getIdlibro());
                    context.startActivity(intent);
                }
            });
        }
    }

}
