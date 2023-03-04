package com.example.saque;

public class Saque {
    private int valor;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int calcularNotasDe100(){
        /*int notas = 0;
        while ( this.getValor() >= 100){
            notas++;
            this.setValor(this.getValor() - 100);
        }*/
        return this.valor / 100;
    }

    public int calcularNotasDe50(){
        /*int notas = 0;
        while ( this.getValor() >= 50){
            notas++;
            this.setValor(this.getValor() - 50);
        }*/
        return this.valor % 100 / 50;
    }

    public int calcularNotasDe5(){
        /*int notas = 0;
        while ( this.getValor() >= 5){
            notas++;
            this.setValor(this.getValor() - 5);
        }*/
        return  this.valor % 100 % 50  / 5;
    }

    public int calcularNotasDe1(){
        /*int notas = 0;
        while ( this.getValor() >= 1){
            notas++;
            this.setValor(this.getValor() - 1);
        }*/
        return  this.valor % 100 % 50 % 5/ 1;
    }

    @Override
    public String toString() {
        return "Valor do saque: R$ " + this.getValor() +
                "\nNotas de 100 R$ " + this.calcularNotasDe100() +
                "\nNotas de 50 R$ " + this.calcularNotasDe50() +
                "\nNotas de 5 R$ " + this.calcularNotasDe5() +
                "\nNotas de 1 R$ " + this.calcularNotasDe1()
                ;
    }
}
