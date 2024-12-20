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

import org.xmlpull.v1.XmlPullParser;

public class anamneseDesenvolvimentoLinguistico extends AppCompatActivity {
    private TextInputEditText inputEditText;
    private TextInputEditText dataEditText,vocalizouEditText,
    primeirasPalavrasdataEditText,frasedataEditText,descricaoProblemaComunicacao;
    //private AutoCompleteTextView descricaoProblemaComunicacao;
    private AutoCompleteTextView escolhaProblemasComunicacao;
    private AutoCompleteTextView descricaoProblemaComunicacaoVerbal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese_desenvolvimento_linguistico);

        escolhaProblemasComunicacao = findViewById(R.id.escolhaProblemasComunicacao);
        descricaoProblemaComunicacao = findViewById(R.id.subescolha);

        inputEditText = findViewById(R.id.respondeuSom);
        dataEditText = findViewById(R.id.voz);
        vocalizouEditText = findViewById(R.id.Field3_);
        primeirasPalavrasdataEditText = findViewById(R.id.Field4_);
        frasedataEditText = findViewById(R.id.Field5_);

        //Escolha de Sim ou Não
        String[] listaEscolha = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha);
        escolhaProblemasComunicacao.setAdapter(adapterEscolha);

        // Adiciona um TextWatcher ao campo de escolha
        escolhaProblemasComunicacao.addTextChangedListener(new TextWatcher() {

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

        String escolhaProblemaComunicacaoVerbal = escolhaProblemasComunicacao.getText().toString();
       // String descricaoProblemaComunicacaoVerbal = descricaoProblemaComunicacao.getText().toString();

        TextInputLayout problemaComunicacaoVerbalLayout = findViewById(R.id.InputLayout);
        TextInputLayout descricaoProblemaLayout = findViewById(R.id.outlinedTextFieldreligiao);
        // descricaoProblemaComunicacaoVerbalLayout = findViewById(R.id.outlinedTextFieldreligiao);



        TextInputLayout inputLayout = findViewById(R.id.Field);
        TextInputLayout dataLayout = findViewById(R.id.Field2);
        TextInputLayout vocalizouLayout = findViewById(R.id.Field3);
        TextInputLayout primeirasPalavrasdataLayout = findViewById(R.id.Field4);
        TextInputLayout rasedataLayout = findViewById(R.id.Field5);

        int errorColor = ContextCompat.getColor(this, R.color.error_color);
        int errorIconColor = ContextCompat.getColor(this, R.color.error_icon_color);

        // Ouvinte de texto para inputEditText
        inputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Nada a fazer antes da mudança de texto
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Nada a fazer durante a mudança de texto
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                inputLayout.setError(null); // Remove a mensagem de erro
                inputLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                inputLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                inputLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        if (inputEditText.getText().toString().trim().isEmpty()) {
            if (!inputEditText.isFocused()) {
                inputLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                inputLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                inputLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                inputLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            inputLayout.setError(null);
        }
        dataEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Nada a fazer antes da mudança de texto
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Nada a fazer durante a mudança de texto
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                dataLayout.setError(null); // Remove a mensagem de erro
                dataLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                dataLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                dataLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        if (dataEditText.getText().toString().trim().isEmpty()) {
            if (!dataEditText.isFocused()) {
                dataLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                dataLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                dataLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                dataLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            dataLayout.setError(null);
        }
        vocalizouEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                vocalizouLayout.setError(null); // Remove a mensagem de erro
                vocalizouLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                vocalizouLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                vocalizouLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        
        if (vocalizouEditText.getText().toString().trim().isEmpty()) {
            if (!vocalizouEditText.isFocused()) {
                vocalizouLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                vocalizouLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                vocalizouLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                vocalizouLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            vocalizouLayout.setError(null);
        }
        primeirasPalavrasdataEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                primeirasPalavrasdataLayout.setError(null); // Remove a mensagem de erro
                primeirasPalavrasdataLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                primeirasPalavrasdataLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                primeirasPalavrasdataLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        
        if (primeirasPalavrasdataEditText.getText().toString().trim().isEmpty()) {
            if (!primeirasPalavrasdataEditText.isFocused()) {
                primeirasPalavrasdataLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                primeirasPalavrasdataLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                primeirasPalavrasdataLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                primeirasPalavrasdataLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            primeirasPalavrasdataLayout.setError(null);
        }
        frasedataEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                rasedataLayout.setError(null); // Remove a mensagem de erro
                rasedataLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                rasedataLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                rasedataLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        
        if (frasedataEditText.getText().toString().trim().isEmpty()) {
            if (!frasedataEditText.isFocused()) {
                rasedataLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                rasedataLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                rasedataLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                rasedataLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            rasedataLayout.setError(null);
        }

        escolhaProblemasComunicacao.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                problemaComunicacaoVerbalLayout.setError(null); // Remove a mensagem de erro
                problemaComunicacaoVerbalLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                problemaComunicacaoVerbalLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                problemaComunicacaoVerbalLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaProblemaComunicacaoVerbal.equals("Selecionar"))
        {
            problemaComunicacaoVerbalLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            problemaComunicacaoVerbalLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            problemaComunicacaoVerbalLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            problemaComunicacaoVerbalLayout.setError("Campo vazio");
            valid = false;
        }
        else if(escolhaProblemaComunicacaoVerbal.equals("Sim"))
        {
            descricaoProblemaComunicacao.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    // Nada a fazer antes da mudança de texto
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    // Nada a fazer durante a mudança de texto
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    // Chamado após o texto ser alterado
                    descricaoProblemaLayout.setError(null); // Remove a mensagem de erro
                    descricaoProblemaLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                    descricaoProblemaLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                    descricaoProblemaLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
                }
            });
            if (descricaoProblemaComunicacao.getText().toString().trim().isEmpty()) {
                if (!descricaoProblemaComunicacao.isFocused()) {
                    descricaoProblemaLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                    descricaoProblemaLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                    descricaoProblemaLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                    descricaoProblemaLayout.setError("Campo vazio");
                }
                valid = false;
            } else {
                descricaoProblemaLayout.setError(null);
            }
        }
        else
        {
            problemaComunicacaoVerbalLayout.setError(null);

        }

        return valid;
    }
    public void Back (View view){
        super.onBackPressed();
    }

    public void submit (View view){
        if (validateFields()) {

            String respondruSom = inputEditText.getText().toString().trim();
            String respondeuSomHumano = dataEditText.getText().toString().trim();
            String vocalizou = vocalizouEditText.getText().toString().trim();
            String primeirasPalavras = primeirasPalavrasdataEditText.getText().toString().trim();
            String frase = frasedataEditText.getText().toString().trim();
            String problemasComunicacao = escolhaProblemasComunicacao.getText().toString();
            String descricaoDoProblemaComunicacao = descricaoProblemaComunicacao.getText().toString();


            DadosCompartilhados dadosCompartilhados = DadosCompartilhados.getInstance();
            dadosCompartilhados.setRespondruSom(respondruSom);
            dadosCompartilhados.setRespondeuSomHumano(respondeuSomHumano);
            dadosCompartilhados.setVocalizou(vocalizou);
            dadosCompartilhados.setPrimeirasPalavras(primeirasPalavras);
            dadosCompartilhados.setFrase(frase);
            dadosCompartilhados.setProblemasComunicacao(problemasComunicacao);
            dadosCompartilhados.setDescricaoDoProblemaComunicacao(descricaoDoProblemaComunicacao);

            //Foi identificado um erro nesse campo em baixo, sempre que ele é asionado
            //o app fecha e não passa para proxima tela



            Intent intent = new Intent(anamneseDesenvolvimentoLinguistico.this, com.example.teadapta.anamneseDesenvolvimentoSocioEmocional.class);
            startActivity(intent);
        }
    }
}