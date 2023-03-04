package com.example.bancodados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private ConexaoBD conexaoBD;
    private SQLiteDatabase bdEscola;

    public AlunoDAO(Context contexto) {
        this.conexaoBD = new ConexaoBD(contexto);
        this.bdEscola = this.conexaoBD.getWritableDatabase();
    }

    public void cadastrarAluno(Aluno objAluno){
        ContentValues valoresCampos = new ContentValues();
        valoresCampos.put("nome",objAluno.getNome());
        valoresCampos.put("cpf",objAluno.getCpf());
        valoresCampos.put("telefone",objAluno.getTelefone());
        valoresCampos.put("usuario",objAluno.getUsuario());
        valoresCampos.put("senha",objAluno.getSenha());

        this.bdEscola.insert("tb_aluno",null,valoresCampos);
    }

    public List<Aluno> listarTodosOsAlunos(){
        List<Aluno> todosOsAlunos = new ArrayList<>();
        String [] campos = {"id","nome","cpf","telefone","usuario","senha"};
        Cursor cursor = bdEscola.query("tb_aluno",campos,null,null,null,null,null,null);
        while (cursor.moveToNext()){
            Aluno objAluno = new Aluno();
            objAluno.setId(cursor.getInt(0));
            objAluno.setNome(cursor.getString(1));
            objAluno.setCpf(cursor.getLong(2));
            objAluno.setTelefone(cursor.getString(3));
            objAluno.setUsuario(cursor.getString(4));
            objAluno.setSenha(cursor.getString(5));
            todosOsAlunos.add(objAluno);
        }
        return todosOsAlunos;
    }

    public void excluirAluno(Aluno objAluno){
        String [] id = {String.valueOf(objAluno.getId())};
        this.bdEscola.delete("tb_aluno", "id = ?", id );
    }

    public void alterarAluno(Aluno objAluno){
        ContentValues valoresCampos = new ContentValues();
        valoresCampos.put("nome",objAluno.getNome());
        valoresCampos.put("cpf",objAluno.getCpf());
        valoresCampos.put("telefone",objAluno.getTelefone());
        valoresCampos.put("usuario",objAluno.getUsuario());
        valoresCampos.put("senha",objAluno.getSenha());

        String [] id = {String.valueOf(objAluno.getId())};
        this.bdEscola.update("tb_aluno",valoresCampos, "id = ?", id);

    }

}
