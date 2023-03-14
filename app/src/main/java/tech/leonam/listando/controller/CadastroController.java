package tech.leonam.listando.controller;

import android.content.Context;

import tech.leonam.listando.model.dao.CadastrarDao;

public class CadastroController {
    public CadastroController(AtravessadorListaEntidade entidade, Context context) throws Exception {
        new CadastrarDao(entidade, context);
    }
}
