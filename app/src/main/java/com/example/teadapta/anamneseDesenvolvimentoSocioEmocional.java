package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputLayout;

import org.xmlpull.v1.XmlPullParser;

public class anamneseDesenvolvimentoSocioEmocional extends AppCompatActivity {

    private AutoCompleteTextView escolha,escolha2,escolha3,escolha4,escolha5,escolha6,escolha7,escolha8,escolha9,
            escolha00,escolha01;

    private String comportamentoDoFilho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese_desenvolvimento_socio_emocional);

        escolha = findViewById(R.id.escolha);
        escolha2 = findViewById(R.id.escolha2);
        escolha3 = findViewById(R.id.escolha3);
        escolha4 = findViewById(R.id.escolha4);
        escolha5 = findViewById(R.id.escolha5);
        escolha6 = findViewById(R.id.escolha6);
         escolha7 = findViewById(R.id.escolha7);
        escolha8 = findViewById(R.id.escolha8);
        escolha9 = findViewById(R.id.escolha9);
        escolha00 = findViewById(R.id.escolha00);
        escolha01 = findViewById(R.id.escolha01);

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


        final CheckBox destraidoCheckBox = findViewById(R.id.distraido);
        final CheckBox hiperativoCheckBox = findViewById(R.id.hiperativo);
        final CheckBox sensivelVibracoesCheckBox = findViewById(R.id.sensivelVi);
        final CheckBox sensivelQuandoTocadoCheckBox = findViewById(R.id.sensivelTo);
        final CheckBox calmoCheckBox = findViewById(R.id.calmo);
        final CheckBox nervosoCheckBox = findViewById(R.id.nervoso);
        final CheckBox desinteressadoCheckBox = findViewById(R.id.desinteressado);



        // Adicione outros CheckBoxes aqui

        destraidoCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                comportamentoDoFilho = "Destraido";
                hiperativoCheckBox.setChecked(false);
                sensivelVibracoesCheckBox.setChecked(false);
                sensivelQuandoTocadoCheckBox.setChecked(false);
                calmoCheckBox.setChecked(false);
                nervosoCheckBox.setChecked(false);
                desinteressadoCheckBox.setChecked(false);
                // Desmarque os outros CheckBoxes aqui, se necessário
            }
        });

        hiperativoCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                comportamentoDoFilho = "Hiperativo";
                destraidoCheckBox.setChecked(false);
                sensivelVibracoesCheckBox.setChecked(false);
                sensivelQuandoTocadoCheckBox.setChecked(false);
                calmoCheckBox.setChecked(false);
                nervosoCheckBox.setChecked(false);
                desinteressadoCheckBox.setChecked(false);
            }
        });
        sensivelVibracoesCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                comportamentoDoFilho = "Sensível a sensação de vibração";
                destraidoCheckBox.setChecked(false);
                hiperativoCheckBox.setChecked(false);
                sensivelQuandoTocadoCheckBox.setChecked(false);
                calmoCheckBox.setChecked(false);
                nervosoCheckBox.setChecked(false);
                desinteressadoCheckBox.setChecked(false);
            }
        });

        sensivelQuandoTocadoCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                comportamentoDoFilho = "Sensível quando tocado";
                destraidoCheckBox.setChecked(false);
                hiperativoCheckBox.setChecked(false);
                sensivelVibracoesCheckBox.setChecked(false);
                calmoCheckBox.setChecked(false);
                nervosoCheckBox.setChecked(false);
                desinteressadoCheckBox.setChecked(false);
            }
        });
        calmoCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                comportamentoDoFilho = "Calmo";
                destraidoCheckBox.setChecked(false);
                hiperativoCheckBox.setChecked(false);
                sensivelVibracoesCheckBox.setChecked(false);
                sensivelQuandoTocadoCheckBox.setChecked(false);
                nervosoCheckBox.setChecked(false);
                desinteressadoCheckBox.setChecked(false);
            }
        });
        nervosoCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                comportamentoDoFilho = "Nervoso";
                destraidoCheckBox.setChecked(false);
                hiperativoCheckBox.setChecked(false);
                sensivelVibracoesCheckBox.setChecked(false);
                sensivelQuandoTocadoCheckBox.setChecked(false);
                calmoCheckBox.setChecked(false);
                desinteressadoCheckBox.setChecked(false);
            }
        });

        desinteressadoCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                comportamentoDoFilho = "Desinteressado";
                destraidoCheckBox.setChecked(false);
                hiperativoCheckBox.setChecked(false);
                sensivelVibracoesCheckBox.setChecked(false);
                sensivelQuandoTocadoCheckBox.setChecked(false);
                calmoCheckBox.setChecked(false);
                nervosoCheckBox.setChecked(false);

            }
        });





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
        super.onBackPressed();
    }
    public void submit (View view){

        String reageFavoravelmentePessoa = escolha.getText().toString();
        String brincaCriancaAdulto = escolha2.getText().toString();
        String expressaNecessidades = escolha3.getText().toString();
        String apresentaBirrasComFrequencia = escolha4.getText().toString();
        String seAdaptaCasaEscola = escolha5.getText().toString();
        String choraFrequencia = escolha6.getText().toString();
        String fazAmigosFacilidade = escolha7.getText().toString();
        String expressaEmocoesComFacilidade = escolha8.getText().toString();
        String mudaComportamentoComEstranho = escolha9.getText().toString();
        String reageFavoravelmenteNovidades = escolha00.getText().toString();
        String procuraProtecaoPais = escolha01.getText().toString();


        comportamentoDoFilho=comportamentoDoFilho;

        DadosCompartilhados dadosCompartilhados = DadosCompartilhados.getInstance();
        dadosCompartilhados.setReageFavoravelmentePessoa(reageFavoravelmentePessoa);
        dadosCompartilhados.setBrincaCriancaAdulto(brincaCriancaAdulto);
        dadosCompartilhados.setExpressaNecessidades(expressaNecessidades);

        dadosCompartilhados.setApresentaBirrasComFrequencia(apresentaBirrasComFrequencia);
        dadosCompartilhados.setSeAdaptaCasaEscola(seAdaptaCasaEscola);
        dadosCompartilhados.setChoraFrequencia(choraFrequencia);
        dadosCompartilhados.setFazAmigosFacilidade(fazAmigosFacilidade);
        dadosCompartilhados.setExpressaEmocoesComFacilidade(expressaEmocoesComFacilidade);
        dadosCompartilhados.setMudaComportamentoComEstranho(mudaComportamentoComEstranho);
        dadosCompartilhados.setReageFavoravelmenteNovidades(reageFavoravelmenteNovidades);
        dadosCompartilhados.setProcuraProtecaoPais(procuraProtecaoPais);

        dadosCompartilhados.setComportamentoDoFilho(comportamentoDoFilho);



        Intent intent = new Intent(anamneseDesenvolvimentoSocioEmocional.this, com.example.teadapta.anamneseDesenvolvimentoSocioEmocional2.class);
        startActivity(intent);
    }
}