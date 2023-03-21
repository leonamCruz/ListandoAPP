package tech.leonam.listando.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import tech.leonam.listando.model.bdCreate.BDHelper;
public class ExcluirDao {
    private static final String TABLE_LISTA = "paraFazer";
    private final SQLiteDatabase sqLiteDatabase;
    public ExcluirDao(int id, Context context) throws Exception {
        var bdHelper = new BDHelper(context);
        sqLiteDatabase = bdHelper.getWritableDatabase();
        excluir(id);
        bdHelper.close();
    }

    private void excluir(int id) throws Exception {
        try {
            sqLiteDatabase.delete(TABLE_LISTA,"id = ?",new String[]{String.valueOf(id)});
        } catch (Exception e){
            throw new Exception("Erro BD");
        }
    }
}
