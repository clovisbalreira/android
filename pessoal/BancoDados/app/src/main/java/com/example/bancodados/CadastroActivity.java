package com.example.bancodados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {
    private TextView sair, listar, titulo;
    private EditText nome, cpf, telefone, usuario, senha;
    private Button cadastrar;
    private AlunoDAO objAlunoDAO;
    private Aluno objAluno = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().hide();

        nome = findViewById(R.id.editNome);
        cpf = findViewById(R.id.editCpf);
        telefone = findViewById(R.id.editTelefone);
        usuario = findViewById(R.id.editUser);
        senha = findViewById(R.id.editSenha);
        cadastrar = findViewById(R.id.buttonCadastrar);
        sair = findViewById(R.id.textSair);
        listar = findViewById(R.id.txtListar);
        objAlunoDAO = new AlunoDAO(getApplicationContext());
        titulo = findViewById(R.id.txt_cadastro);
        Intent i = getIntent();
        if(i.hasExtra("aluno")){
            objAluno = (Aluno) i.getSerializableExtra("aluno");
            nome.setText(objAluno.getNome());
            cpf.setText(String.valueOf(objAluno.getCpf()));
            telefone.setText(objAluno.getTelefone());
            usuario.setText(objAluno.getUsuario());
            senha.setText(objAluno.getSenha());
            listar.setVisibility(View.VISIBLE);
        }else if(i.hasExtra("novo_usuario")){
            listar.setVisibility(View.INVISIBLE);
        }
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(objAluno == null){
                    objAluno = new Aluno();
                    objAluno.setNome(nome.getText().toString());
                    objAluno.setCpf(Long.parseLong(cpf.getText().toString()));
                    objAluno.setTelefone(telefone.getText().toString());
                    objAluno.setUsuario(usuario.getText().toString());
                    objAluno.setSenha(senha.getText().toString());
                    limparCampos();
                    objAlunoDAO.cadastrarAluno(objAluno);

                    Toast.makeText(CadastroActivity.this, "Cadastrado com sucesso!",
                            Toast.LENGTH_SHORT).show();
                }else{
                    objAluno = new Aluno();
                    objAluno.setNome(nome.getText().toString());
                    objAluno.setCpf(Long.parseLong(cpf.getText().toString()));
                    objAluno.setTelefone(telefone.getText().toString());
                    objAluno.setUsuario(usuario.getText().toString());
                    objAluno.setSenha(senha.getText().toString());
                    limparCampos();
                    objAlunoDAO.alterarAluno(objAluno);

                    Toast.makeText(CadastroActivity.this, "Cadastrado com sucesso!",
                            Toast.LENGTH_SHORT).show();
                }
           }
        });

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CadastroActivity.this, MainActivity.class));
                finish();
            }
        });

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CadastroActivity.this, ListarActivity.class));
                Toast.makeText(CadastroActivity.this, "Listar", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void limparCampos(){
        nome.setText("");
        cpf.setText("");
        telefone.setText("");
        usuario.setText("");
        senha.setText("");
        nome.requestFocus();
    }
}