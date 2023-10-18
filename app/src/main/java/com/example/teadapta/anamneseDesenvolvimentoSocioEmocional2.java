package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class anamneseDesenvolvimentoSocioEmocional2 extends AppCompatActivity {
    private AutoCompleteTextView escolha;
    private AutoCompleteTextView escolha2;
    private TextInputLayout religiaoLayout;
    private TextInputLayout lunedTextFieldDes2;
    private TextInputEditText seSenteSeparadoPais;
    private TextInputEditText informacoesImportantes;

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

    private boolean validateFields()
    {
        boolean valid = true;

        TextInputLayout seSenteSeparadoPaisLayout = findViewById(R.id.outlinedTextField);
        TextInputLayout informacoesImportantesLayout = findViewById(R.id.outlinedTextField2);
        String escolhaMedosFobias = escolha.getText().toString();
        String escolhaInvesteMomentos = escolha2.getText().toString();


        TextInputLayout medosFobiasLayout = findViewById(R.id.InputLayout);
        TextInputLayout investeMomentossLayout = findViewById(R.id.InputLayout2);

        int errorColor = ContextCompat.getColor(this, R.color.error_color);
        int errorIconColor = ContextCompat.getColor(this, R.color.error_icon_color);


        escolha.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                medosFobiasLayout.setError(null); // Remove a mensagem de erro
                medosFobiasLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                medosFobiasLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                medosFobiasLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaMedosFobias.equals("Selecionar"))
        {
            medosFobiasLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            medosFobiasLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            medosFobiasLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            medosFobiasLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            medosFobiasLayout.setError(null);

        }


        escolha2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                investeMomentossLayout.setError(null); // Remove a mensagem de erro
                investeMomentossLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                investeMomentossLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                investeMomentossLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaInvesteMomentos.equals("Selecionar"))
        {
            investeMomentossLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            investeMomentossLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            investeMomentossLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            investeMomentossLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            investeMomentossLayout.setError(null);

        }

        return valid;
    }
    public void submit (View view){

        if(validateFields())
        {
            String medosFobias = escolha.getText().toString();
            String investeMomentosFamilia = escolha2.getText().toString();

            TextInputLayout textInputLayout = findViewById(R.id.outlinedTextField);
            TextInputEditText textInputEditText = textInputLayout.findViewById(R.id.input);
            String comoSeSenteSeparadoDosPais = textInputEditText.getText().toString().trim();

            TextInputLayout informacoes= findViewById(R.id.outlinedTextField2);
            TextInputEditText textInputInformacoes = informacoes.findViewById(R.id.input2);
            String informacoesAdicionais = textInputInformacoes.getText().toString().trim();

            TextInputLayout descricao= findViewById(R.id.TextField);
            TextInputEditText textInputDescricao = descricao.findViewById(R.id.subescolha);
            String descricaoMedoFobia = textInputDescricao.getText().toString().trim();

            TextInputLayout investeMomentos= findViewById(R.id.TextField);
            TextInputEditText textInputInvesteMomentos = investeMomentos.findViewById(R.id.subescolha);
            String investeEmMomentosFamilia = textInputInvesteMomentos.getText().toString().trim();


            DadosCompartilhados dadosCompartilhados = DadosCompartilhados.getInstance();
            dadosCompartilhados.setMedosFobias(medosFobias);
            dadosCompartilhados.setInvesteMomentosFamilia(investeMomentosFamilia);
            dadosCompartilhados.setComoSeSenteSeparadoDosPais(comoSeSenteSeparadoDosPais);
            dadosCompartilhados.setInformacoesAdicionais(informacoesAdicionais);
            dadosCompartilhados.setDescricaoMedoFobia(descricaoMedoFobia);
            dadosCompartilhados.setInvesteEmMomentosFamilia(investeEmMomentosFamilia);


            Intent intent = new Intent(anamneseDesenvolvimentoSocioEmocional2.this, com.example.teadapta.anamneseDesenvolvimentoExercicio.class);
            startActivity(intent);
        }


    }
}