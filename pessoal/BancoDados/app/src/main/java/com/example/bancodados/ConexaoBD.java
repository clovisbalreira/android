package com.example.bancodados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexaoBD extends SQLiteOpenHelper {
    private static final String NAME = "bdEscola";
    private static final int VERSION = 1;

    public ConexaoBD(Context contexto) {
        super(contexto, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase bdEscola) {
        //criar a tabela
        bdEscola.execSQL("CREATE TABLE tb_aluno(" +
                "id integer primary key autoincrement, " +
                "nome varchar(100)," +
                "cpf bigint," +
                "telefone varchar(50)," +
                "usuario varchar(20)," +
                "senha varchar(16))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bdEscola, int i, int i1) {

    }
}
