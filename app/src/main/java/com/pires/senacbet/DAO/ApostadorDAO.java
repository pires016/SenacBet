package com.pires.senacbet.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.pires.senacbet.model.Apostador;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ApostadorDAO {

    private static ArrayList<Apostador> apostadores = new ArrayList<Apostador>();

    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase db;

    public ApostadorDAO(Context context) {
        this.sqLiteHelper = new SQLiteHelper(context);
    }

    public void salvar(Apostador apostador) {
        db = sqLiteHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.CAMPO_NOME, apostador.getNome());
        values.put(SQLiteHelper.CAMPO_EMAIL, apostador.getEmail());
        values.put(SQLiteHelper.CAMPO_SALDO, apostador.getSaldo());

        db.insert(SQLiteHelper.TABELA_APOSTADOR, null, values);

        db.close();
    }

    public List<Apostador> listar() throws ParseException {
        db = sqLiteHelper.getReadableDatabase();

        String sql = "SELECT * FROM " + SQLiteHelper.TABELA_APOSTADOR + ";";

        Cursor c = db.rawQuery(sql, null);

        List<Apostador> apostadores = new ArrayList<>();

        while(c.moveToNext()){
            Apostador apostador = new Apostador();
            apostador.setId(c.getInt(c.getColumnIndex(SQLiteHelper.CAMPO_ID)));
            apostador.setNome(c.getString(c.getColumnIndex(SQLiteHelper.CAMPO_NOME)));
            apostador.setEmail(c.getString(c.getColumnIndex(SQLiteHelper.CAMPO_EMAIL)));
            apostador.setSaldo(c.getString(c.getColumnIndex(SQLiteHelper.CAMPO_SALDO)));

            apostadores.add(apostador);
        }

        c.close();
        db.close();

        return apostadores;
    }
}

