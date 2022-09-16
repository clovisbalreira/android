package com.example.nadador;

public class Nadador {
    private String nome;
    private int idade;

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

    public String classificarNadador(){
        if(this.getIdade() >= 8 && this.getIdade() <= 10 ){
            return "Infantil";
        }else if(this.getIdade() >= 11 && this.getIdade() <= 17 ){
            return "Juvenil";
        }else if(this.getIdade() >= 18 && this.getIdade() <= 49 ){
            return "Adulto";
        }else if(this.getIdade() >= 50 && this.getIdade() <= 60 ){
            return "Terceira Idade";
        }else{
            return "Não pode ser nadador";
        }
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() +
                "\nIdade: " + this.getIdade() +
                "\nCategoria: " + this.classificarNadador();
    }
}
