package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Conhecendo_tea extends AppCompatActivity {
    private ImageView arrowIcon1;
    private boolean isArrowUp1 = false; // Estado inicial: seta para baixo

    private ImageView arrowIcon2;
    private boolean isArrowUp2 = false; // Estado inicial: seta para baixo

    private ImageView arrowIcon3;
    private boolean isArrowUp3 = false; // Estado inicial: seta para baixo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conhecendo_tea);

        arrowIcon1 = findViewById(R.id.arrowIcon1);
        arrowIcon2 = findViewById(R.id.arrowIcon2);
        arrowIcon3 = findViewById(R.id.arrowIcon4);
    }

    public void toggleArrow(View view) {
        // Alterne a rotação do ícone
        if (isArrowUp1) {
            arrowIcon1.setRotation(0); // Seta para baixo
        } else {
            arrowIcon1.setRotation(180); // Seta para cima
        }

        isArrowUp1 = !isArrowUp1; // Inverta o estado
    }

    // Método para manipular o primeiro conjunto replicado
    public void toggleText1(View view) {
        TextView textAdditional = findViewById(R.id.textAdditional1);
        ImageView arrowIcon = findViewById(R.id.arrowIcon1);

        // Verifique a visibilidade atual do texto adicional
        int visibility = textAdditional.getVisibility();

        // Alterne a visibilidade (VISIBLE -> GONE, GONE -> VISIBLE)
        if (visibility == View.VISIBLE) {
            textAdditional.setVisibility(View.GONE);
            toggleArrow(arrowIcon1);
        } else {
            textAdditional.setVisibility(View.VISIBLE);
            toggleArrow(arrowIcon1);
        }
    }

    public void toggleArrow2(View view) {
        // Alterne a rotação do ícone
        if (isArrowUp2) {
            arrowIcon2.setRotation(0); // Seta para baixo
        } else {
            arrowIcon2.setRotation(180); // Seta para cima
        }

        isArrowUp2 = !isArrowUp2; // Inverta o estado
    }

    // Método para manipular o segundp conjunto
    public void toggleText2(View view) {
        TextView textAdditional = findViewById(R.id.textAdditional2);
        ImageView arrowIcon = findViewById(R.id.arrowIcon2);

        // Verifique a visibilidade atual do texto adicional
        int visibility = textAdditional.getVisibility();

        // Alterne a visibilidade (VISIBLE -> GONE, GONE -> VISIBLE)
        if (visibility == View.VISIBLE) {
            textAdditional.setVisibility(View.GONE);
            toggleArrow2(arrowIcon2);
        } else {
            textAdditional.setVisibility(View.VISIBLE);
            toggleArrow2(arrowIcon2);
        }
    }

    public void toggleArrow3(View view) {
        // Alterne a rotação do ícone
        if (isArrowUp3) {
            arrowIcon3.setRotation(0); // Seta para baixo
        } else {
            arrowIcon3.setRotation(180); // Seta para cima
        }

        isArrowUp3 = !isArrowUp3; // Inverta o estado
    }

    // Método para manipular o segundp conjunto
    public void toggleText3(View view) {
        TextView textAdditional = findViewById(R.id.textAdditional3);
        ImageView arrowIcon = findViewById(R.id.arrowIcon4);

        // Verifique a visibilidade atual do texto adicional
        int visibility = textAdditional.getVisibility();

        // Alterne a visibilidade (VISIBLE -> GONE, GONE -> VISIBLE)
        if (visibility == View.VISIBLE) {
            textAdditional.setVisibility(View.GONE);
            toggleArrow3(arrowIcon3);
        } else {
            textAdditional.setVisibility(View.VISIBLE);
            toggleArrow3(arrowIcon3);
        }
    }
}