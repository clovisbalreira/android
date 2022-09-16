package com.example.projasoma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText valor1, valor2;
    TextView resultado;
    Button btnsomar;
    double v1, v2;
    double soma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valor1 = findViewById(R.id.valor1);
        valor2 = findViewById(R.id.valor2);
        resultado = findViewById(R.id.resultado);
        btnsomar = findViewById(R.id.calcular);
    }

    public void calcularSoma(View view){
        v1 = Double.parseDouble(valor1.getText().toString());
        v2 = Double.parseDouble(valor2.getText().toString());
        soma = v1 + v2;
        resultado.setText("A soma entre " + v1 + " e " + v2 + " é: " + soma);
    }
    /*public void cliqueCalcular(View view) {
        float v1 = Float.parseFloat(valor1.getText().toString());
        float v2 = Float.parseFloat(valor2.getText().toString());
        float soma = v1 + v2;
        resultado.setText(String.format("%.2f", soma));
    }*/
}