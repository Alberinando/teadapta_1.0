package com.example.teadapta;

import com.google.android.material.textfield.TextInputLayout;

public class Usuario {



    public String descricaoFrequencia;
    public String descricaoDeQuais;
    public String acriancaEstaSeExercitandoAtualmene;
    public int descriPraticaExercicios;
    public String selectedOptionTechnology;
    public String haLimitacaoExercicios;
    public String estaExercitando;
    public String temLugarParaBrincar;
    public String praticaExercicios;
    public String haLimitacao;


    //......................Anamnese Desenvolvimento SocioEmocional2................................

    public String investeMomentosFamilia;
    public String medosFobias;
    public String comoSeSenteSeparadoDosPais;



    //........................................Fim...................................................



    //......................Anamnese Desenvolvimento SocioEmocional................................

    public String reageFavoravelmentePessoa;
    public String reageFavoravelmenteNovidades;
    public String mudaComportamentoComEstranho;
    public String expressaEmocoesComFacilidade;
    public String fazAmigosFacilidade;
    public String choraFrequencia;
    public String seAdaptaCasaEscola;
    public String apresentaBirrasComFrequencia;
    public String expressaNecessidades;
    public String brincaCriancaAdulto;
    public String procuraProtecaoPais;
    public String comportamentoDoFilho;

    //........................................Fim...................................................



    //............................Anamnese Desenvolvimento Crianca..............................
    public String dificuldadeCordenacao;
    public String caiComFrequencia;
    public String apanhaObjetosSemDiculdade;
    public String imitaGestosSimples;
    public String arremessaObjetosSemDiculdade;
    public String seguraObjetosSemDiculdade;
    public String formasPeculiaresDeOrganizacaoMotora;
    public String usoDuasMaos;
    public String escolhaAMao;

    //........................................Fim...................................................



    //...........................Anamnese Desenvolvimento Linguistico...............................
    public String frase;
    public String primeirasPalavras;
    public String vocalizou;
    public String respondeuSomHumano;
    public String respondruSom;

    public String problemasComunicacao;
    public String descricaoDoProblemaComunicacao;

    //..........................................Fim..............................................


    //...........................Anamnese Desenvolvimento ..................................

    public int andouSemApoio;
    public int sustentouCabeca;
    public int rolouLateralmente;
    public int virouSe;
    public int sentouComApoio;
    public int arrastou;
    public int engatinhou;
    public int ficouDePeComApoio;
    public int ficouDePeSemApoio;
    public int  andouComApoio;

    //....................................Fim.......................................................


    //.........................anamnese............................................................
    public String nome;
    public int idade;
    public double peso;
    public double altura;
    public String escolhaValue; // Adicione este campo
    public String escolaridadeValue;
    public String escolarValue;

    public String data;

    //.............................Fim ..........................................


    //..............................anamnese pai................................................
    public String nomeMae;
    public int idadeMae;
    public String telefoneMae;
    public String profissaoPai;
    public String formacaoAcademicaPai;
    public int idadePai;
    public String telefonePai;
    public String nomePai;
    public String formacaoAcademica;
    public String profissaoMae;
    public String email;
    public String composicaoFamilia;
    public String escolhaValores;
    public String descricaoEscolhaValores;

    //..................................Fim.............................................
    public Usuario() {
        // Construtor vazio necessário para o Firebase
    }

