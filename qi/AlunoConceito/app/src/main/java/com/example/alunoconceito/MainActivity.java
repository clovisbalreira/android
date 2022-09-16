package com.example.alunoconceito;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Aluno aluno = new Aluno();
    EditText nome, media;
    TextView resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome = findViewById(R.id.nomeEditText);
        media = findViewById(R.id.mediaEditText);
        resposta = findViewById(R.id.respostaTextView);
    }

    public void calcular(View view) {
        if(nome.getText().toString().isEmpty() || media.getText().toString().isEmpty()){
            Toast.makeText(this,"Preencha os campos",Toast.LENGTH_LONG);
        }else{
            aluno.setNome(nome.getText().toString());
            aluno.setMedia(Double.parseDouble(media.getText().toString()));
            resposta.setText(aluno.toString());
        }
    }
}