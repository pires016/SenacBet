package com.pires.senacbet;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.pires.senacbet.model.Time;
import com.pires.senacbet.DAO.TimeDAO;

import java.text.ParseException;

public class ListaTimes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_lista_times);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ListView view = findViewById(R.id.listar_times);

        TimeDAO timeDAO = new TimeDAO(ListaTimes.this);

        try {
            view.setAdapter(new ArrayAdapter<Time>(ListaTimes.this,
                    android.R.layout.simple_list_item_1,
                    timeDAO.listar()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
