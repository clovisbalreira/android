package com.example.associacao;

public class Data {
    private byte dia;
    private byte mes;
    private int ano;

    public byte getDia() {
        return dia;
    }

    public void setDia(byte dia) {
        this.dia = dia;
    }

    public byte getMes() {
        return mes;
    }

    public void setMes(byte mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean validarData(){
        return this.getDia() >= 1 && this.getDia() <= 31 && this.getMes() >= 1 && this.getMes() <= 12 && this.getAno() >= 0 && ( (this.getMes() == 1 || this.getMes() == 3 || this.getMes() == 5 || this.getMes() == 7 || this.getMes() == 8 || this.getMes() == 10 || this.getMes() == 12) || ((this.getMes() == 4 || this.getMes() == 6 || this.getMes() == 9 || this.getMes() == 11)  && this.getDia() <= 30) || (this.getMes() == 2 && (this.getAno() % 4 == 0 && ( this.getAno() % 100 != 0 || this.getAno() % 400 == 0 ) && this.getDia() == 29) || this.getDia() <= 28) );
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano ;
    }
}
