package com.example.funcionariokotlin

class Funcionario {
    var nome : String? = null;
    var cpf : Long = 0
    var chapa : Int = 0
    var idade : Byte = 0
    var valorHora : Float = 0F
    var cargaHorariaMes : Double = 0.0

    fun calcularSalarioBase(): Double {
        return this.valorHora * this.cargaHorariaMes
    }

    override fun toString(): String {
        return "Funcionario\n" +
                "Nome : $nome\n" +
                "CPF : $cpf\n" +
                "Chapa : $chapa\n" +
                "Idade : $idade\n" +
                "Valor Hora : R$ $valorHora\n" +
                "Carga Horaria Mes : $cargaHorariaMes\n" +
                "Salário : R$ ${calcularSalarioBase()}"
    }


}