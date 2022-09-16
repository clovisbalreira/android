package com.example.pessoapeso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Pessoa pessoa = new Pessoa();
    EditText altura, sexo, peso;
    TextView resposta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        altura = findViewById(R.id.alturaEditText);
        sexo = findViewById(R.id.sexoEditText);
        peso = findViewById(R.id.pesoAtualEditText);
        resposta = findViewById(R.id.respostaTextView);
    }

    public void calcular(View view) {
        if(altura.getText().toString().isEmpty() || sexo.getText().toString().isEmpty() || peso.getText().toString().isEmpty() || Double.parseDouble(sexo.getText().toString()) > 2){
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        }else{
            pessoa.setAltura(Double.parseDouble(altura.getText().toString()));
            pessoa.setSexo(Byte.parseByte(sexo.getText().toString()));
            pessoa.setPesoAtual(Double.parseDouble(peso.getText().toString()));
            resposta.setText(pessoa.toString());
        }
    }
}