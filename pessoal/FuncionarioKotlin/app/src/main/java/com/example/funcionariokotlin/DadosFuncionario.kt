package com.example.funcionariokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class DadosFuncionario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dados_funcionario)
        var saida = findViewById(R.id.txtSaida) as TextView
        val dadosFuncionario = intent.getStringExtra("funcionario")
        saida.text = dadosFuncionario
    }
}