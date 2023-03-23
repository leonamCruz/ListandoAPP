package tech.leonam.listando.view.fragmentos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import tech.leonam.listando.R;
import tech.leonam.listando.controller.AtravessadorListaEntidade;
import tech.leonam.listando.controller.PegaTarefasController;
import tech.leonam.listando.view.adaptadores.Interfaces;
import tech.leonam.listando.view.adaptadores.suporteFazendo.AdaptadorReciclagemFazendo;

public class FazendoFragmento extends Fragment implements Interfaces {
    private RecyclerView recyclerView;
    private ArrayList<AtravessadorListaEntidade> list;
    private View view;
    private ImageView trocarParaOLado;
    private AdaptadorReciclagemFazendo adaptadorReciclagemFazendo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fazendo, container, false);
        iniciarComponentes();
        iniciarReciclagem();
        click();
        return view;
    }

    private void iniciarReciclagem() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(layoutManager);
        adaptadorReciclagemFazendo = new AdaptadorReciclagemFazendo(list, requireContext(), this);
        recyclerView.setAdapter(adaptadorReciclagemFazendo);
    }

    private void click() {

    }
    private void iniciarComponentes() {
        recyclerView = view.findViewById(R.id.reciclagem2);
        list = new PegaTarefasController(requireContext()).getFazendo();
    }

    private final ActivityResultLauncher<Intent> requisicaoActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), resultado -> {
        if (resultado.getResultCode() == Activity.RESULT_OK) {
            iniciarComponentes();
            iniciarReciclagem();
        }
    });
    @Override
    public void onResume() {
        super.onResume();
        iniciarComponentes();
        iniciarReciclagem();
    }
    @Override
    public void atualizar() {
        iniciarComponentes();
        iniciarReciclagem();
    }
}
