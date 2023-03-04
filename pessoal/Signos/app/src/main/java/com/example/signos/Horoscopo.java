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
        return this.getDiaNasc() >= 1 && this.getDiaNasc() <= 31 && this.getMesNasc() >= 1 && this.getMesNasc() <= 12 && this.getAnoNasc() >= 0 && ( (this.getMesNasc() == 1 || this.getMesNasc() == 3 || this.getMesNasc() == 5 || this.getMesNasc() == 7 || this.getMesNasc() == 8 || this.getMesNasc() == 10 || this.getMesNasc() == 12) || ((this.getMesNasc() == 4 || this.getMesNasc() == 6 || this.getMesNasc() == 9 || this.getMesNasc() == 11)  && this.getDiaNasc() <= 30) || (this.getMesNasc() == 2 && (this.getAnoNasc() % 4 == 0 && ( this.getAnoNasc() % 100 != 0 || this.getAnoNasc() % 400 == 0 ) && this.getDiaNasc() == 29) || this.getDiaNasc() <= 28) );
    }

    public String mostrarSigno(){
        if(validarData()){
            switch (this.mesNasc){
                case 1:
                    return signo("Capricórnio", "Aquário", 20);
                case 2:
                    return signo("Aquário", "Peixes", 18);
                case 3:
                    return signo("Peixes", "Áries", 19);
                case 4:
                    return signo("Áries", "Touro", 20);
                case 5:
                    return signo("Touro", "Gêmeos", 20);
                case 6:
                    return signo("Gêmeos", "Câncer", 20);
                case 7:
                    return signo("Câncer", "Leão", 21);
                case 8:
                    return signo("Leão", "Virgem", 22);
                case 9:
                    return signo("Virgem", "Libra", 22);
                case 10:
                    return signo("Libra", "Escorpião", 22);
                case 11:
                    return signo("Escorpião", "Sagitário", 21);
                case 12:
                    return signo("Sagitário", "Capricórnio", 20);
                default:
                    return "";
            }
                /*case 1:
                    if(this.diaNasc <= 20 ){
                        return "Capricórnio";
                    }else{
                        return "Aquário";
                    }
                case 2:
                    if(this.diaNasc <= 18 ){
                        return "Aquário";
                    }else{
                        return "Peixes";
                    }
                case 3:
                    if(this.diaNasc <= 19 ){
                        return "Peixes";
                    }else{
                        return "Áries";
                    }
                case 4:
                    if(this.diaNasc <= 20 ){
                        return "Áries";
                    }else{
                        return "Touro";
                    }
                case 5:
                    if(this.diaNasc <= 20 ){
                        return "Touro";
                    }else{
                        return "Gêmeos";
                    }
                case 6:
                    if(this.diaNasc <= 20 ){
                        return "Gêmeos";
                    }else{
                        return "Câncer";
                    }
                case 7:
                    if(this.diaNasc <= 21 ){
                        return "Câncer";
                    }else{
                        return "Leão";
                    }
                case 8:
                    if(this.diaNasc <= 22 ){
                        return "Leão";
                    }else{
                        return "Virgem";
                    }
                case 9:
                    if(this.diaNasc <= 22 ){
                        return "Virgem";
                    }else{
                        return "Libra";
                    }
                case 10:
                    if(this.diaNasc <= 22 ){
                        return "Libra";
                    }else{
                        return "Escorpião";
                    }
                case 11:
                    if(this.diaNasc <= 21 ){
                        return "Escorpião";
                    }else{
                        return "Sagitário";
                    }
                case 12:
                    if(this.diaNasc <= 20 ){
                        return "Sagitário";
                    }else{
                        return "Capricórnio";
                    }
                default:
                    return "";
            }*/
            /*if(this.getDiaNasc() >= 20 && this.getMesNasc() == 3 || this.getDiaNasc() <= 20 && this.getMesNasc() == 4){
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
            }else if(this.getDiaNasc() >= 19 && this.getMesNasc() == 2 || this.getDiaNasc() <= 19 && this.getMesNasc() == 3){
                return "Peixes";
            }else{
                return "";
            }*/
        }else{
            return "";
        }
    }

    public String signo(String primeiro, String segundo, int dia){
        if(this.diaNasc <= dia ){
            return primeiro;
        }else{
            return segundo;
        }
    }

    public byte calcularIdade(){
        if(this.getMesAt() <= this.getMesNasc() && this.getDiaAt() < this.getDiaNasc()){
            return (byte) (this.getAnoAt() - this.getAnoNasc() - 1 );
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
            return "Dados pessoais:\n"+
                    "Data de Nascimento: " + this.diaNasc + "/" + this.mesNasc + "/" + this.anoNasc + "\n" +
                    "Data Atual: " + this.diaAt + "/" + this.mesAt + "/" + anoAt + "\n" +
                    this.getNome() + ", você é do signo de " + this.mostrarSigno() + " e tem " + this.calcularIdade() + " anos." + this.parabenizar();
            //return this.getNome() + " você é do signo de " + this.mostrarSigno() + " e tem " + this.calcularIdade() + " anos." + this.parabenizar();
        }else{
            return "Data Inválida";
        }
    }
}