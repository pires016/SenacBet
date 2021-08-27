package com.pires.senacbet.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String NOME_BD = "senac.senacbet.ti2020";

    static final String CAMPO_NOME = "NOME";
    static final String CAMPO_EMAIL = "EMAIL";
    static final String CAMPO_SALDO = "SALDO";
    static final String CAMPO_NOME_TIME = "NOME_TIME";
    static final String CAMPO_CIDADE_TIME = "CIDADE_TIME";
    static final String CAMPO_PAIS_TIME = "PAÍS_TIME";
    static final String CAMPO_ID = "ID";

    static final String TABELA_APOSTADOR = "APOSTADORES";
    static final String TABELA_TIME = "TIMES";


    private final String BD_CREATE_APOSTADOR = "CREATE TABLE " + TABELA_APOSTADOR + " (" +
            CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            CAMPO_NOME + " TEXT," +
            CAMPO_EMAIL + " TEXT," +
            CAMPO_SALDO + " TEXT" +
            ");";

    private final String BD_CREATE_TIME = "CREATE TABLE " + TABELA_TIME + " (" +
            CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            CAMPO_NOME_TIME + " TEXT," +
            CAMPO_PAIS_TIME + " TEXT," +
            CAMPO_CIDADE_TIME + " TEXT" +
            ");";



    public SQLiteHelper(@Nullable Context context) {
        super(context, NOME_BD, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BD_CREATE_APOSTADOR);
        db.execSQL(BD_CREATE_TIME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion > 1){
            db.execSQL(BD_CREATE_TIME);
        }
    }

}


