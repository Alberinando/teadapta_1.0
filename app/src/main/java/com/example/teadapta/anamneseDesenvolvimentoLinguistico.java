package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.textfield.TextInputLayout;

public class anamneseDesenvolvimentoLinguistico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese_desenvolvimento_linguistico);

        AutoCompleteTextView escolha = findViewById(R.id.escolha);

        //Escolha de Sim ou Não
        String[] listaEscolha = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha);
        escolha.setAdapter(adapterEscolha);

        // Adiciona um TextWatcher ao campo de escolha
        escolha.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Chamado quando o texto é alterado
                String escolhaValue = s.toString().trim();

                // Obtenha uma referência ao TextInputLayout e TextInputEditText para o campo de religião
                TextInputLayout religiaoLayout = findViewById(R.id.outlinedTextFieldreligiao);

                // Verifica se a escolha é "Sim" para mostrar ou ocultar o campo de religião
                if (escolhaValue.equals("Sim")) {
                    religiaoLayout.setVisibility(View.VISIBLE);
                } else {
                    religiaoLayout.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}