package com.pires.senacbet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.pires.senacbet.DAO.TimeDAO;
import com.pires.senacbet.model.Time;


public class CadastrarTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_time);


        Button btn = findViewById(R.id.botao_finalizar_cad_time);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Time time = new Time();

                EditText editTextNome_time = findViewById(R.id.cadastrar_time_nome);
                EditText editTextCidade_time = findViewById(R.id.cadastrar_time_cidade);
                EditText editTextPais_time = findViewById(R.id.cadastrar_time_pais);

                time.setNome_Time(editTextNome_time.getText().toString());
                time.setCidade_Time(editTextCidade_time.getText().toString());
                time.setPais_Time(editTextPais_time.getText().toString());

                TimeDAO timeDAO = new TimeDAO(CadastrarTime.this);
                timeDAO.salvar(time);

                finish();

        }


    });
}
}
