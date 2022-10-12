package com.example.funcionariokotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var nome = findViewById(R.id.edtNome) as EditText
        var cpf = findViewById(R.id.edtCpf) as EditText
        var chapa = findViewById(R.id.edtChapa) as EditText
        var idade = findViewById(R.id.edtIdade) as EditText
        var valorHora = findViewById(R.id.edtValorHora) as EditText
        var cargaHorariaMes = findViewById(R.id.edtCargaHorariaMes) as EditText
        var cadastro = findViewById(R.id.btnCadastro) as Button

        cadastro.setOnClickListener {
            var objFuncionario = Funcionario()
            objFuncionario.nome = nome.text.toString()
            objFuncionario.cpf = cpf.text.toString().toLong()
            objFuncionario.chapa = chapa.text.toString().toInt()
            objFuncionario.idade = idade.text.toString().toByte()
            objFuncionario.valorHora = valorHora.text.toString().toFloat()
            objFuncionario.cargaHorariaMes = cargaHorariaMes.text.toString().toDouble()

            val intent = Intent(applicationContext, DadosFuncionario::class.java)
            val params = Bundle()
            params.putString("funcionario", objFuncionario.toString())
            intent.putExtras(params)
            startActivity(intent)
        }
    }
}