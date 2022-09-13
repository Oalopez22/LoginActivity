package com.Biblioteca.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.Biblioteca.loginactivity.db.DbBiblioteca;
import com.Biblioteca.loginactivity.entidades.Libro;

public class UserLendBook extends AppCompatActivity {
    /*TextView txtNameBook, txtAuthorBook, txtDescBook;*/
    EditText txtNameBook, txtAuthorBook, txtDescBook;
    ImageView imgplus,imgLibro;
    DbBiblioteca dbBiblioteca;
    Libro libro;
    int id = 0;
    Boolean correcto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_lend_book);
        dbBiblioteca = new DbBiblioteca(UserLendBook.this);
        libro = new Libro();

        txtNameBook = findViewById(R.id.txteVerNombreLibro);
        txtAuthorBook = findViewById(R.id.txtVerAutorLibro);
        txtDescBook = findViewById(R.id.txtVerDescLibro);
        imgLibro = findViewById(R.id.imgverImgLibro);
        correcto = false;
        if (savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if (extras == null){
                id = Integer.parseInt(null);
            }else{
                id = extras.getInt("ID");
            }
        }else{
            id = (int) savedInstanceState.getSerializable("ID");
        }

        libro = dbBiblioteca.verLibros(id);
        if (libro != null){
            txtNameBook.setText(libro.getNombrelibro());
            txtAuthorBook.setText(libro.getAutorlibro());
            txtDescBook.setText(libro.getDescripcionlibro());

        }

    }
}