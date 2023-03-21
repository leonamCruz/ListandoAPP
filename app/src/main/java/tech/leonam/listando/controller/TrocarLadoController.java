package tech.leonam.listando.controller;

import android.content.Context;

import tech.leonam.listando.model.dao.AlterarLado;

public class TrocarLadoController {
    public void paraMeio(int id,Context context) throws Exception {
        new AlterarLado(context).meio(id);
    }
}
