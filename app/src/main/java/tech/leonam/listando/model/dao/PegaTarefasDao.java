package tech.leonam.listando.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tech.leonam.listando.controller.AtravessadorListaEntidade;
import tech.leonam.listando.model.bdCreate.BDHelper;
import tech.leonam.listando.model.entidade.ListaEntidade;

public class PegaTarefasDao {
    private static final String TABLE_LISTA = "paraFazer";
    private static final String PEGAR_TUDO ="select * from " + TABLE_LISTA;
    private static final String PEGAR_TUDO_COM_WHERE ="select * from " + TABLE_LISTA+" where id = ?";
    private final SQLiteDatabase sqLiteDatabase;
    public PegaTarefasDao(Context context) {
        var bdHelper = new BDHelper(context);
        sqLiteDatabase = bdHelper.getWritableDatabase();
        pegar();
    }

    public ArrayList<AtravessadorListaEntidade> pegar() {
        var cursor = sqLiteDatabase.rawQuery(PEGAR_TUDO,new String[]{});
        if(cursor.moveToFirst()){
            var list = new ArrayList<AtravessadorListaEntidade>();
            while(!cursor.isAfterLast()){
                var entidade = new AtravessadorListaEntidade();
                entidade.setId(cursor.getInt(0));
                entidade.setTitulo(cursor.getString(1));
                entidade.setDescricao(cursor.getString(2));
                entidade.setPrioridade(cursor.getString(3));

                list.add(entidade);

                cursor.moveToNext();
            }
            return list;
        }
        return new ArrayList<>();
    }
    public ArrayList<AtravessadorListaEntidade> pegar(int id) {
        var cursor = sqLiteDatabase.rawQuery(PEGAR_TUDO_COM_WHERE,new String[]{String.valueOf(id)});
        if(cursor.moveToFirst()){
            var list = new ArrayList<AtravessadorListaEntidade>();
            while(!cursor.isAfterLast()){
                var entidade = new AtravessadorListaEntidade();
                entidade.setId(cursor.getInt(0));
                entidade.setTitulo(cursor.getString(1));
                entidade.setDescricao(cursor.getString(2));
                entidade.setPrioridade(cursor.getString(3));

                list.add(entidade);

                cursor.moveToNext();
            }
            return list;
        }
        return new ArrayList<>();
    }
}
