package com.pires.senacbet.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.pires.senacbet.model.Time;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TimeDAO {

    private static ArrayList<Time> times = new ArrayList<Time>();

    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase db;

    public TimeDAO(Context context) {
        this.sqLiteHelper = new SQLiteHelper(context);
    }

    public void salvar(Time time) {
        db = sqLiteHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.CAMPO_NOME_TIME, time.getNome_Time());
        values.put(SQLiteHelper.CAMPO_CIDADE_TIME, time.getCidade_Time());
        values.put(SQLiteHelper.CAMPO_PAIS_TIME, time.getPais_Time());

        db.insert(SQLiteHelper.TABELA_TIME, null, values);

        db.close();
    }

    public List<Time> listar() throws ParseException {
        db = sqLiteHelper.getReadableDatabase();

        String sql = "SELECT * FROM " + SQLiteHelper.TABELA_TIME + ";";

        Cursor c = db.rawQuery(sql, null);

        List<Time> times = new ArrayList<>();

        while(c.moveToNext()){
            Time time = new Time();
            time.setId(c.getInt(c.getColumnIndex(SQLiteHelper.CAMPO_ID)));
            time.setNome_Time(c.getString(c.getColumnIndex(SQLiteHelper.CAMPO_NOME_TIME)));
            time.setCidade_Time(c.getString(c.getColumnIndex(SQLiteHelper.CAMPO_CIDADE_TIME)));
            time.setPais_Time(c.getString(c.getColumnIndex(SQLiteHelper.CAMPO_PAIS_TIME)));

            times.add(time);
        }

        c.close();
        db.close();

        return times;
    }
}
