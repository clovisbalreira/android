package com.example.rendafamilia;

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
    private Button btnEntrar;
    private EditText usuario, senha;
    private TextView txtCadastrase;
    private UsuarioDAO objUsuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        objUsuarioDAO = new UsuarioDAO(MainActivity.this);
        usuario = findViewById(R.id.edit_usuario_login);
        senha = findViewById(R.id.edit_senha_login);
        txtCadastrase = findViewById(R.id.txt_cadastro);
        txtCadastrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CadastrarUsuarioActivity.class);
                i.putExtra("novo_usuario", true);
                startActivity(i);
            }
        });

        btnEntrar = findViewById(R.id.btn_login);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campoCheio(usuario);
                campoCheio(senha);
                if(campoCheio(usuario) && campoCheio(senha)){
                    String usuarioDigitado = usuario.getText().toString();
                    String senhaDigitada = senha.getText().toString();

                    List<Usuario> lista = objUsuarioDAO.listarTodosUsuarios();

                    boolean naoEncontrou = true;
                    for(int i = 0; i < lista.size() && naoEncontrou; i++) {
                        if (lista.get(i).getUsuario().equals(usuarioDigitado) && lista.get(i)
                 .getSenha().equals(senhaDigitada)){
                            startActivity(new Intent(MainActivity.this, ListarUsuarioActivity.class));
                            finish();
                            naoEncontrou = false;
                        }
                    }
                    if(naoEncontrou){
                       Toast.makeText(MainActivity.this, "Usuario não encontrado.",
                                Toast.LENGTH_SHORT).show();
                   }
                }else{
                    Toast.makeText(MainActivity.this, "Todos os campos são obrigatórios",
                                Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean campoCheio(EditText campo){
        if(campo.getText().toString().trim().isEmpty()){
            campo.setError("Preencha o campo!!");
            return false;
        }else{
            return true;
        }
    }
}