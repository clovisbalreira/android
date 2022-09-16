package com.example.data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Data data = new Data();
    EditText dia, mes, ano;
    TextView resposta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dia = findViewById(R.id.diaEditText);
        mes = findViewById(R.id.mesEditText);
        ano = findViewById(R.id.anoEditText);
        resposta = findViewById(R.id.respostaTextView);
    }

    public void calcular(View view) {
        if(dia.getText().toString().isEmpty() || mes.getText().toString().isEmpty() || ano.getText().toString().isEmpty()){
            Toast.makeText(this, "Preenche o campos", Toast.LENGTH_SHORT).show();
        }else{
            data.setDia(Byte.parseByte(dia.getText().toString()));
            data.setMes(Byte.parseByte(mes.getText().toString()));
            data.setAno(Integer.parseInt(ano.getText().toString()));
            resposta.setText(data.toString());
        }
    }
}