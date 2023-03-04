package com.example.projaoperacoes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText valor1, valor2;
    TextView resposta;
    double v1;
    double v2;
    double soma;
    double subtracao;
    double multiplicacao;
    double divisao;
    double potencia;
    double restoDivisao;
    double raiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valor1 = findViewById(R.id.edtValor1);
        valor2 = findViewById(R.id.edtValor2);
        resposta = findViewById(R.id.txtResultado);
    }

    public void calcular(View view) {
        receberDados();
        soma = v1 + v2;
        subtracao = v1 - v2;
        multiplicacao = v1 * v2;
        divisao = v1 / v2;
        potencia = Math.pow(v1, v2);
        restoDivisao = v1 % v2;
        raiz = Math.pow(v1, 1.0 / v2);
        resposta.setText(
            "A soma de \t\t\t\t\t\t\t\t" + v1 + " + " + v2 + " = " + String.format("%.2f", soma) +
            "\nA subtração de \t\t\t\t\t" + v1 + " + " + v2 + " = " + String.format("%.2f", subtracao) +
            "\nA multiplicação de \t\t\t" + v1 + " + " + v2 + " = " + String.format("%.2f", multiplicacao) +
            "\nA divisão de \t\t\t\t\t\t\t" + v1 + " + " + v2 + " = " + String.format("%.2f", divisao) +
            "\nA potencia de \t\t\t\t\t\t" + v1 + " + " + v2 + " = " + String.format("%.2f", potencia) +
            "\nO resto da divisão de \t\t" + v1 + " + " + v2 + " = " + String.format("%.2f", restoDivisao) +
            "\nA raiz de \t\t\t\t\t\t\t\t\t" + v1 + " + " + v2 + " = " + String.format("%.2f", raiz)
        );
    }
    private void receberDados(){
        v1 = Double.parseDouble(valor1.getText().toString());
        v2 = Double.parseDouble(valor2.getText().toString());
    }
}
