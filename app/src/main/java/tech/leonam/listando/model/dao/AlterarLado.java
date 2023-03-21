package tech.leonam.listando.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import tech.leonam.listando.model.bdCreate.BDHelper;

public class AlterarLado {
    private SQLiteDatabase sqLiteDatabase;
    private String tabela = "paraFazer";
    private String sqlPegarId = "select * from " + tabela;
    private Context context;

    public AlterarLado(Context context) {
        var bdHelper = new BDHelper(context);
        this.context = context;
        sqLiteDatabase = bdHelper.getWritableDatabase();
        bdHelper.close();
    }

    public void meio(int id) {
        var list = new PegaTarefasDao(context).pegar(id);
        System.out.println(list.get(0).getTitulo());
    }
}
