package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class anamneseDesenvolvimentoLinguistico extends AppCompatActivity {
    private TextInputEditText inputEditText;
    private TextInputEditText dataEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese_desenvolvimento_linguistico);

        AutoCompleteTextView escolha = findViewById(R.id.escolha);

        inputEditText = findViewById(R.id.respondeuSom);
        dataEditText = findViewById(R.id.voz);

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

    private boolean validateFields() {
        boolean valid = true;
        TextInputLayout inputLayout = findViewById(R.id.Field);
        TextInputLayout dataLayout = findViewById(R.id.Field2);
        int errorColor = ContextCompat.getColor(this, R.color.error_color);
        int errorIconColor = ContextCompat.getColor(this, R.color.error_icon_color);

        if (inputEditText.getText().toString().trim().isEmpty()) {
            if (!inputEditText.isFocused()) { // Verifica se o campo não está em foco
                inputLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                inputLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                inputLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                inputLayout.setError("Campo vazio");
            } else {
                inputLayout.setError(null);
            }
            valid = false;
        } else {
            inputLayout.setError(null);
        }

        if (dataEditText.getText().toString().trim().isEmpty()) {
            if (!dataEditText.isFocused()) { // Verifica se o campo não está em foco
                dataLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                dataLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                dataLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                dataLayout.setError("Campo vazio");
            }
            valid = false;
        }

        return valid;
    }
    public void Back (View view){
        Intent intent = new Intent(anamneseDesenvolvimentoLinguistico.this, com.example.teadapta.anamneseDesenvolvimentoCrianca.class);
        startActivity(intent);
    }

    public void submit (View view){
        if (validateFields()) {
            Intent intent = new Intent(anamneseDesenvolvimentoLinguistico.this, com.example.teadapta.anamneseDesenvolvimentoSocioEmocional.class);
            startActivity(intent);
        }
    }
}