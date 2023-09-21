package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import com.google.android.material.textfield.TextInputEditText;
import java.util.Calendar;

public class anamnese extends AppCompatActivity {

    private String selectedDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese);

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
