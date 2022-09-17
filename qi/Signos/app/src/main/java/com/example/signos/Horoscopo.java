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

    public void setDiaNasc(byte diaNasc) { this.diaNasc = diaNasc;
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
        diaAt = 16;
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
                (this.getMesNasc() == 2 && (this.getAnoNasc() % 4 == 0 && ( this.getAnoNasc() % 100 != 0 || this.getAnoNasc() % 400 == 0 ) && this.getDiaNasc() == 29) || this.getDiaNasc() <= 28));
    }

    public String mostrarSigno(){
        if(validarData()){
            if(this.getDiaNasc() >= 20 && this.getMesNasc() == 3 || this.getDiaNasc() <= 20 && this.getMesNasc() == 4){
                return "Áries";
            }else if(this.getDiaNasc() >= 21 && this.getMesNasc() == 4 || this.getDiaNasc() <= 20 && this.getMesNasc() == 5){
                return "Touro";
            }else if(this.getDiaNasc() >= 21 && this.getMesNasc() == 5 || this.getDiaNasc() <= 20 && this.getMesNasc() == 6){
                return "Gêmeos";
            }else if(this.getDiaNasc() >= 21 && this.getMesNasc() == 6 || this.getDiaNasc() <= 21 && this.getMesNasc() == 7){
                return "Câncer";
            }else if(this.getDiaNasc() >= 22 && this.getMesNasc() == 7 || this.getDiaNasc() <= 22 && this.getMesNasc() == 8){
                return "Leão";
            }else if(this.getDiaNasc() >= 23 && this.getMesNasc() == 8 || this.getDiaNasc() <= 22 && this.getMesNasc() == 9){
                return "Virgem";
            }else if(this.getDiaNasc() >= 23 && this.getMesNasc() == 9 || this.getDiaNasc() <= 22 && this.getMesNasc() == 10){
                return "Libra";
            }else if(this.getDiaNasc() >= 23 && this.getMesNasc() == 10 || this.getDiaNasc() <= 21 && this.getMesNasc() == 11){
                return "Escorpião";
            }else if(this.getDiaNasc() >= 22 && this.getMesNasc() == 11 || this.getDiaNasc() <= 21 && this.getMesNasc() == 12){
                return "Sagitário";
            }else if(this.getDiaNasc() >= 22 && this.getMesNasc() == 12 || this.getDiaNasc() <= 20 && this.getMesNasc() == 1){
                return "Capricórnio";
            }else if(this.getDiaNasc() >= 21 && this.getMesNasc() == 1 || this.getDiaNasc() <= 18 && this.getMesNasc() == 2){
                return "Aquário";
            }else{
                return "Peixes";
            }
        }else{
            return "";
        }
    }

    public byte calcularIdade(){
        if(this.getMesAt() <= this.getMesNasc()){
            if(this.getDiaAt() < this.getDiaNasc()){
                return (byte) (this.getAnoAt() - this.getAnoNasc() - 1 );
            }else{
                return (byte) (this.getAnoAt() - this.getAnoNasc());
            }
        }else{
            return (byte) (this.getAnoAt() - this.getAnoNasc());
        }
    }

    public String parabenizar(){
        if(this.getDiaAt() == this.getDiaNasc() && this.getMesAt() == this.getMesNasc()){
            return "\nFeliz Aniversário!!!";
        }else{
            return "";
        }
    }

    @Override
    public String toString() {
        if(this.validarData()){
            return this.validarData() +"   "+ this.getNome() + " você é do signo de " + this.mostrarSigno() + " e tem " + this.calcularIdade() + " anos." + parabenizar();
        }else{
            return "Data Inválida";
        }
    }
}