package com.example.associacao;

public class Pessoa {
    private String nome;
    private Data dataNascimento;

    public Pessoa() {
        this.dataNascimento = new Data();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "Data Nascimento: " + dataNascimento ;
    }
}
