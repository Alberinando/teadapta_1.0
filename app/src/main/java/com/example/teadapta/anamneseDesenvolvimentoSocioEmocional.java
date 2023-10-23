package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.assist.AssistStructure;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.xmlpull.v1.XmlPullParser;

public class anamneseDesenvolvimentoSocioEmocional extends AppCompatActivity {

    private AutoCompleteTextView escolha,escolha2,escolha3,escolha4,escolha5,escolha6,escolha7,escolha8,escolha9,
            escolha00,escolha01;

    private TextInputEditText editTextEscolhaOpcao;


   // private AutoCompleteTextView escolhaCaracteristica;

    private String comportamentoDoFilho="";
    private CheckBox checkBoxSelecionado;

    private CheckBox destraidoCheckBox;
    private CheckBox hiperativoCheckBox;
    private CheckBox sensivelVibracoesCheckBox;
    private CheckBox sensivelQuandoTocadoCheckBox;
    private CheckBox calmoCheckBox;
    private CheckBox nervosoCheckBox;
    private CheckBox desinteressadoCheckBox;


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

        editTextEscolhaOpcao = findViewById(R.id.titulo);




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
        TextInputLayout comportamentoDoFilhoLayout = findViewById(R.id.checkBoxGroup);



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
                comportamentoDoFilhoLayout.setBackgroundResource(R.drawable.contorno);
            }
            else
            {
                comportamentoDoFilhoLayout.setBackgroundResource(R.drawable.contorno_vermelho);
                comportamentoDoFilho ="";
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
                comportamentoDoFilhoLayout.setBackgroundResource(R.drawable.contorno);
            }
            else
            {
                comportamentoDoFilhoLayout.setBackgroundResource(R.drawable.contorno_vermelho);
                comportamentoDoFilho ="";
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
                comportamentoDoFilhoLayout.setBackgroundResource(R.drawable.contorno);
            }
            else
            {
                comportamentoDoFilhoLayout.setBackgroundResource(R.drawable.contorno_vermelho);
                comportamentoDoFilho ="";
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
                comportamentoDoFilhoLayout.setBackgroundResource(R.drawable.contorno);
            }
            else
            {
                comportamentoDoFilhoLayout.setBackgroundResource(R.drawable.contorno_vermelho);
                comportamentoDoFilho ="";
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
                comportamentoDoFilhoLayout.setBackgroundResource(R.drawable.contorno);

            }
            else
            {
                comportamentoDoFilhoLayout.setBackgroundResource(R.drawable.contorno_vermelho);
                comportamentoDoFilho ="";
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
                comportamentoDoFilhoLayout.setBackgroundResource(R.drawable.contorno);
            }
            else
            {
                comportamentoDoFilhoLayout.setBackgroundResource(R.drawable.contorno_vermelho);
                comportamentoDoFilho ="";
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
                comportamentoDoFilhoLayout.setBackgroundResource(R.drawable.contorno);

            }
            else
            {
                comportamentoDoFilhoLayout.setBackgroundResource(R.drawable.contorno_vermelho);
                comportamentoDoFilho ="";
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

    private boolean validateFields()
    {
        boolean valid = true;

        TextInputLayout regePessoasLayout = findViewById(R.id.InputLayout);
        TextInputLayout brincarCirancasLayout = findViewById(R.id.InputLayout2);
        TextInputLayout expressaNecessidadesLayout = findViewById(R.id.InputLayout3);
        TextInputLayout apresentaBirrasLayout = findViewById(R.id.InputLayout4);
        TextInputLayout seAdaptaBemLayout = findViewById(R.id.InputLayout5);
        TextInputLayout choraFrequenciaLayout = findViewById(R.id.InputLayout6);
        TextInputLayout fazAmigosFrequenciaLayout = findViewById(R.id.InputLayout7);
        TextInputLayout expressaEmocoesFacilidadeLayout = findViewById(R.id.InputLayout8);
        TextInputLayout mudaComportamentoComEstranhoLayout = findViewById(R.id.InputLayout9);
        TextInputLayout reageFavoravelmenteNovidadeLayout = findViewById(R.id.InputLayout00);
        TextInputLayout procuraProtecaoPaisLayout = findViewById(R.id.InputLayout01);

        TextInputLayout editTextEscolhaOpcaoLayout = findViewById(R.id.checkBoxGroup);


       // nx = findViewById(R.id.checkBoxGroup);



        String escolhaRegePessoas = escolha.getText().toString();
        String escolhaBrincarCirancas = escolha2.getText().toString();
        String escolhaExpressaNecessidades = escolha3.getText().toString();
        String escolhaApresentaBirras = escolha4.getText().toString();
        String escolhaSeAdaptaBem = escolha5.getText().toString();
        String escolhaChoraFrequencia = escolha6.getText().toString();
        String escolhaFazAmigosFrequencia = escolha7.getText().toString();
        String escolhaExpressaEmocoesFacilidade = escolha8.getText().toString();
        String escolhaMudaComportamentoComEstranho = escolha9.getText().toString();
        String escolhaReageFavoravelmenteNovidade = escolha00.getText().toString();
        String escolhaProcuraProtecaoPais = escolha01.getText().toString();

       // String bhx = editTextEscolhaOpcao.getText().toString();

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
                regePessoasLayout.setError(null); // Remove a mensagem de erro
                regePessoasLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                regePessoasLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                regePessoasLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaRegePessoas.equals("Selecionar"))
        {
            regePessoasLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            regePessoasLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            regePessoasLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            regePessoasLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            regePessoasLayout.setError(null);

        }

      //***************************************************************************************

        if (comportamentoDoFilho.isEmpty()) {
            editTextEscolhaOpcaoLayout.setBackgroundResource(R.drawable.contorno_vermelho);
            valid = false;
        } else {
            editTextEscolhaOpcaoLayout.setBackgroundResource(R.drawable.contorno);
        }


        escolha2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                brincarCirancasLayout.setError(null); // Remove a mensagem de erro
                brincarCirancasLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                brincarCirancasLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                brincarCirancasLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaBrincarCirancas.equals("Selecionar"))
        {
            brincarCirancasLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            brincarCirancasLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            brincarCirancasLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            brincarCirancasLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            brincarCirancasLayout.setError(null);

        }

        escolha3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                expressaNecessidadesLayout.setError(null); // Remove a mensagem de erro
                expressaNecessidadesLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                expressaNecessidadesLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                expressaNecessidadesLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaExpressaNecessidades.equals("Selecionar"))
        {
            expressaNecessidadesLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            expressaNecessidadesLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            expressaNecessidadesLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            expressaNecessidadesLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            expressaNecessidadesLayout.setError(null);

        }

        escolha4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                apresentaBirrasLayout.setError(null); // Remove a mensagem de erro
                apresentaBirrasLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                apresentaBirrasLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                apresentaBirrasLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaApresentaBirras.equals("Selecionar"))
        {
            apresentaBirrasLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            apresentaBirrasLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            apresentaBirrasLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            apresentaBirrasLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            apresentaBirrasLayout.setError(null);

        }

        escolha5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                seAdaptaBemLayout.setError(null); // Remove a mensagem de erro
                seAdaptaBemLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                seAdaptaBemLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                seAdaptaBemLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaSeAdaptaBem.equals("Selecionar"))
        {
            seAdaptaBemLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            seAdaptaBemLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            seAdaptaBemLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            seAdaptaBemLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            seAdaptaBemLayout.setError(null);

        }

        escolha6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                choraFrequenciaLayout.setError(null); // Remove a mensagem de erro
                choraFrequenciaLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                choraFrequenciaLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                choraFrequenciaLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaChoraFrequencia.equals("Selecionar"))
        {
            choraFrequenciaLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            choraFrequenciaLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            choraFrequenciaLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            choraFrequenciaLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            choraFrequenciaLayout.setError(null);

        }

        escolha7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                fazAmigosFrequenciaLayout.setError(null); // Remove a mensagem de erro
                fazAmigosFrequenciaLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                fazAmigosFrequenciaLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                fazAmigosFrequenciaLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaFazAmigosFrequencia.equals("Selecionar"))
        {
            fazAmigosFrequenciaLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            fazAmigosFrequenciaLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            fazAmigosFrequenciaLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            fazAmigosFrequenciaLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            fazAmigosFrequenciaLayout.setError(null);

        }

        escolha8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                expressaEmocoesFacilidadeLayout.setError(null); // Remove a mensagem de erro
                expressaEmocoesFacilidadeLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                expressaEmocoesFacilidadeLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                expressaEmocoesFacilidadeLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaExpressaEmocoesFacilidade.equals("Selecionar"))
        {
            expressaEmocoesFacilidadeLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            expressaEmocoesFacilidadeLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            expressaEmocoesFacilidadeLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            expressaEmocoesFacilidadeLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            expressaEmocoesFacilidadeLayout.setError(null);

        }

        escolha9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                mudaComportamentoComEstranhoLayout.setError(null); // Remove a mensagem de erro
                mudaComportamentoComEstranhoLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                mudaComportamentoComEstranhoLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                mudaComportamentoComEstranhoLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaMudaComportamentoComEstranho.equals("Selecionar"))
        {
            mudaComportamentoComEstranhoLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            mudaComportamentoComEstranhoLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            mudaComportamentoComEstranhoLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            mudaComportamentoComEstranhoLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            mudaComportamentoComEstranhoLayout.setError(null);

        }

        escolha00.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                reageFavoravelmenteNovidadeLayout.setError(null); // Remove a mensagem de erro
                reageFavoravelmenteNovidadeLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                reageFavoravelmenteNovidadeLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                reageFavoravelmenteNovidadeLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaReageFavoravelmenteNovidade.equals("Selecionar"))
        {
            reageFavoravelmenteNovidadeLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            reageFavoravelmenteNovidadeLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            reageFavoravelmenteNovidadeLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            reageFavoravelmenteNovidadeLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            reageFavoravelmenteNovidadeLayout.setError(null);

        }

        escolha01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                procuraProtecaoPaisLayout.setError(null); // Remove a mensagem de erro
                procuraProtecaoPaisLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                procuraProtecaoPaisLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                procuraProtecaoPaisLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaProcuraProtecaoPais.equals("Selecionar"))
        {
            procuraProtecaoPaisLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            procuraProtecaoPaisLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            procuraProtecaoPaisLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            procuraProtecaoPaisLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            procuraProtecaoPaisLayout.setError(null);

        }

        return valid;
    }
    public void submit (View view){

        if (validateFields())
        {
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
}