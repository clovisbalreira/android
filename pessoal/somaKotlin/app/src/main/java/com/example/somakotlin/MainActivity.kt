package com.example.somakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    /*
    lateinit var valor1 : EditText
    lateinit var valor2 : EditText
    lateinit var resultado : TextView
    lateinit var botao : Button
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var valor1 = findViewById(R.id.editValor1) as EditText
        var valor2 = findViewById(R.id.editValor2) as EditText
        var resultado = findViewById(R.id.txtResposta) as TextView
        var botao = findViewById(R.id.btnCalcular) as Button

        botao.setOnClickListener {
            var v1 = valor1.text.toString().toDouble()
            var v2 = valor2.text.toString().toDouble()
            var soma = v1 + v2
            resultado.text = "A soma é $soma"
        }
    }
     fun calcular(){

     }
}