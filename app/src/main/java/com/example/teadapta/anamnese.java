package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import com.google.android.material.textfield.TextInputEditText;
import java.util.Calendar;

public class anamnese extends AppCompatActivity {

    private String selectedDate = "";
    private AutoCompleteTextView escolha, escolaridade, escolar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese);

        escolha = findViewById(R.id.escolha);
        escolaridade = findViewById(R.id.escolaridade);
        escolar = findViewById(R.id.escolar);

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

}
