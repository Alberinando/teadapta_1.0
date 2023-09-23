package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class anamneseDesenvolvimentoCrianca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese_desenvolvimento_crianca);
        RadioButton radioDestro = findViewById(R.id.radioDestro);
        RadioButton radioCanhoto = findViewById(R.id.radioCanhoto);

        radioDestro.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#000000")));
        radioCanhoto.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#000000")));

    }
    public void Back (View view){
        Intent intent = new Intent(anamneseDesenvolvimentoCrianca.this, com.example.teadapta.anamneseDesenvolvimento.class);
        startActivity(intent);
    }

    public void submit (View view){
        Intent intent = new Intent(anamneseDesenvolvimentoCrianca.this, com.example.teadapta.anamneseDesenvolvimentoCrianca.class);
        startActivity(intent);
    }
}