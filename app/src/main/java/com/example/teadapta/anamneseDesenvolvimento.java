package com.example.teadapta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class anamneseDesenvolvimento extends AppCompatActivity {

    private TextInputEditText editTextSustentouCabeca,editTextRolouLateralmente, editTextVirouse,
    editTextSentouComApoio, editTextArrastou,editTextEngatinhou,editTextFicouDePeComApoio,
    editTextFicouDePeSemApoio,editTextAndouComApio,editTextAndouSemApoio;

    public TextInputEditText getEditTextSustentouCabeca() {
        return editTextSustentouCabeca;
    }

    public TextInputEditText getEditTextRolouLateralmente() {
        return editTextRolouLateralmente;
    }

    public TextInputEditText getEditTextVirouse() {return editTextVirouse;}

    public TextInputEditText getEditTextSentouComApoio() {
        return editTextSentouComApoio;
    }

    public TextInputEditText getEditTextArrastou() {
        return editTextArrastou;
    }

    public TextInputEditText getEditTextEngatinhou() {
        return editTextEngatinhou;
    }

    public TextInputEditText getEditTextFicouDePeComApoio() {
        return editTextFicouDePeComApoio;
    }

    public TextInputEditText getEditTextFicouDePeSemApoio() {
        return editTextFicouDePeSemApoio;
    }

    public TextInputEditText getEditTextAndouComApoio() {
        return editTextAndouComApio;
    }

    public TextInputEditText getEditTextAndouSemApoio() {
        return editTextAndouSemApoio;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese_desenvolvimento);

        editTextSustentouCabeca = findViewById(R.id.Field_);
        editTextRolouLateralmente = findViewById(R.id.Field2_);
        editTextVirouse = findViewById(R.id.Field3_); // Altere para o ID correto do EditText da criança virou-se
        editTextSentouComApoio = findViewById(R.id.Field4_);
        editTextArrastou = findViewById(R.id.Field5_); // Altere para o ID correto do EditText da criança virou-se
        editTextEngatinhou = findViewById(R.id.Field6_);
        editTextFicouDePeComApoio = findViewById(R.id.Field7_);
        editTextFicouDePeSemApoio = findViewById(R.id.Field8_);
        editTextAndouComApio = findViewById(R.id.Field9_);
        editTextAndouSemApoio = findViewById(R.id.Field10_); 

 
    }
    private boolean validateFields() {
        boolean valid = true;
        
        TextInputLayout sustentouCabecaLayout = findViewById(R.id.Field);
        TextInputLayout rolouLateralmenteLayout = findViewById(R.id.Field2);
        TextInputLayout virouseLayout = findViewById(R.id.Field3); 
        TextInputLayout sentouComApoioLayout = findViewById(R.id.Field4);
        TextInputLayout arrastouLayout = findViewById(R.id.Field5); // Altere para o ID correto do TextInputLayout da criança arrastou
        TextInputLayout engatinhouLayout = findViewById(R.id.Field6); 
        TextInputLayout ficouDePeComApoioLayout = findViewById(R.id.Field7);
        TextInputLayout ficouDePeSemApoioLayout = findViewById(R.id.Field8);
        TextInputLayout andouComApioLayout = findViewById(R.id.Field9);
        TextInputLayout andouSemApoioLayout = findViewById(R.id.Field10);
        int errorColor = ContextCompat.getColor(this, R.color.error_color);
        int errorIconColor = ContextCompat.getColor(this, R.color.error_icon_color);

        editTextSustentouCabeca.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                sustentouCabecaLayout.setError(null); // Remove a mensagem de erro
                sustentouCabecaLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                sustentouCabecaLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                sustentouCabecaLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        
        if (editTextSustentouCabeca.getText().toString().trim().isEmpty()) {
            if (!editTextSustentouCabeca.isFocused()) {
                sustentouCabecaLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                sustentouCabecaLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                sustentouCabecaLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                sustentouCabecaLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            sustentouCabecaLayout.setError(null);
        }
        
        editTextRolouLateralmente.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                rolouLateralmenteLayout.setError(null); // Remove a mensagem de erro
                rolouLateralmenteLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                rolouLateralmenteLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                rolouLateralmenteLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        
        if (editTextRolouLateralmente.getText().toString().trim().isEmpty()) {
            if (!editTextRolouLateralmente.isFocused()) {
                rolouLateralmenteLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                rolouLateralmenteLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                rolouLateralmenteLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                rolouLateralmenteLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            rolouLateralmenteLayout.setError(null);
        }
        editTextVirouse.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                virouseLayout.setError(null); // Remove a mensagem de erro
                virouseLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                virouseLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                virouseLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        
        if (editTextVirouse.getText().toString().trim().isEmpty()) {
            if (!editTextVirouse.isFocused()) {
                virouseLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                virouseLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                virouseLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                virouseLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            virouseLayout.setError(null);
        }
        
        // Configuração para editTextSentouComApoio
        editTextSentouComApoio.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                sentouComApoioLayout.setError(null); // Remove a mensagem de erro
                sentouComApoioLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                sentouComApoioLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                sentouComApoioLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        
        if (editTextSentouComApoio.getText().toString().trim().isEmpty()) {
            if (!editTextSentouComApoio.isFocused()) {
                sentouComApoioLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                sentouComApoioLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                sentouComApoioLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                sentouComApoioLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            sentouComApoioLayout.setError(null);
        }
        editTextArrastou.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                arrastouLayout.setError(null); // Remove a mensagem de erro
                arrastouLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                arrastouLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                arrastouLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        
        if (editTextArrastou.getText().toString().trim().isEmpty()) {
            if (!editTextArrastou.isFocused()) {
                arrastouLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                arrastouLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                arrastouLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                arrastouLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            arrastouLayout.setError(null);
        }
        
        // Configuração para editTextEngatinhou
        editTextEngatinhou.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                engatinhouLayout.setError(null); // Remove a mensagem de erro
                engatinhouLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                engatinhouLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                engatinhouLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        
        if (editTextEngatinhou.getText().toString().trim().isEmpty()) {
            if (!editTextEngatinhou.isFocused()) {
                engatinhouLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                engatinhouLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                engatinhouLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                engatinhouLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            engatinhouLayout.setError(null);
        }
        editTextFicouDePeComApoio.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                ficouDePeComApoioLayout.setError(null); // Remove a mensagem de erro
                ficouDePeComApoioLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                ficouDePeComApoioLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                ficouDePeComApoioLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        
        if (editTextFicouDePeComApoio.getText().toString().trim().isEmpty()) {
            if (!editTextFicouDePeComApoio.isFocused()) {
                ficouDePeComApoioLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                ficouDePeComApoioLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                ficouDePeComApoioLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                ficouDePeComApoioLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            ficouDePeComApoioLayout.setError(null);
        }
        editTextFicouDePeSemApoio.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                ficouDePeSemApoioLayout.setError(null); // Remove a mensagem de erro
                ficouDePeSemApoioLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                ficouDePeSemApoioLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                ficouDePeSemApoioLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        
        if (editTextFicouDePeSemApoio.getText().toString().trim().isEmpty()) {
            if (!editTextFicouDePeSemApoio.isFocused()) {
                ficouDePeSemApoioLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                ficouDePeSemApoioLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                ficouDePeSemApoioLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                ficouDePeSemApoioLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            ficouDePeSemApoioLayout.setError(null);
        }
        editTextAndouComApio.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                andouComApioLayout.setError(null); // Remove a mensagem de erro
                andouComApioLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                andouComApioLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                andouComApioLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        
        if (editTextAndouComApio.getText().toString().trim().isEmpty()) {
            if (!editTextAndouComApio.isFocused()) {
                andouComApioLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                andouComApioLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                andouComApioLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                andouComApioLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            andouComApioLayout.setError(null);
        }
        editTextAndouSemApoio.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        
            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                andouSemApoioLayout.setError(null); // Remove a mensagem de erro
                andouSemApoioLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                andouSemApoioLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                andouSemApoioLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });
        
        if (editTextAndouSemApoio.getText().toString().trim().isEmpty()) {
            if (!editTextAndouSemApoio.isFocused()) {
                andouSemApoioLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
                andouSemApoioLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
                andouSemApoioLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
                andouSemApoioLayout.setError("Campo vazio");
            }
            valid = false;
        } else {
            andouSemApoioLayout.setError(null);
        }

        return valid;
    }
    
    public void Back (View view){
        super.onBackPressed();
    }

    public void submit (View view){

        if (validateFields()) {


            int sustentouCabeca = Integer.parseInt(editTextSustentouCabeca.getText().toString().trim());
            int rolouLateralmente = Integer.parseInt(editTextRolouLateralmente.getText().toString().trim());
            int virouSe = Integer.parseInt(editTextVirouse.getText().toString().trim());
            int sentouComApoio = Integer.parseInt(editTextSentouComApoio.getText().toString().trim());
            int arrastou = Integer.parseInt(editTextArrastou.getText().toString().trim());
            int engatinhou = Integer.parseInt(editTextEngatinhou.getText().toString().trim());
            int ficouDePeComApoio = Integer.parseInt(editTextFicouDePeComApoio.getText().toString().trim());
            int ficouDePeSemApoio = Integer.parseInt(editTextFicouDePeSemApoio.getText().toString().trim());
            int andouComApoio = Integer.parseInt(editTextAndouComApio.getText().toString().trim());
            int andouSemApoio = Integer.parseInt(editTextAndouSemApoio.getText().toString().trim());


            DadosCompartilhados dadosCompartilhados = DadosCompartilhados.getInstance();
            dadosCompartilhados.setSustentouCabeca(sustentouCabeca);
            dadosCompartilhados.setRolouLateralmente(rolouLateralmente);
            dadosCompartilhados.setVirouSe(virouSe);
            dadosCompartilhados.setSentouComApoio(sentouComApoio);
            dadosCompartilhados.setArrastou(arrastou);
            dadosCompartilhados.setEngatinhou (engatinhou );
            dadosCompartilhados.setFicouDePeComApoio (ficouDePeComApoio );
            dadosCompartilhados.setFicouDePeSemApoio (ficouDePeSemApoio );
            dadosCompartilhados.setAndouComApoio(andouComApoio);
            dadosCompartilhados.setAndouSemApoio(andouSemApoio);




            // Se tudo estiver válido, avança para a próxima página
            Intent intent = new Intent(anamneseDesenvolvimento.this, com.example.teadapta.anamneseDesenvolvimentoCrianca.class);
            startActivity(intent);
        }
    }
}