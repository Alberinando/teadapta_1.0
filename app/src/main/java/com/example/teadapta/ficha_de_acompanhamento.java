package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class ficha_de_acompanhamento extends AppCompatActivity {

    private AutoCompleteTextView escolha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_de_acompanhamento);

        escolha = findViewById(R.id.escolha);

        //Escolha do Gênero
        String[] listaEscolha = getResources().getStringArray(R.array.Genero);
        ArrayAdapter<String> adapterEscolha = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha);
        escolha.setAdapter(adapterEscolha);
    }
}