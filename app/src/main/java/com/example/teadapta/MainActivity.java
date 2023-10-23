package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.ktx.Firebase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submit (View view){
        Intent intent = new Intent(MainActivity.this, com.example.teadapta.Conhecendo_tea.class);
        startActivity(intent);
    }
    public void submit2 (View view){
        Intent intent = new Intent(MainActivity.this, com.example.teadapta.anamnese.class);
        startActivity(intent);
    }
    public void submit4 (View view){
        Intent intent = new Intent(MainActivity.this, com.example.teadapta.direcionamento.class);
        startActivity(intent);
    }
    public void submit5 (View view){
        Intent intent = new Intent(MainActivity.this, com.example.teadapta.ficha_de_acompanhamento.class);
        startActivity(intent);
    }
}