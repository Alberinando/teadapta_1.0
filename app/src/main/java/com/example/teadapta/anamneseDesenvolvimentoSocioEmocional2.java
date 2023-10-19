package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;
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

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.xmlpull.v1.XmlPullParser;

public class anamneseDesenvolvimentoSocioEmocional2 extends AppCompatActivity {
    private AutoCompleteTextView escolha;
    private AutoCompleteTextView escolha2;
    private TextInputLayout religiaoLayout;
   // private TextInputLayout lunedTextFieldDes2;
    private TextInputEditText seSenteSeparadoPais2;
    private TextInputEditText informacoesImportantes2;
    private TextInputEditText descricaoMedoFobia2;
    private TextInputEditText investeMomentosFamilia2;
    private TextInputLayout lunedTextFieldDes3;


    private String comoSeSenteSeparadoDosPais;
    private String informacoesAdicionais;
    //private String descricaoMedoFobia;

    private XmlPullParser subescolha;
    private String descricaoMedoFobia;
    private String investeEmMomentosFamilia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese_desenvolvimento_socio_emocional2);

        escolha = findViewById(R.id.escolha);
        escolha2 = findViewById(R.id.escolha2);
        religiaoLayout = findViewById(R.id.TextField);

        seSenteSeparadoPais2 = findViewById(R.id.input);
        informacoesImportantes2 = findViewById(R.id.input2);

        //descricaoMedoFobia = findViewById(R.id.subescolha);
        //investeMomentosFamilia = findViewById(R.id.subescolha2);


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
        lunedTextFieldDes3 = findViewById(R.id.lunedTextFieldDes2);
        //lunedTextFieldDes3 = findViewById(R.id.subescolha2);


        investeMomentosFamilia2 = findViewById(R.id.subescolha2);
        descricaoMedoFobia2 = findViewById(R.id.subescolha);

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
                updateLayoutVisibility(escolhaValue2, lunedTextFieldDes3);
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

        String escolhaMedosFobias = escolha.getText().toString();
        String escolhaInvesteMomentos = escolha2.getText().toString();

        TextInputLayout seSenteSeparadoPaisLayout = findViewById(R.id.outlinedTextField);
        TextInputLayout informacoesImportantesLayout = findViewById(R.id.outlinedTextField2);
        TextInputLayout descricaoMedoFobiaLayout = findViewById(R.id.TextField);
        TextInputLayout investeMomentosFamiliaLayout = findViewById(R.id.lunedTextFieldDes2);


        TextInputLayout medosFobiasLayout = findViewById(R.id.InputLayout);
        TextInputLayout investeMomentossLayout = findViewById(R.id.InputLayout2);

        int errorColor = ContextCompat.getColor(this, R.color.error_color);
        int errorIconColor = ContextCompat.getColor(this, R.color.error_icon_color);


        informacoesImportantes2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}   // Nada a fazer antes da mudança de texto

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                informacoesImportantesLayout.setError(null); // Remove a mensagem de erro
                informacoesImportantesLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                informacoesImportantesLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                informacoesImportantesLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        if (informacoesImportantes2.getText().toString().trim().isEmpty()) {
            if (!informacoesImportantes2.isFocused()) {
                informacoesImportantesLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                informacoesImportantesLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                informacoesImportantesLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                informacoesImportantesLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            informacoesImportantesLayout.setError(null);
        }

        seSenteSeparadoPais2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}   // Nada a fazer antes da mudança de texto

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                seSenteSeparadoPaisLayout.setError(null); // Remove a mensagem de erro
                seSenteSeparadoPaisLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                seSenteSeparadoPaisLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                seSenteSeparadoPaisLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        if (seSenteSeparadoPais2.getText().toString().trim().isEmpty()) {
            if (!seSenteSeparadoPais2.isFocused()) {
                seSenteSeparadoPaisLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                seSenteSeparadoPaisLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                seSenteSeparadoPaisLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                seSenteSeparadoPaisLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            seSenteSeparadoPaisLayout.setError(null);
        }
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

        else if(escolhaMedosFobias.equals("Sim"))
        {
            descricaoMedoFobia2.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}   // Nada a fazer antes da mudança de texto

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

                @Override
                public void afterTextChanged(Editable editable) {
                    // Chamado após o texto ser alterado
                    descricaoMedoFobiaLayout.setError(null); // Remove a mensagem de erro
                    descricaoMedoFobiaLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                    descricaoMedoFobiaLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                    descricaoMedoFobiaLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
                }
            });
            if (descricaoMedoFobia2.getText().toString().trim().isEmpty()) {
                if (!descricaoMedoFobia2.isFocused()) {
                    descricaoMedoFobiaLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                    descricaoMedoFobiaLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                    descricaoMedoFobiaLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                    descricaoMedoFobiaLayout.setError("Campo vazio");
                }
                valid = false;
            } else {
                descricaoMedoFobiaLayout.setError(null);
            }
        }


        else
        {
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

        else if(escolhaInvesteMomentos.equals("Sim"))
        {
            investeMomentosFamilia2.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}   // Nada a fazer antes da mudança de texto

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

                @Override
                public void afterTextChanged(Editable editable) {
                    // Chamado após o texto ser alterado
                    investeMomentosFamiliaLayout.setError(null); // Remove a mensagem de erro
                    investeMomentosFamiliaLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                    investeMomentosFamiliaLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                    investeMomentosFamiliaLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
                }
            });
            if (investeMomentosFamilia2.getText().toString().trim().isEmpty()) {
                if (!investeMomentosFamilia2.isFocused()) {
                    investeMomentosFamiliaLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                    investeMomentosFamiliaLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                    investeMomentosFamiliaLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                    investeMomentosFamiliaLayout.setError("Campo vazio");
                }
                valid = false;
            } else {
                investeMomentosFamiliaLayout.setError(null);
            }
        }

        else
        {
            investeMomentossLayout.setError(null);

        }



        return valid;
    }
    public void submit (View view){

        if(validateFields())
        {
            String medosFobias = escolha.getText().toString();
            String investeMomentosFamilia = escolha2.getText().toString();
            investeEmMomentosFamilia = investeMomentosFamilia2.getText().toString().trim();
            descricaoMedoFobia = descricaoMedoFobia2.getText().toString().trim();



            comoSeSenteSeparadoDosPais  = seSenteSeparadoPais2.getText().toString().trim();
            informacoesAdicionais  = informacoesImportantes2.getText().toString().trim();



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