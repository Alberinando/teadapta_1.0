package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputLayout;

public class anamneseDesenvolvimentoExercicio extends AppCompatActivity {

    private AutoCompleteTextView escolha, escolha2;
    private TextInputLayout religiaoLayout, religiaoLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese_desenvolvimento_exercicio);
        escolha = findViewById(R.id.escolha);
        escolha2 = findViewById(R.id.escolha2);
        religiaoLayout = findViewById(R.id.TextField);
        religiaoLayout2 = findViewById(R.id.TextField2);

        String[] listaEscolha = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha);
        escolha.setAdapter(adapterEscolha);

        String[] listaEscolha2 = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha2 = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha2);
        escolha2.setAdapter(adapterEscolha2);
        escolha.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String escolhaValue = s.toString().trim();
                updateLayoutVisibility(escolhaValue, religiaoLayout);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        escolha2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String escolhaValue = s.toString().trim();
                updateLayoutVisibility2(escolhaValue, religiaoLayout2);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        escolha2.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Chamado quando o texto é alterado
                String escolhaValue = s.toString().trim();

                // Obtenha uma referência ao TextInputLayout e TextInputEditText para o campo de checkout
                LinearLayout checkBoxGroup = findViewById(R.id.checkBoxGroup);

                // Verifica se a escolha é "Não" para mostrar ou ocultar o campo de religião
                if (escolhaValue.equals("Sim")) {
                    checkBoxGroup.setVisibility(View.VISIBLE);
                } else {
                    checkBoxGroup.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void updateLayoutVisibility(String escolhaValue, TextInputLayout layout) {
        if (escolhaValue.equalsIgnoreCase("Sim")) {
            layout.setVisibility(View.VISIBLE);
        } else {
            layout.setVisibility(View.GONE);
        }
    }

    private void updateLayoutVisibility2(String escolhaValue, TextInputLayout layout) {
        if (escolhaValue.equalsIgnoreCase("Sim")) {
            layout.setVisibility(View.VISIBLE);
        } else {
            layout.setVisibility(View.GONE);
        }
    }


    public void Back (View view){
        Intent intent = new Intent(anamneseDesenvolvimentoExercicio.this, com.example.teadapta.anamneseDesenvolvimentoSocioEmocional2.class);
        startActivity(intent);
    }
}