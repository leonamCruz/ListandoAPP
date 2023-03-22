package tech.leonam.listando.controller;

import android.content.Context;

import java.util.ArrayList;

import tech.leonam.listando.model.dao.PegaTarefasDao;

public class PegaTarefasController {
    private final Context context;
    public PegaTarefasController(Context context) {
        this.context = context;
    }
    public ArrayList<AtravessadorListaEntidade> getParaFazer(){
        return new PegaTarefasDao(context).pegarParaFazer();
    }

    public ArrayList<AtravessadorListaEntidade> getFazendo() {
        return new PegaTarefasDao(context).pegarFazendo();
    }
}
