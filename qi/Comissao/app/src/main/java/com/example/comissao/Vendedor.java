package com.example.comissao;

public class Vendedor {
    private String nome;
    private double meta;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMeta() {
        return meta;
    }

    public void setMeta(double meta) {
        this.meta = meta;
    }

    public double calcularComissao(double valorVendido){
        double valorXmeta = valorVendido / this.getMeta();
        if( valorXmeta < 0.5){
            return valorVendido * 0.01;
        }else if(valorXmeta <= 0.75){
            return valorVendido * 0.025;
        }else if(valorXmeta <= 1){
            return valorVendido * 0.035;
        }else{
            return valorVendido * 0.05;
        }
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() +
                "\nMeta: R$ " + this.getMeta();
    }
}
