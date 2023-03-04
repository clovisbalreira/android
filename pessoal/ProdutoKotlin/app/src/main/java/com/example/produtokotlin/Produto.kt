package com.example.produtokotlin

class Produto {
    var nome : String? = null
    var descricao : String? = null
    var valorUnitario : Double = 0.0
    var quantidade : Int = 0

    fun calcularTotal() : Double{
        return this.valorUnitario * this.quantidade
    }

    override fun toString(): String {
        return "Produto\n" +
                "Nome: $nome\n" +
                "Descrição: $descricao\n" +
                "Valor Unitário: R$ $valorUnitario\n" +
                "Quantidade: $quantidade\n" +
                "Valor Total: R$ ${this.calcularTotal()}"
    }
}