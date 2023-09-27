package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.textfield.TextInputLayout;

public class anamneseDesenvolvimentoExercicio extends AppCompatActivity {

    private AutoCompleteTextView escolha;
    private TextInputLayout religiaoLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese_desenvolvimento_exercicio);
        escolha = findViewById(R.id.escolha);
        religiaoLayout = findViewById(R.id.TextField);

        String[] listaEscolha = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha);
        escolha.setAdapter(adapterEscolha);
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
    }

    private void updateLayoutVisibility(String escolhaValue, TextInputLayout layout) {
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