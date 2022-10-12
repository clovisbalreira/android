package com.example.bancodados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnLogar;
    EditText usuario, senha;
    TextView cadastro;
    AlunoDAO objAlunoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        usuario = findViewById(R.id.editUser);
        senha = findViewById((R.id.editPwd));
        btnLogar = findViewById(R.id.btnLogar);
        cadastro = findViewById(R.id.txt_cadastro);
        objAlunoDao = new AlunoDAO(getApplicationContext());
        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CadastroActivity.class);
                i.putExtra("novo_usuario", true);
                startActivity(i);
            }
        });

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usuario.getText().toString();
                String pwd = senha.getText().toString();

                List<Aluno> lista = objAlunoDao.listarTodosOsAlunos();
                boolean naoEscontrou = true;
                for(int i = 0; i < lista.size() && naoEscontrou; i ++){
                    if(lista.get(i).getUsuario().equals(user) && lista.get(i).getSenha().equals(pwd)){
                        startActivity(new Intent(MainActivity.this, CadastroActivity.class));
                        finish();
                        naoEscontrou = false;
                    }

                }
                if(naoEscontrou){
                    Toast.makeText(MainActivity.this, "Usuario ou senha incorreto!!",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}