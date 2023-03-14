package tech.leonam.listando.controller;

import android.content.Context;

import java.util.ArrayList;

import tech.leonam.listando.model.dao.PegaTarefasDao;

public class PegaTarefasController {
    private final Context context;
    public PegaTarefasController(Context context) {
        this.context = context;
    }
    public ArrayList<AtravessadorListaEntidade> getTudo(){
        return new PegaTarefasDao(context).pegarTudo();
    }
}
