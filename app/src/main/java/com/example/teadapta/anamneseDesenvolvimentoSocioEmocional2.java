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

public class anamneseDesenvolvimentoSocioEmocional2 extends AppCompatActivity {
    private AutoCompleteTextView escolha;
    private AutoCompleteTextView escolha2;
    private TextInputLayout religiaoLayout;
    private TextInputLayout lunedTextFieldDes2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese_desenvolvimento_socio_emocional2);

        escolha = findViewById(R.id.escolha);
        escolha2 = findViewById(R.id.escolha2);
        religiaoLayout = findViewById(R.id.TextField);

        String[] listaEscolha = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha);
        escolha.setAdapter(adapterEscolha);
        escolha2.setAdapter(adapterEscolha);

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

        escolha2 = findViewById(R.id.escolha2);
        lunedTextFieldDes2 = findViewById(R.id.lunedTextFieldDes2);

        String[] listaEscolha2 = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha2 = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha2);
        escolha2.setAdapter(adapterEscolha2);

        escolha2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String escolhaValue2 = s.toString().trim();
                updateLayoutVisibility(escolhaValue2, lunedTextFieldDes2);
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
        super.onBackPressed();
    }
    public void submit (View view){
        Intent intent = new Intent(anamneseDesenvolvimentoSocioEmocional2.this, com.example.teadapta.anamneseDesenvolvimentoExercicio.class);
        startActivity(intent);
    }
}