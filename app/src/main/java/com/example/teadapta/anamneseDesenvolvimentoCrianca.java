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
import android.widget.RadioButton;
import android.widget.RadioGroup;


import android.util.Log;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.xmlpull.v1.XmlPullParser;

public class anamneseDesenvolvimentoCrianca extends AppCompatActivity {

    private AutoCompleteTextView escolha, escolha2,escolha3,escolha4,escolha5,escolha6,escolha7, escolha8;
    private String escolhaAMao = "";
    private XmlPullParser radioDestro;
    private View escolhaDestroLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese_desenvolvimento_crianca);
        escolha = findViewById(R.id.escolha);
        escolha2 = findViewById(R.id.escolha2);
        escolha3 = findViewById(R.id.escolha3);
        escolha4 = findViewById(R.id.escolha4);
        escolha5 = findViewById(R.id.escolha5);
        escolha6 = findViewById(R.id.escolha6);
        escolha7 = findViewById(R.id.escolha7);
        escolha8 = findViewById(R.id.escolha8);

        AutoCompleteTextView escolha = findViewById(R.id.escolha);
        AutoCompleteTextView escolha2 = findViewById(R.id.escolha2);
        AutoCompleteTextView escolha3 = findViewById(R.id.escolha3);
        AutoCompleteTextView escolha4 = findViewById(R.id.escolha4);
        AutoCompleteTextView escolha5 = findViewById(R.id.escolha5);
        AutoCompleteTextView escolha6 = findViewById(R.id.escolha6);
        AutoCompleteTextView escolha7 = findViewById(R.id.escolha7);
        AutoCompleteTextView escolha_8 = findViewById(R.id.escolha8);




        RadioButton radioDestro = findViewById(R.id.radioDestro);
        RadioButton radioCanhoto = findViewById(R.id.radioCanhoto);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioDestro) {
                    escolhaAMao = "destro";
                } else if (checkedId == R.id.radioCanhoto) {
                    escolhaAMao = "canhoto";
                }
            }
        });








        radioDestro.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#000000")));
        radioCanhoto.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#000000")));

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
        escolha_8.setAdapter(adapterEscolha8);
    }
    public void Back (View view){
        super.onBackPressed();
    }


    private boolean validateFields()
    {
        boolean valid = true;

        String escolhaUsoDasMãos = escolha.getText().toString();
        String escolhaCoordenacaoMotora = escolha2.getText().toString();
        String escolhaCaiFrequentemente = escolha3.getText().toString();
        String escolhaApanhaObjetosSemDificuldade = escolha4.getText().toString();
        String escolhaImitaGestos = escolha5.getText().toString();
        String escolhaArremessaObjetoSemDificuldade = escolha6.getText().toString();
        String escolhaSeguraObjetoSemDificuldade = escolha7.getText().toString();
        String escolhaFormasParticularesOrganizacao = escolha8.getText().toString();

        TextInputLayout escolhaDestroCanhotoLayout = findViewById(R.id.TextInpuLayouts);

      //  escolhaDestroLayout = findViewById(R.id.radioDestro);


        TextInputLayout usoDasMãosLayout = findViewById(R.id.InputLayout);
        TextInputLayout coordenacaoMotoraLayout = findViewById(R.id.InputLayout2);
        TextInputLayout caiFrequentementeLayout = findViewById(R.id.InputLayout3);
        TextInputLayout apanhaObjetosSemDificuldadeLayout = findViewById(R.id.InputLayout4);
        TextInputLayout imitaGestosLayout = findViewById(R.id.InputLayout5);
        TextInputLayout arremessaObjetoSemDificuldadeLayout = findViewById(R.id.InputLayout6);
        TextInputLayout seguraObjetoSemDificuldadeLayout = findViewById(R.id.InputLayout7);
        TextInputLayout formasParticularesOrganizacaoLayout = findViewById(R.id.InputLayout8);

        int errorColor = ContextCompat.getColor(this, R.color.error_color);
        int errorIconColor = ContextCompat.getColor(this, R.color.error_icon_color);



        if (escolhaAMao.equals("")) {
            escolhaDestroCanhotoLayout.setBackgroundResource(R.drawable.contorno_vermelho);
           // escolhaDestroLayout.setBackgroundResource(R.drawable.contorno_vermelho);
            valid = false;
        } else {
            escolhaDestroCanhotoLayout.setBackgroundResource(R.drawable.contorno);
        }
        escolha.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                usoDasMãosLayout.setError(null); // Remove a mensagem de erro
                usoDasMãosLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                usoDasMãosLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                usoDasMãosLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaUsoDasMãos.equals("Selecionar"))
        {
            usoDasMãosLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            usoDasMãosLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            usoDasMãosLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            usoDasMãosLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            usoDasMãosLayout.setError(null);

        }

        escolha2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                coordenacaoMotoraLayout.setError(null); // Remove a mensagem de erro
                coordenacaoMotoraLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                coordenacaoMotoraLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                coordenacaoMotoraLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaCoordenacaoMotora.equals("Selecionar"))
        {
            coordenacaoMotoraLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            coordenacaoMotoraLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            coordenacaoMotoraLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            coordenacaoMotoraLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            coordenacaoMotoraLayout.setError(null);

        }

        escolha3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                caiFrequentementeLayout.setError(null); // Remove a mensagem de erro
                caiFrequentementeLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                caiFrequentementeLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                caiFrequentementeLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaCaiFrequentemente.equals("Selecionar"))
        {
            caiFrequentementeLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            caiFrequentementeLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            caiFrequentementeLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            caiFrequentementeLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            caiFrequentementeLayout.setError(null);

        }

        escolha4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                apanhaObjetosSemDificuldadeLayout.setError(null); // Remove a mensagem de erro
                apanhaObjetosSemDificuldadeLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                apanhaObjetosSemDificuldadeLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                apanhaObjetosSemDificuldadeLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaApanhaObjetosSemDificuldade.equals("Selecionar"))
        {
            apanhaObjetosSemDificuldadeLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            apanhaObjetosSemDificuldadeLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            apanhaObjetosSemDificuldadeLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            apanhaObjetosSemDificuldadeLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            apanhaObjetosSemDificuldadeLayout.setError(null);

        }

        escolha5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                imitaGestosLayout.setError(null); // Remove a mensagem de erro
                imitaGestosLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                imitaGestosLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                imitaGestosLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaImitaGestos.equals("Selecionar"))
        {
            imitaGestosLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            imitaGestosLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            imitaGestosLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            imitaGestosLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            imitaGestosLayout.setError(null);

        }

        escolha6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                arremessaObjetoSemDificuldadeLayout.setError(null); // Remove a mensagem de erro
                arremessaObjetoSemDificuldadeLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                arremessaObjetoSemDificuldadeLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                arremessaObjetoSemDificuldadeLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaArremessaObjetoSemDificuldade.equals("Selecionar"))
        {
            arremessaObjetoSemDificuldadeLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            arremessaObjetoSemDificuldadeLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            arremessaObjetoSemDificuldadeLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            arremessaObjetoSemDificuldadeLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            arremessaObjetoSemDificuldadeLayout.setError(null);

        }

        escolha7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                seguraObjetoSemDificuldadeLayout.setError(null); // Remove a mensagem de erro
                seguraObjetoSemDificuldadeLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                seguraObjetoSemDificuldadeLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                seguraObjetoSemDificuldadeLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaSeguraObjetoSemDificuldade.equals("Selecionar"))
        {
            seguraObjetoSemDificuldadeLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            seguraObjetoSemDificuldadeLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            seguraObjetoSemDificuldadeLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            seguraObjetoSemDificuldadeLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            seguraObjetoSemDificuldadeLayout.setError(null);

        }

        escolha8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                formasParticularesOrganizacaoLayout.setError(null); // Remove a mensagem de erro
                formasParticularesOrganizacaoLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                formasParticularesOrganizacaoLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                formasParticularesOrganizacaoLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaFormasParticularesOrganizacao.equals("Selecionar"))
        {
            formasParticularesOrganizacaoLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            formasParticularesOrganizacaoLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            formasParticularesOrganizacaoLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            formasParticularesOrganizacaoLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            formasParticularesOrganizacaoLayout.setError(null);

        }

        return valid;
    }



    public void submit (View view){
        if(validateFields())
        {

            String usoDuasMaos = escolha.getText().toString();
            String dificuldadeCordenacao= escolha2.getText().toString();
            String caiComFrequencia = escolha3.getText().toString();
            String  apanhaObjetosSemDiculdade= escolha4.getText().toString();
            String imitaGestosSimples= escolha5.getText().toString();
            String arremessaObjetosSemDiculdade = escolha6.getText().toString();
            String seguraObjetosSemDiculdade = escolha7.getText().toString();
            String formasPeculiaresDeOrganizacaoMotora = escolha8.getText().toString();
            escolhaAMao = escolhaAMao;

            DadosCompartilhados dadosCompartilhados = DadosCompartilhados.getInstance();
            dadosCompartilhados.setUsoDuasMaos (usoDuasMaos);
            dadosCompartilhados.setDificuldadeCordenacao(dificuldadeCordenacao);
            dadosCompartilhados.setCaiComFrequencia(caiComFrequencia);
            dadosCompartilhados.setApanhaObjetosSemDiculdade(apanhaObjetosSemDiculdade);
            dadosCompartilhados.setImitaGestosSimples(imitaGestosSimples);
            dadosCompartilhados.setArremessaObjetosSemDiculdade(arremessaObjetosSemDiculdade);
            dadosCompartilhados.setSeguraObjetosSemDiculdade(seguraObjetosSemDiculdade);
            dadosCompartilhados.setFormasPeculiaresDeOrganizacaoMotora(formasPeculiaresDeOrganizacaoMotora);
            dadosCompartilhados.setEscolhaAMao(escolhaAMao);



            Intent intent = new Intent(anamneseDesenvolvimentoCrianca.this, com.example.teadapta.anamneseDesenvolvimentoLinguistico.class);
            startActivity(intent);
        }

    }
}