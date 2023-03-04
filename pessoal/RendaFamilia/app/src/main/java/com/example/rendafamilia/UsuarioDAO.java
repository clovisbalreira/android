package com.example.rendafamilia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private ConexaoBD conexaoBD;
    private SQLiteDatabase bdUsuario;

    public UsuarioDAO(Context contexto) {
        this.conexaoBD = new ConexaoBD(contexto);
        this.bdUsuario = this.conexaoBD.getWritableDatabase();
    }

    public void cadastrarUsuario(Usuario objUsuario){
        ContentValues valoresCampo = new ContentValues();

        valoresCampo.put("nome", objUsuario.getNome());
        valoresCampo.put("salario", objUsuario.getSalario());
        valoresCampo.put("usuario", objUsuario.getUsuario());
        valoresCampo.put("senha", objUsuario.getSenha());

        this.bdUsuario.insert("tb_usuario", null, valoresCampo);
    }

    public List<Usuario> listarTodosUsuarios(){
        List<Usuario> todosUsuarios = new ArrayList<>();

        String [] campos = {"id","nome","salario","usuario","senha"};

        Cursor cursor = bdUsuario.query("tb_usuario",campos,null,null,null,null,null,null);

        while (cursor.moveToNext()){
            Usuario objUsuario = new Usuario();

            objUsuario.setId(cursor.getInt(0));
            objUsuario.setNome(cursor.getString(1));
            objUsuario.setSalario(cursor.getDouble(2));
            objUsuario.setUsuario(cursor.getString(3));
            objUsuario.setSenha(cursor.getString(4));

            todosUsuarios.add(objUsuario);
        }
        return todosUsuarios;
    }

    public void alterarUsuario(Usuario objUsuario){
        ContentValues valoresCampo = new ContentValues();

        valoresCampo.put("nome", objUsuario.getNome());
        valoresCampo.put("salario", objUsuario.getSalario());
        valoresCampo.put("usuario", objUsuario.getUsuario());
        valoresCampo.put("senha", objUsuario.getSenha());

        String [] id = {String.valueOf(objUsuario.getId())};
        this.bdUsuario.update("tb_usuario", valoresCampo, "id = ?", id);
    }

    public void excluirUsuario(Usuario objUsuario){
        String [] id = {String.valueOf(objUsuario.getId())};
        this.bdUsuario.delete("tb_usuario", "id = ?", id);
    }
}
