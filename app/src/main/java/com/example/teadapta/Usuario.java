package com.example.teadapta;

public class Usuario {
    public String nome;
    public int idade;
    public double peso;
    public double altura;
    public String escolhaValue; // Adicione este campo
    public String escolaridadeValue;
    public String escolarValue;


    public String nomeMae;
    public int idadeMae;
    public Usuario() {
        // Construtor vazio necessário para o Firebase
    }

    public Usuario(String nome, int idade, double peso, double altura, String escolhaValue, String escolaridadeValue, String escolarValue
    ,String nomeMae,int idadeMae) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.escolhaValue = escolhaValue;
        this.escolaridadeValue = escolaridadeValue;
        this.escolarValue = escolarValue;

        this.nomeMae = nomeMae;
        this.idadeMae = idadeMae;
    }
}
