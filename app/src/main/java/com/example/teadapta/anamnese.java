package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class anamnese extends AppCompatActivity {

    private String selectedDate = "";

    private AutoCompleteTextView escolha, escolaridade, escolar;


    private TextInputEditText editTextNome, editTextData,editTextIdade,editTextFi,editTextAltura;
    //private Spinner escolar;

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
        escolaridade = findViewById(R.id.escolaridade);
        escolar = findViewById(R.id.escolar);

        editTextNome = findViewById(R.id.input);
        editTextData = findViewById(R.id.data);
        editTextIdade = findViewById(R.id.Idade);
        editTextFi = findViewById(R.id.MyTextInputEditText);
        editTextAltura = findViewById(R.id.MyTextInputEditText);

        // outlinedTextField = findViewById(R.id.outlinedTextField);
        /* 
        TextInputLayout outlinedTextField = findViewById(R.id.outlinedTextField);
        editTextNome = (TextInputEditText) outlinedTextField.getEditText();

        TextInputLayout textdata = findViewById(R.id.textdata);
        editTextData = (TextInputEditText) textdata.getEditText();

        TextInputLayout textIdade = findViewById(R.id.textIdade);
        editTextIdade = (TextInputEditText) textIdade.getEditText();

        TextInputLayout Field = findViewById(R.id.Field);
        editTextFi = (TextInputEditText) Field.getEditText();

        TextInputLayout altura = findViewById(R.id.altura);
        editTextAltura = (TextInputEditText) altura.getEditText();
        */
        //...................................................................


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
        TextInputLayout inputLayout = findViewById(R.id.outlinedTextField);
        TextInputLayout dataLayout = findViewById(R.id.textdata);
        TextInputLayout idadeLayout = findViewById(R.id.textIdade);
        TextInputLayout MyTextInputEditTextLayout = findViewById(R.id.Field);
        TextInputLayout MyTextInputEditTextLayout= findViewById(R.id.altura);
        AutoCompleteTextView escolhaLayout = findViewById(R.id.InputLayout);
        AutoCompleteTextView escolaridadeLayout = findViewById(R.id.Input);
        AutoCompleteTextView escolarLayout = findViewById(R.id.InputEscola);
        int errorColor = ContextCompat.getColor(this, R.color.error_color);
        int errorIconColor = ContextCompat.getColor(this, R.color.error_icon_color);

        // Ouvinte de texto para inputEditText
        //editTextNome, editTextData,editTextIdade,editTextFi,editTextAltura
        //escolha, escolaridade, escolar
        editTextNome.addTextChangedListener(new TextWatcher() {
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

        // Ouvinte de texto para dataEditText
        editTextData.addTextChangedListener(new TextWatcher() {
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
        editTextIdade.addTextChangedListener(new TextWatcher() {
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
        editTextFi.addTextChangedListener(new TextWatcher() {
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
        editTextAltura.addTextChangedListener(new TextWatcher() {
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
        escolha.addTextChangedListener(new TextWatcher() {
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
        escolaridade.addTextChangedListener(new TextWatcher() {
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
        escolar.addTextChangedListener(new TextWatcher() {
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

        if (editTextNome.getText().toString().trim().isEmpty()) {
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

        if (editTextData.getText().toString().trim().isEmpty()) {
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
        if (editTextIdade.getText().toString().trim().isEmpty()) {
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
        if (editTextFi.getText().toString().trim().isEmpty()) {
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
        if (editTextAltura.getText().toString().trim().isEmpty()) {
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

        return valid;
    }

    public void submit(View view) {
      
        if (validateFields()) {
            // Se tudo estiver válido, avança para a próxima página
            Intent intent = new Intent(anamnese.this, anamnesePais.class);
            startActivity(intent);
        }
    }

}
//Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();