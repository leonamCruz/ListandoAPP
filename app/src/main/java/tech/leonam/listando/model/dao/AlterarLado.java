package tech.leonam.listando.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import tech.leonam.listando.controller.AtravessadorListaEntidade;
import tech.leonam.listando.model.bdCreate.BDHelper;
import tech.leonam.listando.model.entidade.ListaEntidade;

public class AlterarLado {
    private final SQLiteDatabase sqLiteDatabase;
    private final String tabela = "paraFazer";
    private final String tabela2 = "fazendo";
    private final String sqlPegarId = "select * from " + tabela;
    private final Context context;

    public AlterarLado(Context context) {
        var bdHelper = new BDHelper(context);
        this.context = context;
        sqLiteDatabase = bdHelper.getWritableDatabase();
    }

    public void meio(int id) throws Exception {
        var list = new PegaTarefasDao(context).pegarParaFazer(id);
        var entidade = new AtravessadorListaEntidade();
        entidade.setTitulo(list.get(0).getTitulo());
        entidade.setDescricao(list.get(0).getDescricao());
        entidade.setPrioridade(list.get(0).getPrioridade());

        new CadastrarDao(context).cadastrar(entidade,tabela2);
        sqLiteDatabase.delete(tabela,"id = ?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }
}
