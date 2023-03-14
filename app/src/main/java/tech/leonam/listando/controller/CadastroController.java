package tech.leonam.listando.controller;

import tech.leonam.listando.model.Dao.CadastrarDao;
import tech.leonam.listando.model.Entidade.ListaEntidade;

public class CadastroController {
    public CadastroController(AtravessadorListaEntidade entidade) {
        new CadastrarDao((ListaEntidade) entidade);
    }
}
