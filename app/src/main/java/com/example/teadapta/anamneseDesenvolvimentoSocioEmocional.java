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

public class anamneseDesenvolvimentoSocioEmocional extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese_desenvolvimento_socio_emocional);

        AutoCompleteTextView escolha = findViewById(R.id.escolha);
        AutoCompleteTextView escolha2 = findViewById(R.id.escolha2);
        AutoCompleteTextView escolha3 = findViewById(R.id.escolha3);
        AutoCompleteTextView escolha4 = findViewById(R.id.escolha4);
        AutoCompleteTextView escolha5 = findViewById(R.id.escolha5);
        AutoCompleteTextView escolha6 = findViewById(R.id.escolha6);
        AutoCompleteTextView escolha7 = findViewById(R.id.escolha7);
        AutoCompleteTextView escolha8 = findViewById(R.id.escolha8);
        AutoCompleteTextView escolha9 = findViewById(R.id.escolha9);
        AutoCompleteTextView escolha00 = findViewById(R.id.escolha00);
        AutoCompleteTextView escolha01 = findViewById(R.id.escolha01);

        //Escolha de Sim ou Não
        String[] listaEscolha = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha);
        escolha.setAdapter(adapterEscolha);

        String[] listaEscolha2 = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha2);
        escolha2.setAdapter(adapterEscolha2);

        String[] listaEscolha3 = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha3);
        escolha3.setAdapter(adapterEscolha3);

        String[] listaEscolha4 = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha4 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha4);
        escolha4.setAdapter(adapterEscolha4);

        String[] listaEscolha5 = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha5 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha5);
        escolha5.setAdapter(adapterEscolha5);

        String[] listaEscolha6 = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha6 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha6);
        escolha6.setAdapter(adapterEscolha6);

        String[] listaEscolha7 = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha7 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha7);
        escolha7.setAdapter(adapterEscolha7);

        String[] listaEscolha8 = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha8 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha8);
        escolha8.setAdapter(adapterEscolha8);

        String[] listaEscolha9 = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha9 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha9);
        escolha9.setAdapter(adapterEscolha9);

        String[] listaEscolha00 = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha00 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha00);
        escolha00.setAdapter(adapterEscolha00);

        String[] listaEscolha01 = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha01 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha01);
        escolha01.setAdapter(adapterEscolha01);

        // Adiciona um TextWatcher ao campo de escolha
        escolha.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Chamado quando o texto é alterado
                String escolhaValue = s.toString().trim();

                // Obtenha uma referência ao TextInputLayout e TextInputEditText para o campo de checkout
                LinearLayout checkBoxGroup = findViewById(R.id.checkBoxGroup);

                // Verifica se a escolha é "Não" para mostrar ou ocultar o campo de religião
                if (escolhaValue.equals("Não")) {
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
    public void Back (View view){
        Intent intent = new Intent(anamneseDesenvolvimentoSocioEmocional.this, com.example.teadapta.anamneseDesenvolvimentoLinguistico.class);
        startActivity(intent);
    }
    public void submit (View view){
        Intent intent = new Intent(anamneseDesenvolvimentoSocioEmocional.this, com.example.teadapta.anamneseDesenvolvimentoSocioEmocional2.class);
        startActivity(intent);
    }
}