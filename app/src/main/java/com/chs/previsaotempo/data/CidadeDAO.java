package com.chs.previsaotempo.data;

import android.content.ContentValues;
import android.database.Cursor;

import com.chs.previsaotempo.model.Cidade;

import java.util.ArrayList;
import java.util.List;

public class CidadeDAO extends DAO<Cidade> {
    public static CidadeDAO instance;

    public synchronized static CidadeDAO getInstance(){
        if(instance == null){
            instance = new CidadeDAO();
        }
        return instance;
    }

    public CidadeDAO() {
    }

    @Override
    public boolean saveOrEdit(Cidade object) {
        return false;
    }

    @Override
    public List<Cidade> searchByName(String name) {
        return null;
    }

    @Override
    public boolean deletar(Cidade object) {
        return false;
    }

    @Override
    public List<Cidade> listar() {
        return null;
    }

    @Override
    public Cidade searchContactById(int id) {
        return null;
    }

    public List<Cidade> listarCidadesAdicionadas() {
        List<Cidade> cidades = new ArrayList<>();
        String sql = "SELECT " +
                "CIDADE, " +
                "TEMPERATURA " +
                "FROM CIDADE " +
                "WHERE ADICIONADO ='S';" ;

        Cursor c = getReadableDB().rawQuery(sql, null);
        while (c.moveToNext()){
            Cidade cidade = new Cidade();
            cidade.setCidade(c.getString(c.getColumnIndex("cidade")));
            cidade.setTemperatura(c.getString(c.getColumnIndex("temperatura")));
            //cidade.setTipo(c.getInt(c.getColumnIndex("TIPO")));
            cidades.add(cidade);
        }
        c.close();
        return cidades;
    }


    public List<Cidade> listarTodasCidades() {
        List<Cidade> cidades = new ArrayList<>();
        String sql = "SELECT * " +
//                "CIDADE, " +
//                "TEMPERATURA " +
                "FROM CIDADE; "  ;

        Cursor c = getReadableDB().rawQuery(sql, null);
        while (c.moveToNext()){
            Cidade cidade = new Cidade();
            cidade.setCidade(c.getString(c.getColumnIndex("cidade")));
            cidade.setTemperatura(c.getString(c.getColumnIndex("temperatura")));
            //cidade.setTipo(c.getInt(c.getColumnIndex("TIPO")));
            cidades.add(cidade);
        }
        c.close();
        return cidades;
    }

    public List<Cidade> buscarCidade(String buscouCidade){
        List<Cidade> cidades = new ArrayList<>();
        String sql = "SELECT *" +
//                "CIDADE, " +
//                "TEMPERATURA " +
                "FROM CIDADE " +
                "WHERE CIDADE LIKE "+ "'%"+ buscouCidade + "%' ;" ;

        Cursor c = getReadableDB().rawQuery(sql, null);

        while (c.moveToNext()){
            Cidade cidade = new Cidade();
            cidade.setCidade(c.getString(c.getColumnIndex("cidade")));
            cidade.setTemperatura(c.getString(c.getColumnIndex("temperatura")));
            cidades.add(cidade);

        }
        c.close();
        return cidades;
    }

    public void addCidade(Integer id){
        String sql = "update cidade set adicionado = 'S'" +
                "where id = " +id+ ";" ;

        Cursor c = getWritableDB().rawQuery(sql, null);
        c.close();
    }


}
