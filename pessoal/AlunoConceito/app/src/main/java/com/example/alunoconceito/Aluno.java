package com.example.alunoconceito;

public class Aluno {
    private String nome;
    private double media;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String verificarConceito(){
        if(this.getMedia() >= 11){
            return "Nota Invalida";
        }else if(this.getMedia() >= 9){
            return "A";
        }else if(this.getMedia() >= 8){
            return "B";
        }else if(this.getMedia() >= 6){
            return "C";
        }else{
            return "D";
        }
    }

    @Override
    public String toString() {
        return  "Nome: " + this.getNome() +
                "\nMédia: " + this.getMedia() +
                "\nConceito: " + this.verificarConceito();
    }
}
