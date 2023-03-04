package com.example.triangulo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Triangulo triangulo = new Triangulo();
    EditText ladoA, ladoB, ladoC, anguloAB, anguloBC, anguloCA;
    TextView resposta;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ladoA = findViewById(R.id.ladoAEditText);
        ladoB = findViewById(R.id.ladoBEditText);
        ladoC = findViewById(R.id.ladoCEditText);
        anguloAB = findViewById(R.id.anguloABEditText);
        anguloBC = findViewById(R.id.anguloABEditText);
        anguloCA = findViewById(R.id.anguloCAEditText);
        resposta = findViewById(R.id.respostaTextView);
    }

    public void calcular(View view) {
        triangulo.setLadoA(Double.parseDouble(ladoA.getText().toString()));
        triangulo.setLadoB(Double.parseDouble(ladoB.getText().toString()));
        triangulo.setLadoC(Double.parseDouble(ladoC.getText().toString()));
        triangulo.setAnguloAB(Double.parseDouble(anguloAB.getText().toString()));
        triangulo.setAnguloBC(Double.parseDouble(anguloBC.getText().toString()));
        triangulo.setAnguloCA(Double.parseDouble(anguloCA.getText().toString()));
        if(triangulo.validarTriangulo()){
            resposta.setText(triangulo.toString());
        }else {
            resposta.setText("Triangulo invalido");
        }
    }
}