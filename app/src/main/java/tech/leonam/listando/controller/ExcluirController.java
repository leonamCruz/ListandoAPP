package tech.leonam.listando.controller;

import android.content.Context;

import tech.leonam.listando.model.dao.ExcluirDao;

public class ExcluirController {
    public ExcluirController(int id, Context context) throws Exception {
        new ExcluirDao(id, context);
    }
}