    public Usuario(//....................anamnese..............................................................
            String nome, int idade,String data, double peso, double altura, String escolhaValue, String escolaridadeValue, String escolarValue
            //..............................anamnese pai.........................................................
            , String nomeMae, int idadeMae, String telefoneMae, String formacaoAcademica,String profissaoMae, String nomePai,
            int idadePai, String formacaoAcademicaPai, String profissaoPai,String telefonePai,  String email,String composicaoFamilia,
                   String escolhaValores,String descricaoEscolhaValores


            //..............................Anamnese Desenvolvimento.................................................
            ,int andouSemApoio,int sustentouCabeca,int rolouLateralmente,int virouSe,int sentouComApoio,int arrastou,int engatinhou
            ,int ficouDePeComApoio,int ficouDePeSemApoio,int andouComApoio

             //............................Anamnese Desenvolvimento Crianca.........................................................

            , String usoDuasMaos,String dificuldadeCordenacao,String caiComFrequencia,String apanhaObjetosSemDiculdade,
                   String imitaGestosSimples,String arremessaObjetosSemDiculdade,String seguraObjetosSemDiculdade,
                   String formasPeculiaresDeOrganizacaoMotora, String escolhaAMao,

                   //...........................Anamnese Desenvolvimento Linguistico...............................

                   String frase, String primeirasPalavras,String vocalizou,String respondeuSomHumano,String respondruSom,
                   String problemasComunicacao,String descricaoDoProblemaComunicacao,

                   //......................Anamnese Desenvolvimento SocioEmocional................................

                   String reageFavoravelmentePessoa,String brincaCriancaAdulto,String expressaNecessidades,
                   String apresentaBirrasComFrequencia,String seAdaptaCasaEscola,String choraFrequencia,String fazAmigosFacilidade,
                   String expressaEmocoesComFacilidade,String mudaComportamentoComEstranho,String reageFavoravelmenteNovidades,
                   String procuraProtecaoPais, String comportamentoDoFilho,

                   //......................Anamnese Desenvolvimento SocioEmocional2................................

                   String investeMomentosFamilia,String medosFobias/*,String comoSeSenteSeparadoDosPais*/


                  ,String haLimitacao,String estaExercitando,String praticaExercicios,String temLugarParaBrincar,
                   String haLimitacaoExercicios,String selectedOptionTechnology, String acriancaEstaSeExercitandoAtualmene
                    ,String descricaoDeQuais , String descricaoFrequencia) {




        //..................anamnese.....................................................
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.escolhaValue = escolhaValue;
        this.escolaridadeValue = escolaridadeValue;
        this.escolarValue = escolarValue;
        this.data= data;


        //...............................Fim.................................................

        //............................anamnese pai...........................................

        this.nomeMae = nomeMae;
        this.idadeMae = idadeMae;
        this.telefoneMae = telefoneMae;
        this.formacaoAcademica = formacaoAcademica;
        this.nomePai = nomePai;
        this.idadePai = idadePai;
        this.profissaoPai = profissaoPai;
        this.formacaoAcademicaPai = formacaoAcademicaPai;
        this.telefonePai = telefonePai;
        this.profissaoMae = profissaoMae;
        this.escolhaValores = escolhaValores;
        this.email = email;
        this.composicaoFamilia = composicaoFamilia;
        this.descricaoEscolhaValores = descricaoEscolhaValores;
        //.............................Fim......................................................



        //..........................Anamnese Desenvolvimento....................................


        this.andouSemApoio = andouSemApoio;
        this.sustentouCabeca = sustentouCabeca;
        this.rolouLateralmente = rolouLateralmente;
        this.virouSe = virouSe;
        this.sentouComApoio = sentouComApoio;
        this.arrastou = arrastou;
        this.engatinhou = engatinhou;
        this.ficouDePeComApoio = ficouDePeComApoio;
        this.ficouDePeSemApoio = ficouDePeSemApoio;
        this.andouComApoio = andouComApoio;


        //................................Fim....................................................



        //........................Anamnese Desenvolvimento Linguistico.............................

        this.frase = frase;
        this.primeirasPalavras = primeirasPalavras;
        this.vocalizou = vocalizou;
        this.respondeuSomHumano = respondeuSomHumano;
        this.respondruSom = respondruSom;
        this.problemasComunicacao = problemasComunicacao;
        this.descricaoDoProblemaComunicacao = descricaoDoProblemaComunicacao;

        //.......................................Fim...............................................


        //............................Anamnese Desenvolvimento Crianca..............................

        this.usoDuasMaos = usoDuasMaos;
        this.dificuldadeCordenacao = dificuldadeCordenacao;
        this.caiComFrequencia = caiComFrequencia;
        this.apanhaObjetosSemDiculdade = apanhaObjetosSemDiculdade;
        this.imitaGestosSimples = imitaGestosSimples;
        this.arremessaObjetosSemDiculdade = arremessaObjetosSemDiculdade;
        this.seguraObjetosSemDiculdade = seguraObjetosSemDiculdade;
        this.formasPeculiaresDeOrganizacaoMotora = formasPeculiaresDeOrganizacaoMotora;
        this.escolhaAMao = escolhaAMao;

        //.......................................Fim...............................................



        //......................Anamnese Desenvolvimento SocioEmocional................................


        this.reageFavoravelmentePessoa=reageFavoravelmentePessoa;
        this.brincaCriancaAdulto = brincaCriancaAdulto;
        this.expressaNecessidades = expressaNecessidades;
        this.apresentaBirrasComFrequencia = apresentaBirrasComFrequencia;
        this.seAdaptaCasaEscola = seAdaptaCasaEscola;
        this.choraFrequencia = choraFrequencia;
        this.fazAmigosFacilidade = fazAmigosFacilidade;
        this.expressaEmocoesComFacilidade = expressaEmocoesComFacilidade;
        this.mudaComportamentoComEstranho = mudaComportamentoComEstranho;
        this.reageFavoravelmenteNovidades = reageFavoravelmenteNovidades;
        this.procuraProtecaoPais = procuraProtecaoPais;
        this.comportamentoDoFilho = comportamentoDoFilho;

        //.......................................Fim...............................................


        //......................Anamnese Desenvolvimento SocioEmocional2.............................

        this.investeMomentosFamilia = investeMomentosFamilia;
        this.medosFobias = medosFobias;
        this.comoSeSenteSeparadoDosPais = comoSeSenteSeparadoDosPais;



        //.......................................Fim...............................................



        this.haLimitacao=haLimitacao;
        this.estaExercitando=estaExercitando;
        this.praticaExercicios=praticaExercicios;
        this.temLugarParaBrincar=temLugarParaBrincar;
        this.haLimitacaoExercicios=haLimitacaoExercicios;
        this.selectedOptionTechnology=selectedOptionTechnology;
        this.acriancaEstaSeExercitandoAtualmene=acriancaEstaSeExercitandoAtualmene;
        this.descricaoDeQuais=descricaoDeQuais;
        this.descricaoFrequencia=descricaoFrequencia;







    }

}
