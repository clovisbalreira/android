package com.example.aluno;

public class Aluno {
    private String nome;
    private double nota1;
    private double nota2;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double calcularMedia(){
        return (this.getNota1() + this.getNota2()) / 2 ;
    }

    public String verificarSituacao(){
        if(this.calcularMedia() >= 6){
            return "Aprovado";
        }else {
            return "Reprovado";
        }
    }

    @Override
    public String toString() {
        return "O Aluno " + this.getNome() +
                "\nSuas notas foram: " +
                "\n\tNota 1: " + this.getNota1() +
                "\n\tNota 2: " + this.getNota2() +
                "\n\tSua média foi: " + this.calcularMedia() +
                "\n\tSua situação é de " + this.verificarSituacao();
    }
}
