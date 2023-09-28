package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class direcionamento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direcionamento);
    }
    public void submit (View view){
        Intent intent = new Intent(direcionamento.this, com.example.teadapta.CamposDeExperiencia.class);
        startActivity(intent);
    }
    public void submit2 (View view){
        Intent intent = new Intent(direcionamento.this, com.example.teadapta.MetasDeApredizagem.class);
        startActivity(intent);
    }
}