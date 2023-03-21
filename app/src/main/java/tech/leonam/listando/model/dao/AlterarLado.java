package tech.leonam.listando.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import tech.leonam.listando.model.bdCreate.BDHelper;

public class AlterarLado {
    private SQLiteDatabase sqLiteDatabase;

    public AlterarLado(Context context) {
        var bdHelper = new BDHelper(context);
        sqLiteDatabase = bdHelper.getWritableDatabase();
        bdHelper.close();
    }

    public void meio(int id) {
    }
}
