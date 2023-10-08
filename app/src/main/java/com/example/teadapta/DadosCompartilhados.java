package com.example.teadapta;

public class DadosCompartilhados {
    private static DadosCompartilhados instance;
    
    //......................................anamnese.............................................
    private String nome;
    private int idade;
    private double peso;
    private double altura;

    private String escolhaValue;
    private String escolaridadeValue;
    private String escolarValue;
    //...................................Fim...................................................
    
    //...................................Anamenese Pai.........................................

    private String nomeMae;
    private int idadeMae;
    private String telefoneMae;
    private String profissaoPai;
    private String formacaoAcademicaPai;
    private int idadePai;
    private String telefonePai;
    private String nomePai;
    private String formacaoAcademica;
    private String profissaoMae;
    private String escolhaValores;
    //..............................................Fim............................................
    
    

    
    
    //......................................Anamnese Desenvolvimento................................
    private int andouSemApoio;
    private int sustentouCabeca;
    private int rolouLateralmente;
    private int virouse;
    private int sentouComApoio;
    private int arrastou;
    private int engatinhou;
    private int ficouDePeComApoio;
    private int ficouDePeSemApoio;
    private int andouComApio;
    private int virouSe;
    private int andouComApoio;
    
    
    //...............................................Fim...........................................


    

    //..........................Anamnese Desenvolvimento Linguistico...............................

    private String frase;
    private String primeirasPalavras;
    private String vocalizou;
    private String respondeuSomHumano;
    private String respondruSom;
    private String problemasComunicacao;


    //................................................Fim...........................................


    //........................Anamnese Desenvolvimento Crianca......................................
    private String usoDuasMaos;
    private String dificuldadeCordenacao;
    private String caiComFrequencia;
    private String apanhaObjetosSemDiculdade;
    private String imitaGestosSimples;
    private String arremessaObjetosSemDiculdade;
    private String seguraObjetosSemDiculdade;
    private String formasPeculiaresDeOrganizacaoMotora;



    //..................................Fim.........................................................


    //......................Anamnese Desenvolvimento SocioEmocional................................


    private String reageFavoravelmentePessoa;
    private String expressaNecessidades;
    private String brincaCriancaAdulto;
    private String apresentaBirrasComFrequenciae;
    private String seAdaptaCasaEscola;
    private String choraFrequencia;
    private String fazAmigosFacilidade;
    private String expressaEmocoesComFacilidade;
    private String mudaComportamentoComEstranho;
    private String reageFavoravelmenteNovidades;
    private String procuraProtecaoPais;


    //..................................Fim.........................................................


    //......................Anamnese Desenvolvimento SocioEmocional2................................

    private String investeMomentosFamilia;
    private String medosFobias;
    private String apresentaBirrasComFrequencia;

    //..................................Fim.........................................................


    private DadosCompartilhados() {
        // Construtor privado para impedir a criação direta de instâncias
    }

    public static DadosCompartilhados getInstance() {
        if (instance == null) {
            instance = new DadosCompartilhados();
        }
        return instance;
    }
    
    
    //................................Anamnese.......................................

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getEscolhaValue() {
        return escolhaValue;
    }

    public void setEscolhaValue(String escolhaValue) {
        this.escolhaValue = escolhaValue;
    }

    public String getEscolaridadeValue() {
        return escolaridadeValue;
    }

    public void setEscolaridadeValue(String escolaridadeValue) {
        this.escolaridadeValue = escolaridadeValue;
    }

    public String getEscolarValue() {
        return escolarValue;
    }

    public void setEscolarValue(String escolarValue) {
        this.escolarValue = escolarValue;
    }
    
    
    //....................................Fim.................................................
    
    
    
    //...................................Anamnese Pai.........................................
    
    

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public int getIdadeMae() {
        return idadeMae;
    }

    public void setIdadeMae(int idadeMae) {
        this.idadeMae = idadeMae;
    }

    public void setTelefoneMae(String telefoneMae) {
        this.telefoneMae = telefoneMae;
    }

    public String getTelefoneMae() {
        return telefoneMae;
    }

    public void setProfissaoMae(String profissaoMae) {
        this.profissaoMae = profissaoMae;
    }

    public String getProfissaoMae() {
        return profissaoMae;
    }

    public void setFormacaoAcademica(String formacaoAcademica) {
        this.formacaoAcademica = formacaoAcademica;
    }

