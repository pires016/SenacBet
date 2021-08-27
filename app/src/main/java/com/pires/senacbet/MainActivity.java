package com.pires.senacbet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.main_activity_botao_cadastrar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent (MainActivity.this, CadastrarApostador.class);
                startActivity(intent);
            }
        });

            Button btn2 = findViewById(R.id.main_activity_botao_cadastrar_time);
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent (MainActivity.this, CadastrarTime.class);
                    startActivity(intent);
                }
        });

        Button btn3 = findViewById(R.id.main_activity_botao_lista_apostadores);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent (MainActivity.this, ListaApostadores.class);
                startActivity(intent);
            }
        });

        Button btn4 = findViewById(R.id.main_activity_botao_lista_times);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent (MainActivity.this, ListaTimes.class);
                startActivity(intent);
            }
        });
    }


}