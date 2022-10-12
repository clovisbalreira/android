package com.example.rendafamilia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CadastrarUsuarioActivity extends AppCompatActivity {
    private TextView titulo;
    private EditText nome, salario, usuario, senha;
    private MenuItem listar, conta, sair;
    private Button btnBotao;
    private UsuarioDAO objUsuarioDAO;
    private MenuInflater menuInflaterListar;
    private Usuario objUsuario = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);

        nome = findViewById(R.id.edtNomeCadastro);
        salario = findViewById(R.id.edtPrecoCadastro);
        usuario = findViewById(R.id.edtUsuarioCadastro);
        senha = findViewById(R.id.edtSenhaCadastro);
        btnBotao = findViewById(R.id.btnCadastrar);
        titulo = findViewById(R.id.txtTitulo);
        menuInflaterListar = getMenuInflater();

        objUsuarioDAO = new UsuarioDAO(getApplicationContext());

        Intent intent = getIntent();

        if(intent.hasExtra("usuario")){
            objUsuario = (Usuario) intent.getSerializableExtra("usuario");
            nome.setText(objUsuario.getNome());
            salario.setText(String.valueOf(objUsuario.getSalario()));
            usuario.setText(objUsuario.getUsuario());
            senha.setText(objUsuario.getSenha());
            btnBotao.setText("Alterar");
            titulo.setText("Alterar Usuario");
        }else if(intent.hasExtra("novo_usuario")){
            getSupportActionBar().hide();
        }

        btnBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campoCheio(nome);
                campoCheio(salario);
                campoCheio(usuario);
                campoCheio(senha);
                if(campoCheio(nome) && campoCheio(salario) && campoCheio(usuario) && campoCheio(senha)){
                    String situacao = "Alterado";
                    if(objUsuario == null) {
                        objUsuario = new Usuario();
                        situacao = "Cadastrado";
                    }
                    objUsuario.setNome(nome.getText().toString());
                    objUsuario.setSalario(Double.parseDouble(salario.getText().toString()));
                    objUsuario.setUsuario(usuario.getText().toString());
                    objUsuario.setSenha(senha.getText().toString());

                    Toast.makeText(CadastrarUsuarioActivity.this, situacao + " com sucesso!!!",
                            Toast.LENGTH_SHORT).show();
                    if(situacao == "Cadastrado") {
                        objUsuarioDAO.cadastrarUsuario(objUsuario);
                    }else {
                        objUsuarioDAO.alterarUsuario(objUsuario);
                    }
                    limpar();
                }else{
                    Toast.makeText(CadastrarUsuarioActivity.this, "Todos os campos são obrigatórios",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menuInflaterListar.inflate(R.menu.menu_cadastro,menu);
        listar = menu.findItem(R.id.icListar);
        conta = menu.findItem(R.id.icConta);
        sair = menu.findItem(R.id.icSairListar);

        listar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(CadastrarUsuarioActivity.this,ListarUsuarioActivity.class));
                finish();
                return false;
            }
        });

        conta.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(CadastrarUsuarioActivity.this,
                        CadastrarContaActivity.class));
                finish();
                return false;
            }
        });

        sair.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(CadastrarUsuarioActivity.this, MainActivity.class));
                finish();
                return false;
            }
        });

        return true;
    }

    public boolean campoCheio(EditText campo){
        if(campo.getText().toString().trim().isEmpty()){
            campo.setError("Preencha o campo!!");
            return false;
        }else{
            return true;
        }
    }

    public void limpar(){
        nome.setText("");
        salario.setText("");
        usuario.setText("");
        senha.setText("");
    }
}