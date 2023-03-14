package tech.leonam.listando.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tech.leonam.listando.controller.AtravessadorListaEntidade;
import tech.leonam.listando.model.bdCreate.BDHelper;

public class PegaTarefasDao {
    private static final String TABLE_LISTA = "tarefas";
    private static final String PEGAR_TUDO ="select * from " + TABLE_LISTA;
    private final SQLiteDatabase sqLiteDatabase;
    public PegaTarefasDao(Context context) {
        var bdHelper = new BDHelper(context);
        sqLiteDatabase = bdHelper.getWritableDatabase();
        pegarTudo();
    }

    public ArrayList<AtravessadorListaEntidade> pegarTudo() {
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
}
