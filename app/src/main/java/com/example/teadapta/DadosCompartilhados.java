package com.example.teadapta;

public class DadosCompartilhados {
    private static DadosCompartilhados instance;
    private String nome;
    private int idade;
    private double peso;
    private double altura;
    private String escolhaValue;
    private String escolaridadeValue;
    private String escolarValue;

    private String nomeMae;
    private int idadeMae;

    private DadosCompartilhados() {
        // Construtor privado para impedir a criação direta de instâncias
    }

    public static DadosCompartilhados getInstance() {
        if (instance == null) {
            instance = new DadosCompartilhados();
        }
        return instance;
    }

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
}


