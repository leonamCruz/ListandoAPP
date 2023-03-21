package tech.leonam.listando.model.bdCreate

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import tech.leonam.listando.R

class BDHelper(context: Context?) : SQLiteOpenHelper(context, NOME, null, VERSAO) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.execSQL(CRIAR_TABLE1)
        sqLiteDatabase.execSQL(CRIAR_TABLE2)
        sqLiteDatabase.execSQL(CRIAR_TABLE3)
    }
    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {}

    companion object {
        private const val NOME = R.string.nomeBanco.toString()
        private const val VERSAO = 1
        private const val CRIAR_TABLE1 = "CREATE TABLE paraFazer (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT NOT NULL, descricao TEXT, prioridade TEXT NOT NULL);"
        private const val CRIAR_TABLE2 = "CREATE TABLE fazendo (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT NOT NULL, descricao TEXT, prioridade TEXT NOT NULL);"
        private const val CRIAR_TABLE3 = "CREATE TABLE concluido (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT NOT NULL, descricao TEXT, prioridade TEXT NOT NULL);"
    }
}