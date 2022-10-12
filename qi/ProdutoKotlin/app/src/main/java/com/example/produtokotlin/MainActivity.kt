package com.example.produtokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var nome = findViewById(R.id.edtProduto) as EditText
        var descricao = findViewById(R.id.edtDescricao) as EditText
        var valor = findViewById(R.id.edtValor) as EditText
        var quantidade = findViewById(R.id.edtQuantidade) as EditText
        var resposta = findViewById(R.id.txtResposta) as TextView
        var botao = findViewById(R.id.btnCalcular) as Button

        botao.setOnClickListener {
            var objProduto = Produto()
            objProduto.nome = nome.text.toString()
            objProduto.descricao = descricao.text.toString()
            objProduto.valorUnitario = valor.text.toString().toDouble()
            objProduto.quantidade = quantidade.text.toString().toInt()
            resposta.text = objProduto.toString()
        }
    }
}