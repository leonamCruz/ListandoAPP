package tech.leonam.listando.controller;

import android.content.Context;

import tech.leonam.listando.model.Dao.CadastrarDao;
import tech.leonam.listando.model.Entidade.ListaEntidade;

public class CadastroController {
    public CadastroController(AtravessadorListaEntidade entidade, Context context) throws Exception {
        new CadastrarDao(entidade, context);
    }
}
