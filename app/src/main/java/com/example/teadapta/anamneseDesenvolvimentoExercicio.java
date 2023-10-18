package com.example.teadapta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.xmlpull.v1.XmlPullParser;

public class anamneseDesenvolvimentoExercicio extends AppCompatActivity {

    private AutoCompleteTextView escolha, escolha2, escolha3, escolha4;
    private TextInputLayout religiaoLayout, religiaoLayout2, religiaoLayout3, religiaoLayout4;
    private TextInputEditText limitacaoExercicios;
    private String selectedOptionTechnology;
    private View descriPraticaExercicios;
    private String comportamentoDoFilho;
    private String acriancaEstaSeExercitandoAtualmene;
    private TextInputEditText descricaoFrequencia2;
    private TextInputEditText descricaoDeQuais2;
    private XmlPullParser textInputEditText;




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

       // descricaoFrequencia = findViewById(R.id.subescolha3);

        limitacaoExercicios = findViewById(R.id.subescolha);//Há limitação para fazer exercicios
        //descriPraticaExercicios = findViewById(R.id.subescolha4);//Porque seu filho pratica exercicios fisicos



        descricaoDeQuais2 = findViewById(R.id.subescolha2);
        descricaoFrequencia2=findViewById(R.id.subescolha3);

        final CheckBox controladoCheckBox = findViewById(R.id.controlado);
        final CheckBox frequenteCheckBox = findViewById(R.id.frequente);
        final CheckBox muitoFrequenteCheckBox = findViewById(R.id.muito);
        final CheckBox raramenteCheckBox = findViewById(R.id.raramente);
        final CheckBox naoUsaCheckBox = findViewById(R.id.nao);

        // Adicione outros CheckBoxes aqui

        controladoCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedOptionTechnology = "Controlado";
                frequenteCheckBox.setChecked(false);
                muitoFrequenteCheckBox.setChecked(false);
                raramenteCheckBox.setChecked(false);
                naoUsaCheckBox.setChecked(false);
                // Desmarque os outros CheckBoxes aqui, se necessário
            }
        });

        frequenteCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedOptionTechnology = "Frequente";
                controladoCheckBox.setChecked(false);
                muitoFrequenteCheckBox.setChecked(false);
                raramenteCheckBox.setChecked(false);
                naoUsaCheckBox.setChecked(false);
                // Desmarque os outros CheckBoxes aqui, se necessário
            }
        });
        muitoFrequenteCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedOptionTechnology = "Muito Frequente";
                frequenteCheckBox.setChecked(false);
                controladoCheckBox.setChecked(false);
                raramenteCheckBox.setChecked(false);
                naoUsaCheckBox.setChecked(false);
                // Desmarque os outros CheckBoxes aqui, se necessário
            }
        });

        raramenteCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedOptionTechnology = "Raramente";
                naoUsaCheckBox.setChecked(false);
                controladoCheckBox.setChecked(false);
                frequenteCheckBox.setChecked(false);
                muitoFrequenteCheckBox.setChecked(false);

                // Desmarque os outros CheckBoxes aqui, se necessário
            }
        });
        naoUsaCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedOptionTechnology = "Não Usa";
                controladoCheckBox.setChecked(false);
                frequenteCheckBox.setChecked(false);
                muitoFrequenteCheckBox.setChecked(false);
                raramenteCheckBox.setChecked(false);
                // Desmarque os outros CheckBoxes aqui, se necessário
            }
        });



        final CheckBox seisMesesCheckBox = findViewById(R.id.seisMeses);
        final CheckBox EntreCheckBox = findViewById(R.id.Entre);
        final CheckBox MaisCheckBox = findViewById(R.id.Mais);



        // Adicione outros CheckBoxes aqui

        seisMesesCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                acriancaEstaSeExercitandoAtualmene = "Menos de 6 meses";
                EntreCheckBox.setChecked(false);
                MaisCheckBox.setChecked(false);
            }
        });

        EntreCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                acriancaEstaSeExercitandoAtualmene = "Entre seis meses a 1 ano";
                seisMesesCheckBox.setChecked(false);
                MaisCheckBox.setChecked(false);
            }
        });
        MaisCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                acriancaEstaSeExercitandoAtualmene = "Mais de 1 ano";
                seisMesesCheckBox.setChecked(false);
                EntreCheckBox.setChecked(false);
            }
        });


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

    private boolean validateFields()
    {
        boolean valid = true;

        String escolhaLimiteExercicios = escolha.getText().toString();
        String escolhaExerciciosFrequentemente = escolha2.getText().toString();
        String escolhaPorquePraticaExercicios = escolha3.getText().toString();
        String escolhaExisteLocalBrincar = escolha4.getText().toString();


        TextInputLayout limiteExerciciosLayout = findViewById(R.id.InputLayout);
        TextInputLayout lixerciciosFrequentementeLayout = findViewById(R.id.InputLayout2);
        TextInputLayout porquePraticaExerciciosLayout = findViewById(R.id.InputLayout4);
        TextInputLayout existeLocalBrincarLayout = findViewById(R.id.InputLayout5);

        int errorColor = ContextCompat.getColor(this, R.color.error_color);
        int errorIconColor = ContextCompat.getColor(this, R.color.error_icon_color);

        escolha.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                limiteExerciciosLayout.setError(null); // Remove a mensagem de erro
                limiteExerciciosLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                limiteExerciciosLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                limiteExerciciosLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaLimiteExercicios.equals("Selecionar"))
        {
            limiteExerciciosLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            limiteExerciciosLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            limiteExerciciosLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            limiteExerciciosLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            limiteExerciciosLayout.setError(null);

        }


        escolha2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                lixerciciosFrequentementeLayout.setError(null); // Remove a mensagem de erro
                lixerciciosFrequentementeLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                lixerciciosFrequentementeLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                lixerciciosFrequentementeLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaExerciciosFrequentemente.equals("Selecionar"))
        {
            lixerciciosFrequentementeLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            lixerciciosFrequentementeLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            lixerciciosFrequentementeLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            lixerciciosFrequentementeLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            lixerciciosFrequentementeLayout.setError(null);

        }


        escolha3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                porquePraticaExerciciosLayout.setError(null); // Remove a mensagem de erro
                porquePraticaExerciciosLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                porquePraticaExerciciosLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                porquePraticaExerciciosLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaPorquePraticaExercicios.equals("Selecionar"))
        {
            porquePraticaExerciciosLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            porquePraticaExerciciosLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            porquePraticaExerciciosLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            porquePraticaExerciciosLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            porquePraticaExerciciosLayout.setError(null);

        }


        escolha4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                // Chamado após o texto ser alterado
                existeLocalBrincarLayout.setError(null); // Remove a mensagem de erro
                existeLocalBrincarLayout.setBoxStrokeErrorColor(null); // Remove a cor do contorno de erro
                existeLocalBrincarLayout.setErrorTextColor(null); // Remove a cor do texto de erro
                existeLocalBrincarLayout.setErrorIconTintList(null); // Remove a cor do ícone de erro
            }
        });

        if(escolhaExisteLocalBrincar.equals("Selecionar"))
        {
            existeLocalBrincarLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(errorColor));
            existeLocalBrincarLayout.setErrorTextColor(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            existeLocalBrincarLayout.setErrorIconTintList(ColorStateList.valueOf(errorIconColor));
            existeLocalBrincarLayout.setError("Campo vazio");
            valid = false;
        }
        else {
            existeLocalBrincarLayout.setError(null);

        }

        return valid;
    }



        public void submit (View view)
        {
            if (validateFields())
            {
                String haLimitacao = escolha.getText().toString(); // Valor do primeiro AutoCompleteTextView
                String estaExercitando = escolha2.getText().toString(); // Valor do segundo AutoCompleteTextView
                String praticaExercicios = escolha3.getText().toString();
                String temLugarParaBrincar = escolha4.getText().toString();
                String haLimitacaoExercicios = limitacaoExercicios.getText().toString().trim();

                //  descriPraticaExercicios = descriPraticaExercicios;


                selectedOptionTechnology =selectedOptionTechnology;

                acriancaEstaSeExercitandoAtualmene=acriancaEstaSeExercitandoAtualmene;

                String descricaoDeQuais = descricaoDeQuais2.getText().toString();
                String descricaoFrequencia = descricaoFrequencia2.getText().toString();

                TextInputLayout textInputLayout = findViewById(R.id.TextField4);
                TextInputEditText textInputEditText = textInputLayout.findViewById(R.id.subescolha4);

                String descriPraticaExercicios = textInputEditText.getText().toString().trim();


                // descricaoDeQuais=descricaoDeQuais;


                // DadosCompartilhados dadosCompartilhados = DadosCompartilhados.getInstance();





                DadosCompartilhados dadosCompartilhados = DadosCompartilhados.getInstance();

                dadosCompartilhados.setHaLimitacao(haLimitacao);
                dadosCompartilhados.setEstaExercitando(estaExercitando);
                dadosCompartilhados.setPraticaExercicios(praticaExercicios);
                dadosCompartilhados.setTemLugarParaBrincar(temLugarParaBrincar);
                dadosCompartilhados.setHaLimitacaoExercicios(haLimitacaoExercicios);


                dadosCompartilhados.setSelectedOptionTechnology(selectedOptionTechnology);
                dadosCompartilhados.setDescriPraticaExercicios(descriPraticaExercicios);

                dadosCompartilhados.setDescricaoDeQuais(descricaoDeQuais2);
                dadosCompartilhados.setDescricaoFrequencia(descricaoFrequencia2);
                dadosCompartilhados.setAcriancaEstaSeExercitandoAtualmene(acriancaEstaSeExercitandoAtualmene);



                String nome = dadosCompartilhados.getNome();
                String data = dadosCompartilhados.getData();
                int idade = dadosCompartilhados.getIdade();
                double peso = dadosCompartilhados.getPeso();
                double altura = dadosCompartilhados.getAltura();

                String nomeMae = dadosCompartilhados.getNomeMae();
                int idadeMae = dadosCompartilhados.getIdadeMae();
                String telefoneMae = dadosCompartilhados.getTelefoneMae();
                String profissaoMae = dadosCompartilhados.getProfissaoMae();
                String formacaoAcademica = dadosCompartilhados.getFormacaoAcademica();
                String nomePai = dadosCompartilhados.getNomePai();
                int idadePai = dadosCompartilhados.getIdadePai();
                String telefonePai = dadosCompartilhados.getTelefonePai();
                String formacaoAcademicaPai = dadosCompartilhados.getFormacaoAcademicaPai();
                String profissaoPai = dadosCompartilhados.getProfissaoPai();
                String email = dadosCompartilhados.getEmail();
                String composicaoFamilia = dadosCompartilhados.getComposicaoFamilia();
                String escolhaValores = dadosCompartilhados.getEscolhaValores();
                String descricaoEscolhaValores = dadosCompartilhados.getDescricaoEscolhaValores();


                int andouSemApoio = dadosCompartilhados.getAndouSemApoio();
                int sustentouCabeca = dadosCompartilhados.getSustentouCabeca();
                int rolouLateralmente = dadosCompartilhados.getRolouLateralmente();
                int virouSe = dadosCompartilhados.getVirouSe();
                int sentouComApoio = dadosCompartilhados.getSentouComApoio();
                int arrastou = dadosCompartilhados.getArrastou();
                int engatinhou = dadosCompartilhados.getEngatinhou();
                int ficouDePeComApoio = dadosCompartilhados.getFicouDePeComApoio();
                int ficouDePeSemApoio = dadosCompartilhados.getFicouDePeSemApoio();
                int andouComApoio = dadosCompartilhados.getAndouComApoio();



                String escolhaValue = dadosCompartilhados.getEscolhaValue();
                String escolaridadeValue = dadosCompartilhados.getEscolaridadeValue();
                String escolarValue = dadosCompartilhados.getEscolarValue();

                String usoDuasMaos = dadosCompartilhados.getUsoDuasMaos();
                String dificuldadeCordenacao = dadosCompartilhados.getDificuldadeCordenacao();
                String caiComFrequencia= dadosCompartilhados.getCaiComFrequencia();
                String apanhaObjetosSemDiculdade= dadosCompartilhados.getApanhaObjetosSemDiculdade();
                String imitaGestosSimples= dadosCompartilhados.getImitaGestosSimples();
                String arremessaObjetosSemDiculdade= dadosCompartilhados.getArremessaObjetosSemDiculdade();
                String seguraObjetosSemDiculdade= dadosCompartilhados.getSeguraObjetosSemDiculdade();
                String formasPeculiaresDeOrganizacaoMotora= dadosCompartilhados.getFormasPeculiaresDeOrganizacaoMotora();
                String escolhaAMao= dadosCompartilhados.getEscolhaAMao();


                String investeMomentosFamilia= dadosCompartilhados.getInvesteMomentosFamilia();
                String medosFobias= dadosCompartilhados.getMedosFobias();
                String comoSeSenteSeparadoDosPais = dadosCompartilhados.getComoSeSenteSeparadoDosPais();
                String informacoesAdicionais = dadosCompartilhados.getInformacoesAdicionais();
                String descricaoMedoFobia = dadosCompartilhados.getDescricaoMedoFobia();
                String investeEmMomentosFamilia = dadosCompartilhados.getInvesteEmMomentosFamilia();



                String frase = dadosCompartilhados.getFrase();
                String primeirasPalavras = dadosCompartilhados.getPrimeirasPalavras();
                String vocalizou= dadosCompartilhados.getVocalizou();
                String respondeuSomHumano= dadosCompartilhados.getRespondeuSomHumano();
                String respondruSom= dadosCompartilhados.getRespondruSom();
                String problemasComunicacao= dadosCompartilhados.getProblemasComunicacao();
                String descricaoDoProblemaComunicacao= dadosCompartilhados.getDescricaoDoProblemaComunicacao();


                String reageFavoravelmentePessoa = dadosCompartilhados.getReageFavoravelmentePessoa();
                String brincaCriancaAdulto = dadosCompartilhados.getBrincaCriancaAdulto();
                String expressaNecessidades= dadosCompartilhados.getExpressaNecessidades();
                String apresentaBirrasComFrequencia= dadosCompartilhados.getApresentaBirrasComFrequencia();
                String seAdaptaCasaEscola= dadosCompartilhados.getImitaGestosSimples();
                String choraFrequencia= dadosCompartilhados.getChoraFrequencia();
                String fazAmigosFacilidade= dadosCompartilhados.getFazAmigosFacilidade();
                String expressaEmocoesComFacilidade= dadosCompartilhados.getExpressaEmocoesComFacilidade();
                String mudaComportamentoComEstranho= dadosCompartilhados.getMudaComportamentoComEstranho();
                String reageFavoravelmenteNovidades= dadosCompartilhados.getReageFavoravelmenteNovidades();
                String procuraProtecaoPais = dadosCompartilhados.getProcuraProtecaoPais();



                haLimitacao = dadosCompartilhados.getHaLimitacao();
                estaExercitando = dadosCompartilhados.getEstaExercitando();
                praticaExercicios = dadosCompartilhados.getPraticaExercicios();
                temLugarParaBrincar = dadosCompartilhados.getTemLugarParaBrincar();
                haLimitacaoExercicios = dadosCompartilhados.getHaLimitacaoExercicios();
                selectedOptionTechnology = dadosCompartilhados.getSelectedOptionTechnology();
                descriPraticaExercicios = dadosCompartilhados.getDescriPraticaExercicios();
                comportamentoDoFilho = dadosCompartilhados.getComportamentoDoFilho();
                acriancaEstaSeExercitandoAtualmene = dadosCompartilhados.getAcriancaEstaSeExercitandoAtualmene();
                descricaoDeQuais2 = dadosCompartilhados.getDescricaoDeQuais();
                descricaoFrequencia2 = dadosCompartilhados.getDescricaoFrequencia();








                // Crie um objeto Usuario com os valores obtidos
                Usuario usuario = new Usuario(//....................anamnese..............................................................
                        nome, idade,data, peso, altura, escolhaValue,escolaridadeValue,  escolarValue

                        //..............................anamnese pai.........................................................
                        , nomeMae, idadeMae, telefoneMae,  formacaoAcademica, profissaoMae, nomePai,
                        idadePai, formacaoAcademicaPai,  profissaoPai, telefonePai,  email,composicaoFamilia,
                        escolhaValores,descricaoEscolhaValores


                        //..............................Anamnese Desenvolvimento.................................................
                        , andouSemApoio, sustentouCabeca, rolouLateralmente, virouSe, sentouComApoio, arrastou, engatinhou
                        ,ficouDePeComApoio, ficouDePeSemApoio, andouComApoio

                        //............................Anamnese Desenvolvimento Crianca.........................................................

                        , usoDuasMaos,dificuldadeCordenacao,caiComFrequencia, apanhaObjetosSemDiculdade,
                        imitaGestosSimples,arremessaObjetosSemDiculdade,seguraObjetosSemDiculdade,
                        formasPeculiaresDeOrganizacaoMotora, escolhaAMao,

                        //...........................Anamnese Desenvolvimento Linguistico...............................

                        frase,  primeirasPalavras, vocalizou,respondeuSomHumano, respondruSom,
                        problemasComunicacao,descricaoDoProblemaComunicacao,

                        //......................Anamnese Desenvolvimento SocioEmocional................................

                        reageFavoravelmentePessoa, brincaCriancaAdulto, expressaNecessidades,
                        apresentaBirrasComFrequencia, seAdaptaCasaEscola,choraFrequencia ,fazAmigosFacilidade,
                        expressaEmocoesComFacilidade, mudaComportamentoComEstranho, reageFavoravelmenteNovidades,
                        procuraProtecaoPais,comportamentoDoFilho,

                        //......................Anamnese Desenvolvimento SocioEmocional2................................

                        investeMomentosFamilia,medosFobias,comoSeSenteSeparadoDosPais,informacoesAdicionais,descricaoMedoFobia,
                        investeEmMomentosFamilia


                        ,haLimitacao,estaExercitando, praticaExercicios,temLugarParaBrincar,
                        haLimitacaoExercicios, selectedOptionTechnology,acriancaEstaSeExercitandoAtualmene,descricaoDeQuais
                        ,descricaoFrequencia,descriPraticaExercicios);


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

    }

