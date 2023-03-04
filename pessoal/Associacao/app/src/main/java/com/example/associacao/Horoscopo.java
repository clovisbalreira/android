package com.example.associacao;

public class Horoscopo {
    private Data dataAtual;
    private Pessoa pessoa;

    public Horoscopo() {
        this.dataAtual = new Data();
        this.pessoa = new Pessoa();
    }

    public Data getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(Data dataAtual) {
        this.dataAtual = dataAtual;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String mostrarSigno(){
        if(this.pessoa.getDataNascimento().validarData()){
            switch (this.pessoa.getDataNascimento().getMes()){
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
        }else{
            return "";
        }
    }

    public String signo(String primeiro, String segundo, int dia){
        if(this.pessoa.getDataNascimento().getDia() <= dia ){
            return primeiro;
        }else{
            return segundo;
        }
    }

    public byte calcularIdade(){
        if(this.dataAtual.getMes() < this.pessoa.getDataNascimento().getMes() || this.dataAtual.getMes() == this.pessoa.getDataNascimento().getMes() && this.dataAtual.getDia() < this.pessoa.getDataNascimento().getDia()){
            return (byte) (this.dataAtual.getAno() - this.pessoa.getDataNascimento().getAno() - 1 );
        }else{
            return (byte) (this.dataAtual.getAno() - this.pessoa.getDataNascimento().getAno());
        }
    }

    public String parabenizar(){
        if(this.dataAtual.getDia() == this.pessoa.getDataNascimento().getDia() && this.dataAtual.getMes() == this.pessoa.getDataNascimento().getMes()){
            return "\nFeliz Aniversário!!!";
        }else{
            return "";
        }
    }

    @Override
    public String toString() {
        if(this.dataAtual.validarData() && this.pessoa.getDataNascimento().validarData()){
            return "Dados da pessoa \n" + pessoa + "\n" +
                    "Data Atual: " + dataAtual + "\n" +
                    this.pessoa.getNome() + ", você é do signo de " + this.mostrarSigno() + " e tens " + this.calcularIdade() + " anos." + this.parabenizar();
        }else{
            return "Data incorreta";
        }
    }
}
