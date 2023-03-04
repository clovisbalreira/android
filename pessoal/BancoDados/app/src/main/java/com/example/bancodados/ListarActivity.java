package com.example.bancodados;

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

import java.util.ArrayList;
import java.util.List;

public class ListarActivity extends AppCompatActivity {
    private ListView lstAlunos;
    private AlunoDAO objAlunoDAO;
    private MenuItem cadastrar, btn_alterar, btn_deletar;
    private SearchView pesquisar;
    private List<Aluno> todosAlunos;
    private List<Aluno> alunosfiltrados  = new ArrayList<>();
    private  MenuInflater menuInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);


        lstAlunos = findViewById(R.id.lstAlunos);

        todosAlunos = objAlunoDAO.listarTodosOsAlunos();
        menuInflater = getMenuInflater();
        //registerForContextMenu();
        /*
        alunosfiltrados.addAll(todosAlunos);
        objAlunoDAO = new AlunoDAO(getApplicationContext());

        ArrayAdapter<Aluno> adaptador = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,objAlunoDAO.listarTodosOsAlunos());
        lstAlunos.setAdapter(adaptador);
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menuInflater.inflate(R.menu.menu_superior,menu);
        cadastrar = menu.findItem(R.id.icCadastrar);
        pesquisar = (SearchView) menu.findItem(R.id.icPesquisar).getActionView();
        cadastrar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(ListarActivity.this, CadastroActivity.class));
                finish();
                return false;
            }
        });
        pesquisar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                //System.out.println(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                procurarAlunoPorNome(s);
                return false;
            }
        });
        return true;
    }

    public void procurarAlunoPorNome(String nome){
        alunosfiltrados.clear();
        for(int i = 0; i < todosAlunos.size(); i++){
            if(todosAlunos.get(i).getNome().toLowerCase().contains(nome.toLowerCase())){
                alunosfiltrados.add(todosAlunos.get(i));
            }
        }
        lstAlunos.invalidateViews();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menuInflater.inflate(R.menu.menu_options,menu);

        btn_alterar = menu.findItem(R.id.btn_alterar);
        btn_deletar = menu.findItem(R.id.btn_deletar);

        btn_deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo alunoEscolhido = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
                Aluno objAlunoExcluir = alunosfiltrados.get(alunoEscolhido.position);
                AlertDialog confirmacao = new AlertDialog.Builder(ListarActivity.this).setTitle(
                        "Atenção!").setMessage("Deseja realmente exxcluir o(a) aluno(a)"+objAlunoExcluir.getNome()).setNegativeButton("Não", null).setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        todosAlunos.remove(objAlunoExcluir);
                        alunosfiltrados.remove(objAlunoExcluir);
                        objAlunoDAO.excluirAluno(objAlunoExcluir);
                        lstAlunos.invalidateViews();
                    }
                }).create();
                confirmacao.show();
                return false;
            }
        });
        btn_alterar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo alunoEscolhido = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
                Aluno objAlunoAlterar = alunosfiltrados.get(alunoEscolhido.position);
                Intent i = new Intent(ListarActivity.this, CadastroActivity.class);
                i.putExtra("aluno", objAlunoAlterar);
                startActivity(i);
                return false;
            }
        });
    }
}