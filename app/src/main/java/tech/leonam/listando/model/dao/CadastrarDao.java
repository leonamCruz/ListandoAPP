package tech.leonam.listando.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import tech.leonam.listando.model.bdCreate.BDHelper;
import tech.leonam.listando.model.entidade.ListaEntidade;

public class CadastrarDao {
    private static final String TABLE_LISTA = "paraFazer";
    private final SQLiteDatabase sqLiteDatabase;
    public CadastrarDao(Context context) throws Exception {
        var bdHelper = new BDHelper(context);
        sqLiteDatabase = bdHelper.getWritableDatabase();
        bdHelper.close();
    }

    public void cadastrar(ListaEntidade entidade,String tabela) throws Exception {
        try {
            var values = new ContentValues();

            values.put("titulo",entidade.getTitulo());
            values.put("descricao",entidade.getDescricao());
            values.put("prioridade",entidade.getPrioridade());

            sqLiteDatabase.insert(tabela,null,values);
        }catch (Exception e){
            throw new Exception(e);
        }
    }
}
