package com.Biblioteca.loginactivity.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Biblioteca.loginactivity.R;
import com.Biblioteca.loginactivity.UserLendBook;
import com.Biblioteca.loginactivity.entidades.Libro;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class LendBookAdapter extends RecyclerView.Adapter<LendBookAdapter.LendBookViewHolder> {
    ArrayList<Libro> ListaLibros;
    public LendBookAdapter(ArrayList<Libro> listaLibros){
        this.ListaLibros = listaLibros;
    }
    @NonNull
    @Override
    public LendBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.descripcion_libro,null,false);
        return new LendBookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LendBookViewHolder holder, int position) {
        Glide.with(holder.imagenLibroUser).load(ListaLibros.get(position).getImagenlibro()).into(holder.imagenLibroUser);
        holder.viewNameBook.setText(ListaLibros.get(position).getNombrelibro());
        holder.viewAuthorBook.setText(ListaLibros.get(position).getAutorlibro());
        holder.viewDescBook.setText(ListaLibros.get(position).getDescripcionlibro());
    }

    @Override
    public int getItemCount() {
        return ListaLibros.size();
    }

    public class LendBookViewHolder extends RecyclerView.ViewHolder {
        EditText viewBookImg,viewNameBook,viewAuthorBook,viewDescBook;
        ImageView imagenLibroUser;
        public LendBookViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenLibroUser = itemView.findViewById(R.id.imgviewLibro);
            viewNameBook= itemView.findViewById(R.id.txtverBookName);
            viewAuthorBook = itemView.findViewById(R.id.txtverBookAutor);
            viewDescBook = itemView.findViewById(R.id.txtverBookDesc);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, UserLendBook.class);
                    intent.putExtra("ID",ListaLibros.get(getAdapterPosition()).getIdlibro());
                    context.startActivity(intent);
                }
            });
        }
    }
}
