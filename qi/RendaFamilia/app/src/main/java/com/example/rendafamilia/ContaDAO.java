package com.example.rendafamilia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ContaDAO {
    private ConexaoBD conexaoBD;
    private SQLiteDatabase bdConta;

    public ContaDAO(Context contexto) {
        this.conexaoBD = new ConexaoBD(contexto);
        this.bdConta = this.conexaoBD.getWritableDatabase();
    }

    public void cadastrarConta(Conta objConta){
        ContentValues valoresCampo = new ContentValues();

        valoresCampo.put("nome", objConta.getNome());
        valoresCampo.put("preco", objConta.getPreco());

        this.bdConta.insert("tb_conta", null, valoresCampo);
    }

    public List<Conta> listarTodasContas(){
        List<Conta> todasContas = new ArrayList<>();

        String [] campos = {"id", "nome", "preco"};

        Cursor cursor = bdConta.query("tb_conta", campos, null,null,null,null,null, null);

        while (cursor.moveToNext()){
            Conta objConta = new Conta();

            objConta.setId(cursor.getInt(0));
            objConta.setNome(cursor.getString(1));
            objConta.setPreco(cursor.getDouble(2));

            todasContas.add(objConta);
        }
        return todasContas;
    }

    public void alterarConta(Conta objConta){
        ContentValues valoresCampo = new ContentValues();

        valoresCampo.put("nome", objConta.getNome());
        valoresCampo.put("preco", objConta.getPreco());

        String [] id = {String.valueOf(objConta.getId())};
        this.bdConta.update("tb_conta", valoresCampo, "id = ?", id);
    }

    public void excluirConta(Conta objConta){
        String [] id = {String.valueOf(objConta.getId())};
        this.bdConta.delete("tb_conta","id = ?", id);

    }
}
/*
private int id;
    private String nome;
    private Double preco;
 */
