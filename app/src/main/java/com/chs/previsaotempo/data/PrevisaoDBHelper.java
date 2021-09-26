package com.chs.previsaotempo.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.chs.previsaotempo.app.PrevisaoApp;


public class PrevisaoDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Previsao.db";
    private static final int DB_VERSION = 1;
    private static  PrevisaoDBHelper previsaoDbhelper;

    public PrevisaoDBHelper() {
        super(PrevisaoApp.getInstance(), DB_NAME, null, DB_VERSION);
    }

    public synchronized static PrevisaoDBHelper getInstance(){
        if(previsaoDbhelper == null){
            previsaoDbhelper = new PrevisaoDBHelper();
        }
        return previsaoDbhelper;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = ("create table if not exists cidade " +
                "(id integer primary key autoincrement, " +
                "cidade text," +
                "temperatura text," +
                "temperaturamax text," +
                "temperaturamin text," +
                "latitude text," +
                "longitude text," +
                "velocidadevento text," +
                "visibilidade text," +
                "humidade text," +
                "pressaoatmosferica text," +
                "tipo integer," +
                "adicionado text);" );

        try{
            db.execSQL(sql);
            Log.i("INFO DB", "Sucesso ao criar a tabela");

        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
