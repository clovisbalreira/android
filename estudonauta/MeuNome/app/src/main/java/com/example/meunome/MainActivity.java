package com.example.meunome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nome;
    TextView resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome = (EditText) findViewById(R.id.editNomeId);
        resposta = (TextView) findViewById(R.id.txtRespostaId);
    }


    public void presionado(View view) {
        String n = nome.getText().toString();
        String frase = getString(R.string.finalizando) + " " + n + "!!";
        resposta.setText(frase);
    }
}