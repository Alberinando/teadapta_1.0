package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
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

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class anamnese extends AppCompatActivity {

    private String selectedDate = "";
    private AutoCompleteTextView escolha, escolaridade, escolar;


    private TextInputEditText outlinedTextField,textdata,textIdade,Field,altura;
    private TextInputEditText editTextNome, editTextData,editTextIdade,editTextFi,editTextAltura;
    //private Spinner escolar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese);

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




        TextInputEditText dataEditText = findViewById(R.id.data);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            dataEditText.setTextCursorDrawable(R.drawable.custom_cursor);
        }

        // Configurar o seletor de data quando o campo de data for clicado
        dataEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

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

    public void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // Aqui você pode lidar com a data selecionada pelo usuário
                // Por exemplo, atualizar o campo de data com a data selecionada
                selectedDate = String.format("%02d/%02d/%04d", dayOfMonth, month + 1, year);
                TextInputEditText dataEditText = findViewById(R.id.data);
                dataEditText.setText(selectedDate);
            }
        }, year, month, dayOfMonth);

        datePickerDialog.show();
    }

    public void submit(View view) {
        // Obtém o nome do aplicativo que o usuário digitou
        String nome = editTextNome.getText().toString().trim();
        String data = editTextData.getText().toString().trim();
        String idade = editTextIdade.getText().toString().trim();
        String fi = editTextFi.getText().toString().trim();
        String altura = editTextAltura.getText().toString().trim();


        String escolars = escolar.getText().toString().trim();
        String escolaridades = escolaridade.getText().toString().trim();
        String escolhas = escolha.getText().toString().trim();


        // Verifica se o campo de nome está vazio ou se o AutoCompleteTextView não foi selecionado
        if(nome.isEmpty() || data.isEmpty() || idade.isEmpty() || fi.isEmpty() || altura.isEmpty()){

            if(nome.isEmpty()){
                if(nome.isEmpty() && data.isEmpty()){
                    if(nome.isEmpty() && data.isEmpty() && idade.isEmpty()){
                        if(nome.isEmpty() && data.isEmpty() && idade.isEmpty() && fi.isEmpty()){
                            if(nome.isEmpty() && data.isEmpty() && idade.isEmpty() && fi.isEmpty() && altura.isEmpty()){
                                editTextNome.setBackgroundResource(R.drawable.edittext_contorno);
                                editTextData.setBackgroundResource(R.drawable.edittext_contorno);
                                editTextIdade.setBackgroundResource(R.drawable.edittext_contorno);
                                editTextFi.setBackgroundResource(R.drawable.edittext_contorno);
                                editTextAltura.setBackgroundResource(R.drawable.edittext_contorno);
                            }
                            editTextNome.setBackgroundResource(R.drawable.edittext_contorno);
                            editTextData.setBackgroundResource(R.drawable.edittext_contorno);
                            editTextIdade.setBackgroundResource(R.drawable.edittext_contorno);
                            editTextFi.setBackgroundResource(R.drawable.edittext_contorno);
                        }
                        editTextNome.setBackgroundResource(R.drawable.edittext_contorno);
                        editTextData.setBackgroundResource(R.drawable.edittext_contorno);
                        editTextIdade.setBackgroundResource(R.drawable.edittext_contorno);
                    }
                    editTextNome.setBackgroundResource(R.drawable.edittext_contorno);
                    editTextData.setBackgroundResource(R.drawable.edittext_contorno);
                }
                editTextNome.setBackgroundResource(R.drawable.edittext_contorno);
            }

            

        }

        if(!escolars.equals("Particular") && !escolars.equals("Pública")) {
            if(!escolhas.equals("Sim") && !escolhas.equals("Não")){
                if(!escolaridades.equals("Educação infatil completo") && !escolaridades.equals("Educação infatil incompleto")
                        && !escolaridades.equals("Ensino fundamental completo") && !escolaridades.equals("Ensino fundamental incompleto")
                && !escolaridades.equals("Ensino médio completo") && !escolaridades.equals("Ensino médio incompleto")){
                    escolar.setBackgroundResource(R.drawable.edittext_contorno);
                    escolaridade.setBackgroundResource(R.drawable.edittext_contorno);
                    escolha.setBackgroundResource(R.drawable.edittext_contorno);
                }
                escolar.setBackgroundResource(R.drawable.edittext_contorno);
                escolha.setBackgroundResource(R.drawable.edittext_contorno);
            }
            escolar.setBackgroundResource(R.drawable.edittext_contorno);

        } else {
            // Se tudo estiver válido, avança para a próxima página
            Intent intent = new Intent(anamnese.this, anamnesePais.class);
            startActivity(intent);
        }
        //Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
    }

}
