package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import android.util.Log;
import android.widget.RadioGroup;

import org.xmlpull.v1.XmlPullParser;

public class anamneseDesenvolvimentoCrianca extends AppCompatActivity {

    private AutoCompleteTextView escolha, escolha2,escolha3,escolha4,escolha5,escolha6,escolha7, escolha8;
    private String escolhaAMao = "";
    private XmlPullParser radioDestro;


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

    public void submit (View view){

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