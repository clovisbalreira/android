package com.example.aluno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nome;
    EditText nota1;
    EditText nota2;
    Button btnButton;
    TextView situacao;
    Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aluno = new Aluno();
        nome = findViewById(R.id.nomeEditText);
        nota1 = findViewById(R.id.nota1EditText);
        nota2 = findViewById(R.id.nota2EditText);
        btnButton = findViewById(R.id.btnCalcular);
        situacao = findViewById(R.id.situacaoTextView);
    }


    public void situacaoAluno(View view) {
        boolean ok = true;
        String mensagem = "";
        if(nome.getText().toString().trim().isEmpty()){
            ok = false;
            nome.setError("Prencha o nome");
            mensagem += "O nome está vazio.";
        }if(nota1.getText().toString().trim().isEmpty()){
            if(!ok){
                mensagem += "\n";
            }
            nota1.setError("Prencha o nome");
            ok = false;
            mensagem += "A nota 1 está vazia.";
        }
        if(nota2.getText().toString().trim().isEmpty()){
            if(!ok){
                mensagem += "\n";
            }
            nota2.setError("Prencha o nome");
            ok = false;
            mensagem += "A nota 2 está vazia.";
        }
        if(ok) {
            aluno.setNome(nome.getText().toString());
            aluno.setNota1(Double.parseDouble(nota1.getText().toString()));
            aluno.setNota2(Double.parseDouble(nota1.getText().toString()));
            aluno.calcularMedia();
            aluno.verificarSituacao();
            situacao.setText(aluno.toString());
        }else{
            Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
            //Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_LONG).show();
        }
    }
}