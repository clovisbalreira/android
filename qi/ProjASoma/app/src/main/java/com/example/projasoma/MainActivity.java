package com.example.projasoma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText valor1, valor2;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valor1 = findViewById(R.id.valor1);
        valor2 = findViewById(R.id.valor2);
        resultado = findViewById(R.id.resultado);
    }

    public void cliqueCalcular(View view) {
        float v1 = Float.parseFloat(valor1.getText().toString());
        float v2 = Float.parseFloat(valor2.getText().toString());
        float soma = v1 + v2;
        resultado.setText(String.format("%.2f", soma));
    }
}