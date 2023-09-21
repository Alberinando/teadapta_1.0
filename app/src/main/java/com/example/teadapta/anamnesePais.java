package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class anamnesePais extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese_pais);
    }

    public void submitBack (View view){
        Intent intent = new Intent(anamnesePais.this, com.example.teadapta.anamnese.class);
        startActivity(intent);
    }

    public void submit (View view){
        Intent intent = new Intent(anamnesePais.this, com.example.teadapta.anamnesePais.class);
        startActivity(intent);
    }
}