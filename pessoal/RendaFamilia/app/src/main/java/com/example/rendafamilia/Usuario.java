package com.example.rendafamilia;

import java.io.Serializable;

public class Usuario implements Serializable {
    private int id;
    private String nome;
    private double salario;
    private String usuario;
    private String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + '\n' +
                "Salário: R$ " + salario + "\n" +
                "Usuario: " + usuario + "\n" +
                "Senha: " + senha
                ;
    }
}
