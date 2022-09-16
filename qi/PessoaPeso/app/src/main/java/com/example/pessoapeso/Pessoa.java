package com.example.pessoapeso;

public class Pessoa {
    private double altura;
    private byte sexo;
    private double pesoAtual;

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public byte getSexo() {
        return sexo;
    }

    public void setSexo(byte sexo) {
        this.sexo = sexo;
    }

    public double getPesoAtual() {
        return pesoAtual;
    }

    public void setPesoAtual(double pesoAtual) {
        this.pesoAtual = pesoAtual;
    }

    public double calcularPesoIdeal(){
        if(this.getSexo() == 1){
            return (62.1 * this.getAltura()) - 44.7;
        }else{
            return (72.7 * this.getAltura()) - 58;
        }
    }

    public String verificarPeso(){
        if(this.getPesoAtual() < this.calcularPesoIdeal() - 2){
            return "Abaixo do peso";
        }else if(this.getPesoAtual() > this.calcularPesoIdeal() + 2){
            return "Acima do peso";
        }else{
            return "Peso Ideal";
        }
    }

    @Override
    public String toString() {
        String s;
        if(this.sexo >= 1 && this.sexo <= 2){
            if(this.sexo == 1){
                s = "Feminino";
            }else {
                s = "Masculino";
            }
        }else {
            s = "Sexo invalido";
        }
        return "Altura: " + altura +
                "\nSexo: " + s +
                "\nPeso Atual: " + pesoAtual +
                "\nPeso Ideal: " + this.calcularPesoIdeal() +
                "\n" + verificarPeso();
    }
}
