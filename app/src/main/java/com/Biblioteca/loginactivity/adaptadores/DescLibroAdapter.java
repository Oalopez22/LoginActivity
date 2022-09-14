package com.Biblioteca.loginactivity.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Biblioteca.loginactivity.R;
import com.Biblioteca.loginactivity.UserAvailableBooks;
import com.Biblioteca.loginactivity.UserLendBook;
import com.Biblioteca.loginactivity.entidades.Libro;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DescLibroAdapter extends RecyclerView.Adapter<DescLibroAdapter.DescViewHolder> {
    ArrayList<Libro> ListaLibros;
    public DescLibroAdapter(ArrayList<Libro> listaLibros){
        this.ListaLibros = listaLibros;
    }
    @NonNull
    @Override
    public DescViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_librosuser,null,false);
        return new DescViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DescViewHolder holder, int position) {
        Glide.with(holder.imgimagen).load(ListaLibros.get(position).getImagenlibro()).into(holder.imgimagen);
        holder.viewNombreLibro.setText(ListaLibros.get(position).getNombrelibro());
        holder.viewAutorLibro.setText(ListaLibros.get(position).getAutorlibro());

    }

    @Override
    public int getItemCount() {
        return ListaLibros.size();
    }

    public class DescViewHolder extends RecyclerView.ViewHolder {
        TextView viewNombreLibro,viewAutorLibro;
        ImageView imgimagen;

        public DescViewHolder(@NonNull View itemView) {
            super(itemView);
/*            viewBookImg = itemView.findViewById(R.id.imgViewBook);*/
            viewNombreLibro = itemView.findViewById(R.id.viewNombreLibrouser);
            viewAutorLibro = itemView.findViewById(R.id.viewAutoruser);
            imgimagen = itemView.findViewById(R.id.imageView2user);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, UserLendBook .class);
                    intent.putExtra("ID",ListaLibros.get(getAdapterPosition()).getIdlibro());
                    context.startActivity(intent);
                }
            });
        }
    }
}
