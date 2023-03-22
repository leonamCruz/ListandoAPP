package tech.leonam.listando.model.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tech.leonam.listando.controller.AtravessadorListaEntidade;
import tech.leonam.listando.model.bdCreate.BDHelper;

public class PegaTarefasDao {
    private static final String TABLE_LISTA = "paraFazer";
    private static final String TABLE_LISTA1 = "fazendo";
    private static final String PEGAR_TUDO = "select * from ";
    private static final String PEGAR_PARA_FAZER_COM_WHERE = "select * from " + TABLE_LISTA + " where id = ?";
    private final SQLiteDatabase sqLiteDatabase;

    public PegaTarefasDao(Context context) {
        var bdHelper = new BDHelper(context);
        sqLiteDatabase = bdHelper.getWritableDatabase();
    }

    public ArrayList<AtravessadorListaEntidade> pegarParaFazer() {
        var cursor = sqLiteDatabase.rawQuery(PEGAR_TUDO + TABLE_LISTA, new String[]{});
        return encapsular(cursor);
    }

    public ArrayList<AtravessadorListaEntidade> pegarParaFazer(int id) {
        var cursor = sqLiteDatabase.rawQuery(PEGAR_PARA_FAZER_COM_WHERE, new String[]{String.valueOf(id)});
        return encapsular(cursor);
    }

    public ArrayList<AtravessadorListaEntidade> pegarFazendo() {
        var cursor = sqLiteDatabase.rawQuery(PEGAR_TUDO + TABLE_LISTA1, new String[]{});
        return encapsular(cursor);
    }

    private ArrayList<AtravessadorListaEntidade> encapsular(Cursor cursor) {
        if (cursor.moveToFirst()) {
            var list = new ArrayList<AtravessadorListaEntidade>();
            while (!cursor.isAfterLast()) {
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
