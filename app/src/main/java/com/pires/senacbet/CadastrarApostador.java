package com.pires.senacbet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.pires.senacbet.DAO.ApostadorDAO;
import com.pires.senacbet.model.Apostador;

public class CadastrarApostador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_apostador);


    Button btn = findViewById(R.id.botao_finalizar_cad_apostador);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Apostador apostador = new Apostador();

            EditText editTextNome = findViewById(R.id.cadastrar_apostador_nome);
            EditText editTextEmail = findViewById(R.id.cadastrar_apostador_email);
            EditText editTextSaldo = findViewById(R.id.cadastrar_apostador_saldo);

            apostador.setNome(editTextNome.getText().toString());
            apostador.setEmail(editTextEmail.getText().toString());
            apostador.setSaldo(editTextSaldo.getText().toString());

            ApostadorDAO apostadorDAO = new ApostadorDAO(CadastrarApostador.this);
            apostadorDAO.salvar(apostador);

            finish();

        }


        });
    }
}