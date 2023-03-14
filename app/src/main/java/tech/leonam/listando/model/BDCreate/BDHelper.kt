package tech.leonam.listando.model.BDCreate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import tech.leonam.listando.R;

public class BDHelper extends SQLiteOpenHelper {
    private static final String NOME = String.valueOf(R.string.nomeBanco);
    private static final int VERSAO = 1;
    private static final String CRIAR_BD = "CREATE TABLE tarefas (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT NOT NULL, descricao TEXT, prioridade TEXT NOT NULL);";

    public BDHelper(@Nullable Context context) {
        super(context, NOME, null, VERSAO);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CRIAR_BD);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}
}
