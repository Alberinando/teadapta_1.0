package com.example.teadapta;

public class Usuario {


    //......................Anamnese Desenvolvimento SocioEmocional2................................

    public String investeMomentosFamilia;
    public String medosFobias;


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

    //........................................Fim...................................................



    //...........................Anamnese Desenvolvimento Linguistico...............................
    public String frase;
    public String primeirasPalavras;
    public String vocalizou;
    public String respondeuSomHumano;
    public String respondruSom;

    public String problemasComunicacao;


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

    //..................................Fim.............................................
    public Usuario() {
        // Construtor vazio necessário para o Firebase
    }

    public Usuario(//....................anamnese..............................................................
            String nome, int idade, double peso, double altura, String escolhaValue, String escolaridadeValue, String escolarValue
            //..............................anamnese pai.........................................................
            , String nomeMae, int idadeMae, String telefoneMae, String formacaoAcademica,String profissaoMae, String nomePai,
            int idadePai, String formacaoAcademicaPai, String profissaoPai,String telefonePai


            //..............................Anamnese Desenvolvimento.................................................
            ,int andouSemApoio,int sustentouCabeca,int rolouLateralmente,int virouSe,int sentouComApoio,int arrastou,int engatinhou
            ,int ficouDePeComApoio,int ficouDePeSemApoio,int andouComApoio

             //............................Anamnese Desenvolvimento Crianca.........................................................

            , String usoDuasMaos,String dificuldadeCordenacao,String caiComFrequencia,String apanhaObjetosSemDiculdade,
                   String imitaGestosSimples,String arremessaObjetosSemDiculdade,String seguraObjetosSemDiculdade,
                   String formasPeculiaresDeOrganizacaoMotora,

                   //...........................Anamnese Desenvolvimento Linguistico...............................

                   String frase, String primeirasPalavras,String vocalizou,String respondeuSomHumano,String respondruSom,
                   String problemasComunicacao,

                   //......................Anamnese Desenvolvimento SocioEmocional................................

                   String reageFavoravelmentePessoa,String brincaCriancaAdulto,String expressaNecessidades,
                   String apresentaBirrasComFrequencia,String seAdaptaCasaEscola,String choraFrequencia,String fazAmigosFacilidade,
                   String expressaEmocoesComFacilidade,String mudaComportamentoComEstranho,String reageFavoravelmenteNovidades,
                   String procuraProtecaoPais,

                   //......................Anamnese Desenvolvimento SocioEmocional2................................

                   String investeMomentosFamilia,String medosFobias) {




        //..................anamnese.....................................................
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.escolhaValue = escolhaValue;
        this.escolaridadeValue = escolaridadeValue;
        this.escolarValue = escolarValue;


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

        //.......................................Fim...............................................


        //......................Anamnese Desenvolvimento SocioEmocional2.............................

        this.investeMomentosFamilia = investeMomentosFamilia;
        this.medosFobias = medosFobias;

        //.......................................Fim...............................................

    }
}
