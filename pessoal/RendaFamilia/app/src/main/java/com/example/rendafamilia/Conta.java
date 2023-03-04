package com.example.rendafamilia;


public class Conta {
    private int id;
    private String nome;
    private Double preco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return  "Nome: " + nome + '\'' +
                "Preço: R$ " + preco ;
    }
}
