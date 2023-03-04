package com.example.alunokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var nome : EditText
    lateinit var nota1 : EditText
    lateinit var nota2 : EditText
    lateinit var resposta : TextView
    lateinit var botao : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nome = findViewById(R.id.edtNome)
        nota1 = findViewById(R.id.edtNota1)
        nota2 = findViewById(R.id.edtNota2)
        resposta = findViewById(R.id.txtResposta)
        botao = findViewById(R.id.btnCalcular)

        botao.setOnClickListener {
            var aluno = nome.text.toString()
            var n1 = nota1.text.toString().toDouble()
            var n2 = nota2.text.toString().toDouble()
            var media = ( n1 + n2 ) / 2
            var situacao : String = ""
            if (media >= 6){
                situacao = "Aprovado"
            }else{
                situacao = "Reprovado"
            }
            resposta.text = "Dados do aluno\n" +
                    "Nome: $aluno\n" +
                    "Nota 1 $n1\n" +
                    "Nota 2 $n2\n" +
                    "Média: $media\n" +
                    "Situação: $situacao."
        }
    }

}