package com.example.teadapta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class anamnesePais extends AppCompatActivity {

    private AutoCompleteTextView familiar;
    private AutoCompleteTextView escolha;

    private TextInputEditText editTextIdadeMae, editTextNomeMae, editTextTelefoneMae,
    editTextFormacaoAcademica, editTextProfissaoMae,editTextIdadePai,editTextNomePai,
    editTextTelefonePai,editTextFormacaoAcademicaPai,editTextProfissaoPai,editTextFamilia
    ,editTextEmail;

    public TextInputEditText getEditTextIdadeMae() {
        return editTextIdadeMae;
    }

    public TextInputEditText getEditTextNomeMae() {
        return editTextNomeMae;
    }

    public TextInputEditText getEditTextTelefoneMae() {
        return editTextTelefoneMae;
    }

    public TextInputEditText getEditTextFormacaoAcademica() {
        return editTextFormacaoAcademica;
    }

    public TextInputEditText getEditTextProfissaoMae() {
        return editTextProfissaoMae;
    }

    public TextInputEditText getEditTextIdadePai() {
        return editTextIdadePai;
    }

    public TextInputEditText getEditTextNomePai() {
        return editTextNomePai;
    }

    public TextInputEditText getEditTextTelefonePai() {
        return editTextTelefonePai;
    }

    public TextInputEditText getEditTextFormacaoAcademicaPai() {
        return editTextFormacaoAcademicaPai;
    }

    public TextInputEditText getEditTextProfissaoPai() {
        return editTextProfissaoPai;
    }

    public TextInputEditText getEditTextFamilia() {
        return editTextFamilia;
    }

    public TextInputEditText getEditTextEmail() {
        return editTextEmail;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese_pais);

        escolha = findViewById(R.id.escolha);

        editTextIdadeMae = findViewById(R.id.IdadeMae);
        editTextNomeMae = findViewById(R.id.inputmae);
        editTextTelefoneMae = findViewById(R.id.NumberMae);
        editTextFormacaoAcademica = findViewById(R.id.formacaoMae);
        editTextProfissaoMae = findViewById(R.id.profissaoMae);
        editTextIdadePai = findViewById(R.id.input);
        editTextNomePai = findViewById(R.id.Idade);
        editTextTelefonePai = findViewById(R.id.Number);
        editTextFormacaoAcademicaPai = findViewById(R.id.formacao);
        editTextProfissaoPai = findViewById(R.id.profissao);
        editTextFamilia = findViewById(R.id.familiar);
        editTextEmail = findViewById(R.id.Email);

        EditText phoneNumberEditText = findViewById(R.id.NumberMae);
        EditText phoneNumberEditTextPAI = findViewById(R.id.Number);
        PhoneNumberFormattingTextWatcher phoneNumberWatcher = new PhoneNumberFormattingTextWatcher("BR");
        phoneNumberEditText.addTextChangedListener(phoneNumberWatcher);
        PhoneNumberFormattingTextWatcher phoneNumberWatcher2 = new PhoneNumberFormattingTextWatcher("BR");
        phoneNumberEditTextPAI.addTextChangedListener(phoneNumberWatcher2);

        //Escolha de Sim ou Não
        String[] listaEscolha = getResources().getStringArray(R.array.Escolha);
        ArrayAdapter<String> adapterEscolha = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listaEscolha);
        escolha.setAdapter(adapterEscolha);


        // Adiciona um TextWatcher ao campo de escolha
        escolha.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Chamado quando o texto é alterado
                String escolhaValue = s.toString().trim();

                // Obtenha uma referência ao TextInputLayout e TextInputEditText para o campo de religião
                TextInputLayout religiaoLayout = findViewById(R.id.outlinedTextFieldreligiao);

                // Verifica se a escolha é "Sim" para mostrar ou ocultar o campo de religião
                if (escolhaValue.equals("Sim")) {
                    religiaoLayout.setVisibility(View.VISIBLE);
                } else {
                    religiaoLayout.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        
    }


    private boolean validateFields() {
        boolean valid = true; //editTextIdadeMae

        TextInputLayout idadeMaeLayout = findViewById(R.id.textIdadeMae);
        TextInputLayout nomeMaeLayout = findViewById(R.id.outlinedTextFieldMae);
        TextInputLayout telefoneMaeLayout = findViewById(R.id.textNumberTel);
        TextInputLayout formacaoAcademicaLayout = findViewById(R.id.outlinedTextFieldformacaoMae);
        TextInputLayout profissaoMaeLayout = findViewById(R.id.outlinedTextFieldprofissaoMae);
        TextInputLayout idadePaiLayout = findViewById(R.id.outlinedTextField);
        TextInputLayout nomePaiLayout = findViewById(R.id.textIdade);
        TextInputLayout telefonePaiLayout = findViewById(R.id.textNumber);
        TextInputLayout formacaoAcademicaPaiLayout = findViewById(R.id.outlinedTextFieldformacao);
        TextInputLayout profissaoPaiLayout = findViewById(R.id.outlinedTextFieldprofissao);
        TextInputLayout familiaLayout = findViewById(R.id.outlinedTextFieldpFamiliar);
        TextInputLayout emailLayout = findViewById(R.id.outlinedTextFieldpEmail);
        /*
        anamnese instanciaAnamnese = new anamnese();

        //AutoCompleteTextView escolha = instanciaAnamnese.getEscolha();
        TextInputEditText editTextNome = instanciaAnamnese.getEditTextNome();
        TextInputEditText editTextIdade = instanciaAnamnese.getEditTextIdade();
        TextInputEditText editTextPeso = instanciaAnamnese.getEditTextPeso();
        TextInputEditText editTextAltura = instanciaAnamnese.getEditTextAltura();

         */
        
        int errorColor = ContextCompat.getColor(this, R.color.error_color);
        int errorIconColor = ContextCompat.getColor(this, R.color.error_icon_color);

        editTextIdadeMae.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}   // Nada a fazer antes da mudança de texto
            
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                idadeMaeLayout.setError(null); // Remove a mensagem de erro
                idadeMaeLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                idadeMaeLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                idadeMaeLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        if (editTextIdadeMae.getText().toString().trim().isEmpty()) {
            if (!editTextIdadeMae.isFocused()) {
                idadeMaeLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                idadeMaeLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                idadeMaeLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                idadeMaeLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            idadeMaeLayout.setError(null);
        }

        editTextNomeMae.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                nomeMaeLayout.setError(null); // Remove a mensagem de erro
                nomeMaeLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                nomeMaeLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                nomeMaeLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
         if (editTextNomeMae.getText().toString().trim().isEmpty()) {
            if (!editTextNomeMae.isFocused()) {
                nomeMaeLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                nomeMaeLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                nomeMaeLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                nomeMaeLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            nomeMaeLayout.setError(null);
        }
        editTextTelefoneMae.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                telefoneMaeLayout.setError(null); // Remove a mensagem de erro
                telefoneMaeLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                telefoneMaeLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                telefoneMaeLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        if (editTextTelefoneMae.getText().toString().trim().isEmpty()) {
            if (!editTextTelefoneMae.isFocused()) {
                telefoneMaeLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                telefoneMaeLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                telefoneMaeLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                telefoneMaeLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            telefoneMaeLayout.setError(null);
        }
        editTextFormacaoAcademica.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                formacaoAcademicaLayout.setError(null); // Remove a mensagem de erro
                formacaoAcademicaLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                formacaoAcademicaLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                formacaoAcademicaLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        if (editTextFormacaoAcademica.getText().toString().trim().isEmpty()) {
            if (!editTextFormacaoAcademica.isFocused()) {
                formacaoAcademicaLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                formacaoAcademicaLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                formacaoAcademicaLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                formacaoAcademicaLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            formacaoAcademicaLayout.setError(null);
        }
        editTextProfissaoMae.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                profissaoMaeLayout.setError(null); // Remove a mensagem de erro
                profissaoMaeLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                profissaoMaeLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                profissaoMaeLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        if (editTextProfissaoMae.getText().toString().trim().isEmpty()) {
            if (!editTextProfissaoMae.isFocused()) {
                profissaoMaeLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                profissaoMaeLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                profissaoMaeLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                profissaoMaeLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            profissaoMaeLayout.setError(null);
        }
        editTextIdadePai.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                idadePaiLayout.setError(null); // Remove a mensagem de erro
                idadePaiLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                idadePaiLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                idadePaiLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        if (editTextIdadePai.getText().toString().trim().isEmpty()) {
            if (!editTextIdadePai.isFocused()) {
                idadePaiLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                idadePaiLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                idadePaiLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                idadePaiLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            idadePaiLayout.setError(null);
        }
        editTextNomePai.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                nomePaiLayout.setError(null); // Remove a mensagem de erro
                nomePaiLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                nomePaiLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                nomePaiLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        if (editTextNomePai.getText().toString().trim().isEmpty()) {
            if (!editTextNomePai.isFocused()) {
                nomePaiLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                nomePaiLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                nomePaiLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                nomePaiLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            nomePaiLayout.setError(null);
        }
        editTextTelefonePai.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                telefonePaiLayout.setError(null); // Remove a mensagem de erro
                telefonePaiLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                telefonePaiLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                telefonePaiLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        
        if (editTextTelefonePai.getText().toString().trim().isEmpty()) {
            if (!editTextTelefonePai.isFocused()) {
                telefonePaiLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                telefonePaiLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                telefonePaiLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                telefonePaiLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            telefonePaiLayout.setError(null);
        }
        editTextFormacaoAcademicaPai.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                formacaoAcademicaPaiLayout.setError(null); // Remove a mensagem de erro
                formacaoAcademicaPaiLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                formacaoAcademicaPaiLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                formacaoAcademicaPaiLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        
        if (editTextFormacaoAcademicaPai.getText().toString().trim().isEmpty()) {
            if (!editTextFormacaoAcademicaPai.isFocused()) {
                formacaoAcademicaPaiLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                formacaoAcademicaPaiLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                formacaoAcademicaPaiLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                formacaoAcademicaPaiLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            formacaoAcademicaPaiLayout.setError(null);
        }
        
        // Configuração para editTextProfissaoPai
        editTextProfissaoPai.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                profissaoPaiLayout.setError(null); // Remove a mensagem de erro
                profissaoPaiLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                profissaoPaiLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                profissaoPaiLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        
        if (editTextProfissaoPai.getText().toString().trim().isEmpty()) {
            if (!editTextProfissaoPai.isFocused()) {
                profissaoPaiLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                profissaoPaiLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                profissaoPaiLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                profissaoPaiLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            profissaoPaiLayout.setError(null);
        }
        editTextFamilia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                familiaLayout.setError(null); // Remove a mensagem de erro
                familiaLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                familiaLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                familiaLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        
        if (editTextFamilia.getText().toString().trim().isEmpty()) {
            if (!editTextFamilia.isFocused()) {
                familiaLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                familiaLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                familiaLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                familiaLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            familiaLayout.setError(null);
        }
        editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                emailLayout.setError(null); // Remove a mensagem de erro
                emailLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                emailLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                emailLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        
        if (editTextEmail.getText().toString().trim().isEmpty()) {
            if (!editTextEmail.isFocused()) {
                emailLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                emailLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                emailLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                emailLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            emailLayout.setError(null);
        }
       
       

        return valid;
    }


    public void Back (View view){
        super.onBackPressed();
    }

    public void submit (View view){
        if (validateFields()) {

            String nomeMae = editTextNomeMae.getText().toString().trim();
            int idadeMae = Integer.parseInt(editTextIdadeMae.getText().toString().trim());

            DadosCompartilhados dadosCompartilhados = DadosCompartilhados.getInstance();
            dadosCompartilhados.setNomeMae(nomeMae);
            dadosCompartilhados.setIdadeMae(idadeMae);

            Intent intent = new Intent(anamnesePais.this, com.example.teadapta.anamneseDesenvolvimento.class);
            startActivity(intent);


        }
    }
}