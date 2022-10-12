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

public class CadastrarContaActivity extends AppCompatActivity {
    private TextView titulo;
    private EditText nome, preco;
    private MenuItem listar, usuario, sair;
    private Button btnBotao;
    private ContaDAO objContaDAO;
    private MenuInflater menuInflaterListar;
    private Conta objConta = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_conta);

        nome = findViewById(R.id.edtNomeCadastroConta);
        preco = findViewById(R.id.edtPrecoCadastro);
        btnBotao = findViewById(R.id.btnCadastrarConta);
        titulo = findViewById(R.id.txtTituloConta);
        menuInflaterListar = getMenuInflater();

        objContaDAO = new ContaDAO(getApplicationContext());

        btnBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campoCheio(nome);
                campoCheio(preco);
                if(campoCheio(nome) && campoCheio(preco)){
                    String situacao = "Alterado";
                    if(objConta == null){
                        objConta = new Conta();
                        situacao = "Cadastrado";
                    }
                    objConta.setNome(nome.getText().toString());
                    objConta.setPreco(Double.parseDouble(preco.getText().toString()));
                    Toast.makeText(CadastrarContaActivity.this, situacao + " com sucesso!!!", Toast.LENGTH_SHORT).show();
                    if(situacao == "Cadastrado"){
                        objContaDAO.cadastrarConta(objConta);
                    }else{
                        objContaDAO.alterarConta(objConta);
                    }
                    limpar();
                }else{
                    Toast.makeText(CadastrarContaActivity.this, "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menuInflaterListar.inflate(R.menu.menu_cadastro,menu);
        listar = menu.findItem(R.id.icListar);
        usuario = menu.findItem(R.id.icConta);
        sair = menu.findItem(R.id.icSairListar);

        listar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(CadastrarContaActivity.this, ListarContaActivity.class));
                finish();
                return false;
            }
        });

        usuario.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(CadastrarContaActivity.this,
                        CadastrarUsuarioActivity.class));
                finish();
                return false;
            }
        });

        sair.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(CadastrarContaActivity.this, MainActivity.class));
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
        preco.setText("");
    }
}