package com.example.nadador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Nadador nadador = new Nadador();
    EditText nome, idade;
    TextView resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome = findViewById(R.id.nomeEditText);
        idade = findViewById(R.id.idadeEditText);
        resposta = findViewById(R.id.respostaTextView);
    }

    public void calcular(View view) {
        if(nome.getText().toString().isEmpty() || idade.getText().toString().isEmpty()){
            Toast.makeText(this, "Preencha os campos", Toast.LENGTH_LONG).show();
        }else{
            nadador.setNome(nome.getText().toString());
            nadador.setIdade(Integer.parseInt(idade.getText().toString()));
            resposta.setText(nadador.toString());
        }
    }
}