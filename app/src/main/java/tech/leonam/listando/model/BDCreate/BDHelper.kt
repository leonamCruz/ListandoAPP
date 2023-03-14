package tech.leonam.listando.model.BDCreate

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import tech.leonam.listando.R

class BDHelper(context: Context?) : SQLiteOpenHelper(context, NOME, null, VERSAO) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {sqLiteDatabase.execSQL(CRIAR_BD) }
    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {}

    companion object {
        private const val NOME = R.string.nomeBanco.toString()
        private const val VERSAO = 1
        private const val CRIAR_BD = "CREATE TABLE tarefas (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT NOT NULL, descricao TEXT, prioridade TEXT NOT NULL);"
    }
}