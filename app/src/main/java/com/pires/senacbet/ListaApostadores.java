package com.pires.senacbet;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.pires.senacbet.DAO.ApostadorDAO;
import com.pires.senacbet.model.Apostador;

import java.text.ParseException;

public class ListaApostadores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_apostador);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ListView view = findViewById(R.id.lista_apostadores);

        ApostadorDAO apostadorDAO = new ApostadorDAO(ListaApostadores.this);

        try {
            view.setAdapter(new ArrayAdapter<Apostador>(ListaApostadores.this,
                    android.R.layout.simple_list_item_1,
                    apostadorDAO.listar()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
