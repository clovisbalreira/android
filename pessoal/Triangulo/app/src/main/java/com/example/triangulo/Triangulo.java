package com.example.triangulo;

public class Triangulo {
    private double ladoA;
    private double ladoB;
    private double ladoC;
    private double anguloAB;
    private double anguloBC;
    private double anguloCA;

    public double getLadoA() {
        return ladoA;
    }

    public void setLadoA(double ladoA) {
        this.ladoA = ladoA;
    }

    public double getLadoB() {
        return ladoB;
    }

    public void setLadoB(double ladoB) {
        this.ladoB = ladoB;
    }

    public double getLadoC() {
        return ladoC;
    }

    public void setLadoC(double ladoC) {
        this.ladoC = ladoC;
    }

    public double getAnguloAB() {
        return anguloAB;
    }

    public void setAnguloAB(double anguloAB) {
        this.anguloAB = anguloAB;
    }

    public double getAnguloBC() {
        return anguloBC;
    }

    public void setAnguloBC(double anguloBC) {
        this.anguloBC = anguloBC;
    }

    public double getAnguloCA() {
        return anguloCA;
    }

    public void setAnguloCA(double anguloCA) {
        this.anguloCA = anguloCA;
    }

    public boolean validarTriangulo(){
        return this.ladoA < this.ladoB + this.ladoC && this.ladoB < this.ladoA + this.ladoC && this.ladoC < this.ladoA + this.ladoB && this.anguloAB + this.anguloBC + this.anguloCA == 180 && this.anguloAB > 0 && this.anguloBC > 0 && this.anguloCA > 0;
    }

    public String classificarAngulos(){
        if(this.anguloAB > 90 || this.getAnguloBC() > 90 || this.getAnguloCA() >
                90){
            return "Obtusângulo";
        }else if(this.anguloAB < 90 && this.getAnguloBC() < 90 && this.getAnguloCA() < 90){
            return "acutânculo";
        }else {
            return "retangulo";
        }
    }

    public String classificarLados(){
        if(this.getLadoA() == this.getLadoB() && this.getLadoA() == this.getLadoC()){
            return "Equilátero";
        }else if(this.getLadoA() != this.getLadoB() && this.getLadoA() != this.getLadoC() && this.getLadoB() != this.getLadoC()){
            return "Escaleno";
        }else{
            return "Isósceles";
        }
    }

    @Override
    public String toString() {
        return "Triangulo: " +
                "\nLado A: " + this.getLadoA() +
                "\nLado B: " + this.getLadoB() +
                "\nLado C: " + this.getLadoC() +
                "\nÂngulo AB: " + this.getAnguloAB() +
                "\nÂngulo BC: " + this.getAnguloBC() +
                "\nÂngulo CA: " + this.getAnguloCA() +
                "\nClassificação Lados: " + this.classificarLados() +
                "\nClassificação Angulo: " + this.classificarAngulos()
                ;
    }
}
