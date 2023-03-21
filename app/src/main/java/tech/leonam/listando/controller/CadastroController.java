package tech.leonam.listando.controller;

import android.content.Context;

import tech.leonam.listando.model.dao.CadastrarDao;

public class CadastroController {
    public CadastroController(AtravessadorListaEntidade entidade, Context context, String paraFazer) throws Exception {
        new CadastrarDao(context).cadastrar(entidade,paraFazer);
    }
}
