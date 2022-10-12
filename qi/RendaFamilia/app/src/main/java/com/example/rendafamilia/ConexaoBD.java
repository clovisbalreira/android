package com.example.rendafamilia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class ConexaoBD extends SQLiteOpenHelper {
    private static final String NAME = "bdRenda";
    private static final int VERSION = 1;

    public ConexaoBD(Context contexto){
        super(contexto, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase bdRenda) {
        bdRenda.execSQL("create table tb_usuario(" +
                "id integer primary key autoincrement," +
                "nome varchar(100)," +
                "salario float ," +
                "usuario varchar(20)," +
                "senha varchar(16))");

        bdRenda.execSQL("create table tb_conta(" +
                "id integer primary key autoincrement," +
                "nome varchar(100)," +
                "preco float)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
