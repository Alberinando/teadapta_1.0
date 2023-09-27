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

        // outlinedTextField = findViewById(R.id.outlinedTextField);
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

    public void submit(View view) {
        // Obtém os valores dos campos de entrada
        String nome = editTextNome.getText().toString().trim();
        String data = editTextData.getText().toString().trim();
        String idade = editTextIdade.getText().toString().trim();
        String fi = editTextFi.getText().toString().trim();
        String altura = editTextAltura.getText().toString().trim();

        String escolars = escolar.getText().toString().trim();
        String escolaridades = escolaridade.getText().toString().trim();
        String escolhas = escolha.getText().toString().trim();

        boolean camposPreenchidosCorretamente = true;

        // Verifica se algum campo obrigatório não está preenchido corretamente
        if (nome.isEmpty()) {
            editTextNome.setBackgroundResource(R.drawable.edittext_contorno);
            camposPreenchidosCorretamente = false;
        }

        if (data.isEmpty()) {
            editTextData.setBackgroundResource(R.drawable.edittext_contorno);
            camposPreenchidosCorretamente = false;
        }
        if (idade.isEmpty()) {
            editTextIdade.setBackgroundResource(R.drawable.edittext_contorno);
            camposPreenchidosCorretamente = false;
        }

        if (fi.isEmpty()) {
            editTextFi.setBackgroundResource(R.drawable.edittext_contorno);
            camposPreenchidosCorretamente = false;
        }

        if (altura.isEmpty()) {
            editTextAltura.setBackgroundResource(R.drawable.edittext_contorno);
            camposPreenchidosCorretamente = false;
        }

        // Verifica se as escolhas são inválidas
        if (!escolars.equals("Particular") && !escolars.equals("Pública")) {
            escolar.setBackgroundResource(R.drawable.edittext_contorno);
            camposPreenchidosCorretamente = false;
        }

        if (!escolhas.equals("Sim") && !escolhas.equals("Não")) {
            escolha.setBackgroundResource(R.drawable.edittext_contorno);
            camposPreenchidosCorretamente = false;
        }

        if (!escolaridades.equals("Educação infantil completo") &&
                !escolaridades.equals("Educação infantil incompleto") &&
                !escolaridades.equals("Ensino fundamental completo") &&
                !escolaridades.equals("Ensino fundamental incompleto") &&
                !escolaridades.equals("Ensino médio completo") &&
                !escolaridades.equals("Ensino médio incompleto")) {
            escolaridade.setBackgroundResource(R.drawable.edittext_contorno);
            camposPreenchidosCorretamente = false;
        }

        // Verifica se todos os campos estão preenchidos corretamente
        if (camposPreenchidosCorretamente) {
            // Se tudo estiver válido, avança para a próxima página
            Intent intent = new Intent(anamnese.this, anamnesePais.class);
            startActivity(intent);
        }
    }

}
//Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();