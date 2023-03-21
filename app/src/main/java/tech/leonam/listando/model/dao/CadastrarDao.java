package tech.leonam.listando.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import tech.leonam.listando.model.bdCreate.BDHelper;
import tech.leonam.listando.model.entidade.ListaEntidade;

public class CadastrarDao {
    private static final String TABLE_LISTA = "paraFazer";
    private final SQLiteDatabase sqLiteDatabase;
    public CadastrarDao(ListaEntidade entidade, Context context) throws Exception {
        var bdHelper = new BDHelper(context);
        sqLiteDatabase = bdHelper.getWritableDatabase();
        cadastrar(entidade);
        bdHelper.close();
    }

    private void cadastrar(ListaEntidade entidade) throws Exception {
        try {
            var values = new ContentValues();

            values.put("titulo",entidade.getTitulo());
            values.put("descricao",entidade.getDescricao());
            values.put("prioridade",entidade.getPrioridade());

            sqLiteDatabase.insert(TABLE_LISTA,null,values);
        }catch (Exception e){
            throw new Exception(e);
        }
    }
}
