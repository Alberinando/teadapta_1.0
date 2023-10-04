package com.example.teadapta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class anamneseDesenvolvimentoExercicio extends AppCompatActivity {

    private AutoCompleteTextView escolha, escolha2, escolha3, escolha4;
    private TextInputLayout religiaoLayout, religiaoLayout2, religiaoLayout3, religiaoLayout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese_desenvolvimento_exercicio);
        escolha = findViewById(R.id.escolha);
        escolha2 = findViewById(R.id.escolha2);
        escolha3 = findViewById(R.id.escolha3);
        escolha4 = findViewById(R.id.escolha4);

        religiaoLayout = findViewById(R.id.TextField);
        religiaoLayout2 = findViewById(R.id.TextField2);
        religiaoLayout3 = findViewById(R.id.TextField3);
        religiaoLayout4 = findViewById(R.id.TextField4);

        String[] listaEscolha = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha);
        escolha.setAdapter(adapterEscolha);

        String[] listaEscolha2 = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha2 = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha2);
        escolha2.setAdapter(adapterEscolha2);

        String[] listaEscolha3 = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha3 = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha3);
        escolha3.setAdapter(adapterEscolha3);

        String[] listaEscolha4 = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha4 = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha4);
        escolha4.setAdapter(adapterEscolha4);
        escolha.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String escolhaValue = s.toString().trim();
                updateLayoutVisibility(escolhaValue, religiaoLayout);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        escolha2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String escolhaValue = s.toString().trim();
                updateLayoutVisibility2(escolhaValue, religiaoLayout2);
                updateLayoutVisibility3(escolhaValue, religiaoLayout3);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        escolha3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String escolhaValue = s.toString().trim();
                updateLayoutVisibility4(escolhaValue, religiaoLayout4);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        escolha2.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Chamado quando o texto é alterado
                String escolhaValue = s.toString().trim();

                // Obtenha uma referência ao TextInputLayout e TextInputEditText para o campo de checkout
                LinearLayout checkBoxGroup = findViewById(R.id.checkBoxGroup);


                if (escolhaValue.equals("Sim")) {
                    checkBoxGroup.setVisibility(View.VISIBLE);
                } else {
                    checkBoxGroup.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void updateLayoutVisibility(String escolhaValue, TextInputLayout layout) {
        if (escolhaValue.equalsIgnoreCase("Sim")) {
            layout.setVisibility(View.VISIBLE);
        } else {
            layout.setVisibility(View.GONE);
        }
    }

    private void updateLayoutVisibility2(String escolhaValue, TextInputLayout layout) {
        if (escolhaValue.equalsIgnoreCase("Sim")) {
            layout.setVisibility(View.VISIBLE);
        } else {
            layout.setVisibility(View.GONE);
        }
    }

    private void updateLayoutVisibility3(String escolhaValue, TextInputLayout layout) {
        if (escolhaValue.equalsIgnoreCase("Sim")) {
            layout.setVisibility(View.VISIBLE);
        } else {
            layout.setVisibility(View.GONE);
        }
    }

    private void updateLayoutVisibility4(String escolhaValue, TextInputLayout layout) {
        if (escolhaValue.equalsIgnoreCase("Sim")) {
            layout.setVisibility(View.VISIBLE);
        } else {
            layout.setVisibility(View.GONE);
        }
    }

    public void Back (View view){

        Intent intent = new Intent(anamneseDesenvolvimentoExercicio.this, com.example.teadapta.anamneseDesenvolvimentoSocioEmocional2.class);
        startActivity(intent);
    }
    public void submit (View view) {
        DadosCompartilhados dadosCompartilhados = DadosCompartilhados.getInstance();
        String nome = dadosCompartilhados.getNome();
        int idade = dadosCompartilhados.getIdade();
        double peso = dadosCompartilhados.getPeso();
        double altura = dadosCompartilhados.getAltura();

        String nomeMae = dadosCompartilhados.getNomeMae();
        int idadeMae = dadosCompartilhados.getIdadeMae();


        String escolhaValue = dadosCompartilhados.getEscolhaValue();
        String escolaridadeValue = dadosCompartilhados.getEscolaridadeValue();
        String escolarValue = dadosCompartilhados.getEscolarValue();

        // Crie um objeto Usuario com os valores obtidos
        Usuario usuario = new Usuario(nome, idade, peso, altura, escolhaValue, escolaridadeValue, escolarValue,nomeMae,idadeMae);

        // Inicialize o Firestore
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Crie um novo documento na coleção "usuarios" com um ID automático
        db.collection("usuarios")
                .add(usuario)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(anamneseDesenvolvimentoExercicio.this, "Dados inseridos com sucesso.", Toast.LENGTH_SHORT).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(anamneseDesenvolvimentoExercicio.this, "Erro ao inserir os dados: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        }

    }

