package com.example.signos;

public class Horoscopo {
    private String nome;
    private byte diaNasc, mesNasc, diaAt, mesAt;
    private int anoNasc, anoAt;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte getDiaNasc() {
        return diaNasc;
    }

    public void setDiaNasc(byte diaNasc) {
        this.diaNasc = diaNasc;
    }

    public byte getMesNasc() {
        return mesNasc;
    }

    public void setMesNasc(byte mesNasc) {
        this.mesNasc = mesNasc;
    }

    public byte getDiaAt() {
        return diaAt;
    }

    public void setDiaAt(byte diaAt) {
        this.diaAt = diaAt;
    }

    public byte getMesAt() {
        return mesAt;
    }

    public void setMesAt(byte mesAt) {
        this.mesAt = mesAt;
    }

    public int getAnoNasc() {
        return anoNasc;
    }

    public void setAnoNasc(int anoNasc) {
        this.anoNasc = anoNasc;
    }

    public int getAnoAt() {
        return anoAt;
    }

    public void setAnoAt(int anoAt) {
        this.anoAt = anoAt;
    }

    public boolean validarData(){
        return ((this.getDiaNasc() >= 1 && this.getDiaNasc() <= 31) && (this.getAnoNasc() >= 0) &&
                (this.getMesNasc() == 1 || this.getMesNasc() == 3 || this.getMesNasc() == 5 || this.getMesNasc() == 7 || this.getMesNasc() == 8 || this.getMesNasc() == 10 || this.getMesNasc() == 12)
                || ((this.getMesNasc() == 4 || this.getMesNasc() == 6 || this.getMesNasc() == 9 || this.getMesNasc() == 11)  && this.getDiaNasc() <= 30) ||
                (this.getMesNasc() == 2 && (this.getAnoNasc() % 4 == 0 && ( this.getAnoNasc() % 100 != 0 || this.getAnoNasc() % 400 == 0 ) && this.getDiaNasc() == 29) || this.getDiaNasc() == 28));
    }

    public String mostrarSigno(){
        return "";
    }

    public byte calcularIdade(){
        return 1;
    }

    public String parabenizar(){
        return "";
    }

    @Override
    public String toString() {
        return this.getNome() + "você é do signo de " + this.mostrarSigno() + " e tem " + this.calcularIdade();
    }
}
