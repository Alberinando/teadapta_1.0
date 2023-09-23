package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class anamneseDesenvolvimento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese_desenvolvimento);
    }
    public void Back (View view){
        Intent intent = new Intent(anamneseDesenvolvimento.this, com.example.teadapta.anamnesePais.class);
        startActivity(intent);
    }

    public void submit (View view){
        Intent intent = new Intent(anamneseDesenvolvimento.this, com.example.teadapta.anamneseDesenvolvimentoCrianca.class);
        startActivity(intent);
    }
}