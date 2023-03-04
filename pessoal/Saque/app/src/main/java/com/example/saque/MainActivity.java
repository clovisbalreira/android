package com.example.saque;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Saque saque = new Saque();
    EditText valor;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valor = findViewById(R.id.valorEditText);
        resultado = findViewById(R.id.resulatadoTextView);
    }

    public void calcular(View view) {
        if(valor.getText().toString().isEmpty()){
            Toast.makeText(this, "Prencha os campos", Toast.LENGTH_SHORT).show();
        }else{
            saque.setValor(Integer.parseInt(valor.getText().toString()));
            resultado.setText(saque.toString());
        }
    }
}