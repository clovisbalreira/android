package com.example.rendafamilia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListarUsuarioActivity extends AppCompatActivity {
    private ListView lstUsuarios;
    private UsuarioDAO objUsuarioDAO;
    private MenuItem cadastrar, conta, alterar, deletar, sair;
    private SearchView pesquisar;
    private List<Usuario> todosUsuarios;
    private List<Usuario> usuariosFiltrados = new ArrayList<>();
    private MenuInflater menuInflater;
    private TextView renda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuario);
        lstUsuarios = findViewById(R.id.lstUsuario);
        renda = findViewById(R.id.txtRenda);
        objUsuarioDAO = new UsuarioDAO(getApplicationContext());
        todosUsuarios = objUsuarioDAO.listarTodosUsuarios();
        usuariosFiltrados.addAll(todosUsuarios);
        ArrayAdapter<Usuario> adaptador = new ArrayAdapter<>(ListarUsuarioActivity.this,
                android.R.layout.simple_list_item_1, usuariosFiltrados);

        lstUsuarios.setAdapter(adaptador);

        menuInflater = getMenuInflater();

        renda.setText("Renda R$ " + renda());
        registerForContextMenu(lstUsuarios);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menuInflater.inflate(R.menu.menu_superior,menu);

        cadastrar = menu.findItem(R.id.icCadastrar);
        conta = menu.findItem(R.id.icContaListar);
        sair = menu.findItem(R.id.icSair);
        pesquisar = (SearchView) menu.findItem(R.id.icPesquisar).getActionView();

        cadastrar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(ListarUsuarioActivity.this,
                        CadastrarUsuarioActivity.class));
                finish();
                return false;
            }
        });

        pesquisar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                procurarAlunoPorNome(s);
                return false;
            }
        });

        conta.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(getApplicationContext(),CadastrarContaActivity.class));
                finish();
                return false;
            }
        });

        sair.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
                return false;
            }
        });
        return true;
    }

    public void procurarAlunoPorNome(String nome){
        usuariosFiltrados.clear();

        for(int i = 0; i < todosUsuarios.size(); i++) {
            if (todosUsuarios.get(i).getNome().toLowerCase().contains(nome.toLowerCase())) {
                usuariosFiltrados.add(todosUsuarios.get(i));
            }
        }
        lstUsuarios.invalidateViews();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menuInflater.inflate(R.menu.menu_opcoes,menu);

        alterar = menu.findItem(R.id.moAlterar);
        deletar = menu.findItem(R.id.moDeletar);

        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo usuarioEscolhido = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
                Usuario objUsuarioDeletar = usuariosFiltrados.get(usuarioEscolhido.position);
                AlertDialog confirmacao =
                        new AlertDialog.Builder(ListarUsuarioActivity.this).setTitle("Atenção!!!").setMessage("Desaja realmente excluir o(a) Usuario(a) " + objUsuarioDeletar.getNome()).setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                todosUsuarios.remove(objUsuarioDeletar);
                                usuariosFiltrados.remove(objUsuarioDeletar);
                                objUsuarioDAO.excluirUsuario(objUsuarioDeletar);
                                lstUsuarios.invalidateViews();
                            }
                        }).setNegativeButton("Não", null).create();
                    confirmacao.show();
                return false;
            }
        });

        alterar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo usuarioEscolhido = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
                Usuario objUsuarioAlterar = usuariosFiltrados.get(usuarioEscolhido.position);
                Intent i = new Intent(ListarUsuarioActivity.this, CadastrarUsuarioActivity.class);
                i.putExtra("usuario", objUsuarioAlterar);
                startActivity(i);
                return false;
            }
        });
    }

    public double renda(){
        List<Usuario> lista = objUsuarioDAO.listarTodosUsuarios();
        double total = 0;
        for(int i = 0; i < lista.size(); i++) {
            total += lista.get(i).getSalario();
        }
        return total;
    }
}