package com.example.teadapta;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class anamnese extends AppCompatActivity {




    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();


    private String selectedDate = "";

    private AutoCompleteTextView escolha, escolaridade, escolar;


    private TextInputEditText editTextNome, editTextIdade, editTextPeso,editTextAltura,editTextData;
  
    //private Spinner escolar;
/*
    public AutoCompleteTextView getEscolha() {
        return escolha;
    }

 */

    // Getters para as variáveis de texto
    public TextInputEditText getEditTextNome() {
        return editTextNome;
    }
    public TextInputEditText getEditTextData() {
        return editTextData;
    }

    public TextInputEditText getEditTextIdade() {
        return editTextIdade;
    }

    public TextInputEditText getEditTextPeso() {
        return editTextPeso;
    }

    public TextInputEditText getEditTextAltura() {
        return editTextAltura;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese);



        MaterialDatePicker<Long> datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Selecione a Data")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())  // Seleção inicial (pode ser alterada conforme necessário)
                .build();
        TextInputEditText dataEditText = findViewById(R.id.data);
        TextInputLayout textInputLayout = findViewById(R.id.textdata);



        dataEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // Abre o calendário quando o campo recebe foco
                    datePicker.show(getSupportFragmentManager(), "DatePickerTag");

                    // Limpa qualquer mensagem de erro que possa estar sendo exibida
                    textInputLayout.setError(null);
                }
            }
        });
        dataEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abre o calendário quando o usuário clica no campo de texto
                datePicker.show(getSupportFragmentManager(), "DatePickerTag");

                // Limpa qualquer mensagem de erro que possa estar sendo exibida
                textInputLayout.setError(null);
            }
        });

        datePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
            @Override
            public void onPositiveButtonClick(Long selection) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(selection);
                calendar.add(Calendar.DAY_OF_MONTH, 1);

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                String selectedDateFormatted = sdf.format(calendar.getTime());

                TextInputEditText dataEditText = findViewById(R.id.data);
                dataEditText.setText(selectedDateFormatted);
            }
        });

        datePicker.addOnNegativeButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ação a ser realizada quando o usuário clica no botão "Cancelar"
                TextInputLayout textInputLayout = findViewById(R.id.textdata);
                String selectedDate = dataEditText.getText().toString().trim();

                if (selectedDate.isEmpty()) {
                    textInputLayout.setError("Campo obrigatório");
                } else {
                    textInputLayout.setError(null);
                }
            }
        });

        datePicker.addOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                // Ação a ser realizada quando o usuário cancela a seleção
                TextInputLayout textInputLayout = findViewById(R.id.textdata);
                String selectedDate2 = dataEditText.getText().toString().trim();
                if (selectedDate2.isEmpty()) {
                    textInputLayout.setError("Campo obrigatório");
                } else {
                    textInputLayout.setError(null);
                }
            }
        });
        escolha = findViewById(R.id.escolha);
        escolha = findViewById(R.id.escolha);
        escolaridade = findViewById(R.id.escolaridade);
        escolar = findViewById(R.id.escolar);

        editTextNome = findViewById(R.id.input);
        editTextData = findViewById(R.id.data);
        editTextIdade = findViewById(R.id.Idade);
        editTextPeso = findViewById(R.id.Fields);
        editTextAltura = findViewById(R.id.altura2);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            dataEditText.setTextCursorDrawable(R.drawable.custom_cursor);
        }

        //Escolha de Sim ou Não
        String[] listaEscolha = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha);
        escolha.setAdapter(adapterEscolha);

        //Escolha da Escolaridade
        String[] listaEscolaridade = getResources().getStringArray(R.array.Escolaridade_infantil);
        ArrayAdapter<String> adapterEscolhaEscolaridade = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolaridade);
        escolaridade.setAdapter(adapterEscolhaEscolaridade);

        //Escolha da Escola
        String[] listaEscola = getResources().getStringArray(R.array.Escola);
        ArrayAdapter<String> adapterEscolhaEscola = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscola);
        escolar.setAdapter(adapterEscolhaEscola);






    }



    private boolean validateFields() {
        boolean valid = true;

        TextInputLayout nomesLayout = findViewById(R.id.outlinedTextField);
        TextInputLayout idadeLayout = findViewById(R.id.textIdade);
        TextInputLayout pesoLayout = findViewById(R.id.Field);
        TextInputLayout alturaLayout = findViewById(R.id.altura);

        String escolhaFilhoUnico = escolha.getText().toString();
        String escolhaEscolaridade = escolaridade.getText().toString();
        String escolhaEscolar = escolar.getText().toString();


        TextInputLayout escolaLayout = findViewById(R.id.InputLayout);
        TextInputLayout escolaridadeLayout = findViewById(R.id.Input);
        TextInputLayout escolarLayout = findViewById(R.id.InputEscola);


        int errorColor = ContextCompat.getColor(this, R.color.error_color);
        int errorIconColor = ContextCompat.getColor(this, R.color.error_icon_color);

        editTextNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}   // Nada a fazer antes da mudança de texto
            
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                nomesLayout.setError(null); // Remove a mensagem de erro
                nomesLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                nomesLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                nomesLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        if (editTextNome.getText().toString().trim().isEmpty()) {
            if (!editTextNome.isFocused()) {
                nomesLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                nomesLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                nomesLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                nomesLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            nomesLayout.setError(null);
        }
        editTextIdade.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                idadeLayout.setError(null); // Remove a mensagem de erro
                idadeLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                idadeLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                idadeLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        if (editTextIdade.getText().toString().trim().isEmpty()) {
            if (!editTextIdade.isFocused()) {
                idadeLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                idadeLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                idadeLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                idadeLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            idadeLayout.setError(null);
        }
        editTextPeso.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                pesoLayout.setError(null); // Remove a mensagem de erro
                pesoLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                pesoLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                pesoLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        if (editTextPeso.getText().toString().trim().isEmpty()) {
            if (!editTextPeso.isFocused()) {
                pesoLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                pesoLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                pesoLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                pesoLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            pesoLayout.setError(null);
        }
        editTextAltura.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                alturaLayout.setError(null); // Remove a mensagem de erro
                alturaLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                alturaLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                alturaLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        if (editTextAltura.getText().toString().trim().isEmpty()) {
            if (!editTextAltura.isFocused()) {
                alturaLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                alturaLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                alturaLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                alturaLayout.setError("Campo vazio");


            }
            valid = false;
        } else {
            alturaLayout.setError(null);

        }
        escolha.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                escolaLayout.setError(null); // Remove a mensagem de erro
                escolaLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                escolaLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                escolaLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaFilhoUnico.equals("Selecionar"))
        {
            escolaLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            escolaLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            escolaLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            escolaLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            escolaLayout.setError(null);

        }


        escolaridade.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                escolaridadeLayout.setError(null); // Remove a mensagem de erro
                escolaridadeLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                escolaridadeLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                escolaridadeLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaEscolaridade.equals("Selecionar"))
        {
            escolaridadeLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            escolaridadeLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            escolaridadeLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            escolaridadeLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            escolaridadeLayout.setError(null);

        }


        escolar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                escolarLayout.setError(null); // Remove a mensagem de erro
                escolarLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                escolarLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                escolarLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaEscolar.equals("Selecionar"))
        {
            escolarLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            escolarLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            escolarLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            escolarLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            escolarLayout.setError(null);

        }


        return valid;
    }

    private void gravaDados()
    {
        // Obtém os valores dos campos de entrada
        String nome = editTextNome.getText().toString().trim();
        String data = editTextData.getText().toString().trim();
        int idade = Integer.parseInt(editTextIdade.getText().toString().trim());
        double peso = Double.parseDouble(editTextPeso.getText().toString().trim());
        double altura = Double.parseDouble(editTextAltura.getText().toString().trim());
        String escolhaValue = escolha.getText().toString(); // Valor do primeiro AutoCompleteTextView
        String escolaridadeValue = escolaridade.getText().toString(); // Valor do segundo AutoCompleteTextView
        String escolarValue = escolar.getText().toString();

        DadosCompartilhados dadosCompartilhados = DadosCompartilhados.getInstance();
        dadosCompartilhados.setNome(nome);
        dadosCompartilhados.setIdade(idade);
        dadosCompartilhados.setPeso(peso);
        dadosCompartilhados.setAltura(altura);
        dadosCompartilhados.setData(data);

        dadosCompartilhados.setEscolhaValue(escolhaValue);
        dadosCompartilhados.setEscolaridadeValue(escolaridadeValue);
        dadosCompartilhados.setEscolarValue(escolarValue);

        Intent intent = new Intent(anamnese.this, anamnesePais.class);
        startActivity(intent);

    }

    public void submit(View view) {
        if (validateFields()) {
            gravaDados();
        }
    }

}
//Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();