    public String getFormacaoAcademica() {
        return formacaoAcademica;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setIdadePai(int idadePai) {
        this.idadePai = idadePai;
    }

    public int getIdadePai() {
        return idadePai;
    }

    public void setTelefonePai(String telefonePai) {
        this.telefonePai = telefonePai;
    }

    public String getTelefonePai() {
        return telefonePai;
    }

    public void setFormacaoAcademicaPai(String formacaoAcademicaPai) {
        this.formacaoAcademicaPai = formacaoAcademicaPai;
    }

    public String getFormacaoAcademicaPai() {
        return formacaoAcademicaPai;
    }

    public void setProfissaoPai(String profissaoPai) {
        this.profissaoPai = profissaoPai;
    }

    public String getProfissaoPai() {
        return profissaoPai;
    }
    public void setEscolhaValores(String escolhaValores) {
        this.escolhaValores = escolhaValores;
    }

    public String getEscolhaValores() {
        return escolhaValores;
    }
    
    
    
    //...................................Fim......................................................
    
    
    
    
    //...................................Anamnese Desenvolvimento..................................

    public void setSustentouCabeca(int sustentouCabeca) {
        this.sustentouCabeca = sustentouCabeca;
    }

    public int getSustentouCabeca() {
        return sustentouCabeca;
    }

    public void setRolouLateralmente(int rolouLateralmente) {
        this.rolouLateralmente = rolouLateralmente;
    }

    public int getRolouLateralmente() {
        return rolouLateralmente;
    }

    public void setVirouse(int virouse) {
        this.virouse = virouse;
    }

    public int getVirouse() {
        return virouse;
    }

    public void setSentouComApoio(int sentouComApoio) {
        this.sentouComApoio = sentouComApoio;
    }

    public int getSentouComApoio() {
        return sentouComApoio;
    }

    public void setArrastou(int arrastou) {
        this.arrastou = arrastou;
    }

    public int getArrastou() {
        return arrastou;
    }

    public void setEngatinhou(int engatinhou) {
        this.engatinhou = engatinhou;
    }

    public int getEngatinhou() {
        return engatinhou;
    }

    public void setFicouDePeComApoio(int ficouDePeComApoio) {
        this.ficouDePeComApoio = ficouDePeComApoio;
    }

    public int getFicouDePeComApoio() {
        return ficouDePeComApoio;
    }

    public void setFicouDePeSemApoio(int ficouDePeSemApoio) {
        this.ficouDePeSemApoio = ficouDePeSemApoio;
    }

    public int getFicouDePeSemApoio() {
        return ficouDePeSemApoio;
    }

    public void setAndouComApio(int andouComApio) {
        this.andouComApio = andouComApio;
    }

    public int getAndouComApio() {
        return andouComApio;
    }

    public void setAndouSemApoio(int andouSemApoio) {
        this.andouSemApoio = andouSemApoio;
    }

    public int getAndouSemApoio() {
        return andouSemApoio;
    }

    public int getVirouSe() {
        return virouSe;
    }

    public void setVirouSe(int virouSe) {
        this.virouSe = virouSe;
    }

    public int getAndouComApoio() {
        return andouComApoio;
    }

    public void setAndouComApoio(int andouComApoio) {
        this.andouComApoio = andouComApoio;
    }
    //.......................................Fim..................................................
    
    //...................................Anamnese Desenvolvimento Linguistico.....................

    public void setRespondruSom(String respondruSom) {
        this.respondruSom = respondruSom;
    }

    public String getRespondruSom() {
        return respondruSom;
    }


    public void setRespondeuSomHumano(String respondeuSomHumano) {
        this.respondeuSomHumano = respondeuSomHumano;
    }

    public String getRespondeuSomHumano() {
        return respondeuSomHumano;
    }

    public void setVocalizou(String vocalizou) {
    }

    public void setPrimeirasPalavras(String primeirasPalavras) {
        this.primeirasPalavras = primeirasPalavras;
    }

    public String getPrimeirasPalavras() {
        return primeirasPalavras;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public String getFrase() {
        return frase;
    }

    public void setProblemasComunicacao(String problemasComunicacao) {
        this.problemasComunicacao = problemasComunicacao;
    }

    public String getProblemasComunicacao() {
        return problemasComunicacao;
    }


    //.......................................Fim...............................................



    //...........................Anamnese Desenvolvimento Crianca..............................



    public void setUsoDuasMaos(String usoDuasMaos) {
        this.usoDuasMaos = usoDuasMaos;
    }

    public String getUsoDuasMaos() {
        return usoDuasMaos;
    }


    public void setDificuldadeCordenacao(String dificuldadeCordenacao) {
        this.dificuldadeCordenacao = dificuldadeCordenacao;
    }

    public String getDificuldadeCordenacao() {
        return dificuldadeCordenacao;
    }

    public void setCaiComFrequencia(String caiComFrequencia) {
        this.caiComFrequencia = caiComFrequencia;
    }

    public String getCaiComFrequencia() {
        return caiComFrequencia;
    }

    public void setApanhaObjetosSemDiculdade(String apanhaObjetosSemDiculdade) {
        this.apanhaObjetosSemDiculdade = apanhaObjetosSemDiculdade;
    }

    public String getApanhaObjetosSemDiculdade() {
        return apanhaObjetosSemDiculdade;
    }

    public void setImitaGestosSimples(String imitaGestosSimples) {
        this.imitaGestosSimples = imitaGestosSimples;
    }

    public String getImitaGestosSimples() {
        return imitaGestosSimples;
    }

    public void setArremessaObjetosSemDiculdade(String arremessaObjetosSemDiculdade) {
        this.arremessaObjetosSemDiculdade = arremessaObjetosSemDiculdade;
    }

    public String getArremessaObjetosSemDiculdade() {
        return arremessaObjetosSemDiculdade;
    }

    public void setSeguraObjetosSemDiculdade(String seguraObjetosSemDiculdade) {
        this.seguraObjetosSemDiculdade = seguraObjetosSemDiculdade;
    }

    public String getSeguraObjetosSemDiculdade() {
        return seguraObjetosSemDiculdade;
    }

    public void setFormasPeculiaresDeOrganizacaoMotora(String formasPeculiaresDeOrganizacaoMotora) {
        this.formasPeculiaresDeOrganizacaoMotora = formasPeculiaresDeOrganizacaoMotora;
    }

    public String getFormasPeculiaresDeOrganizacaoMotora() {
        return formasPeculiaresDeOrganizacaoMotora;
    }
    //....................................Fim.......................................................



    //......................Anamnese Desenvolvimento SocioEmocional.................................
    public void setReageFavoravelmentePessoa(String reageFavoravelmentePessoa) {
        this.reageFavoravelmentePessoa = reageFavoravelmentePessoa;
    }

    public String getReageFavoravelmentePessoa() {
        return reageFavoravelmentePessoa;
    }


    public void setExpressaNecessidades(String expressaNecessidades) {
        this.expressaNecessidades = expressaNecessidades;
    }

    public String getExpressaNecessidades() {
        return expressaNecessidades;
    }

    public void setBrincaCriancaAdulto(String brincaCriancaAdulto) {
        this.brincaCriancaAdulto = brincaCriancaAdulto;
    }

    public String getBrincaCriancaAdulto() {
        return brincaCriancaAdulto;
    }

    public void setApresentaBirrasComFrequenciae(String apresentaBirrasComFrequenciae) {
        this.apresentaBirrasComFrequenciae = apresentaBirrasComFrequenciae;
    }

    public String getApresentaBirrasComFrequencia() {
        return apresentaBirrasComFrequencia;
    }

    public void setApresentaBirrasComFrequencia(String apresentaBirrasComFrequencia) {
        this.apresentaBirrasComFrequencia = apresentaBirrasComFrequencia;
    }

    public String getSeAdaptaCasaEscola() {
        return seAdaptaCasaEscola;
    }
    public void setSeAdaptaCasaEscola(String seAdaptaCasaEscola) {
        this.seAdaptaCasaEscola = seAdaptaCasaEscola;
    }

    public void setChoraFrequencia(String choraFrequencia) {
        this.choraFrequencia = choraFrequencia;
    }

    public String getChoraFrequencia() {
        return choraFrequencia;
    }

    public void setFazAmigosFacilidade(String fazAmigosFacilidade) {
        this.fazAmigosFacilidade = fazAmigosFacilidade;
    }

    public String getFazAmigosFacilidade() {
        return fazAmigosFacilidade;
    }

    public void setExpressaEmocoesComFacilidade(String expressaEmocoesComFacilidade) {
        this.expressaEmocoesComFacilidade = expressaEmocoesComFacilidade;
    }

    public String getExpressaEmocoesComFacilidade() {
        return expressaEmocoesComFacilidade;
    }

    public void setMudaComportamentoComEstranho(String mudaComportamentoComEstranho) {
        this.mudaComportamentoComEstranho = mudaComportamentoComEstranho;
    }

    public String getMudaComportamentoComEstranho() {
        return mudaComportamentoComEstranho;
    }

    public void setReageFavoravelmenteNovidades(String reageFavoravelmenteNovidades) {
        this.reageFavoravelmenteNovidades = reageFavoravelmenteNovidades;
    }

    public String getReageFavoravelmenteNovidades() {
        return reageFavoravelmenteNovidades;
    }

    public void setProcuraProtecaoPais(String procuraProtecaoPais) {
        this.procuraProtecaoPais = procuraProtecaoPais;
    }

    public String getProcuraProtecaoPais() {
        return procuraProtecaoPais;
    }


    //....................................Fim......................................................



    //......................Anamnese Desenvolvimento SocioEmocional2................................


    public void setMedosFobias(String medosFobias) {
        this.medosFobias = medosFobias;
    }

    public String getMedosFobias() {
        return medosFobias;
    }

    public void setInvesteMomentosFamilia(String investeMomentosFamilia) {
        this.investeMomentosFamilia = investeMomentosFamilia;
    }

    public String getInvesteMomentosFamilia() {
        return investeMomentosFamilia;
    }

    public String getVocalizou() {
        return vocalizou;
    }




    //....................................Fim......................................................


}


