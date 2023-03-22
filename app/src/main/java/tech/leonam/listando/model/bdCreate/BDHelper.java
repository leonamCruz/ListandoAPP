package tech.leonam.listando.model.bdCreate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Objects;

import tech.leonam.listando.R;

public class BDHelper extends SQLiteOpenHelper {
    private final String CRIAR_TABLE1 = "CREATE TABLE paraFazer (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT NOT NULL, descricao TEXT, prioridade TEXT NOT NULL);";
    private final String CRIAR_TABLE2 = "CREATE TABLE fazendo (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT NOT NULL, descricao TEXT, prioridade TEXT NOT NULL);";
    private final String CRIAR_TABLE3 = "CREATE TABLE concluido (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT NOT NULL, descricao TEXT, prioridade TEXT NOT NULL);";

    public BDHelper(@Nullable Context context){
        super(context, Objects.requireNonNull(context).getString(R.string.nomeBanco), null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CRIAR_TABLE1);
        sqLiteDatabase.execSQL(CRIAR_TABLE2);
        sqLiteDatabase.execSQL(CRIAR_TABLE3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
