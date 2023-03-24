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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import tech.leonam.listando.R;
import tech.leonam.listando.controller.AtravessadorListaEntidade;
import tech.leonam.listando.controller.PegaTarefasController;
import tech.leonam.listando.view.adaptadores.AdaptadorGeralReciclagem;
import tech.leonam.listando.view.adaptadores.Interfaces;
import tech.leonam.listando.view.atividades.AdicionarTarefa;

public class ListaFragmento extends Fragment implements Interfaces {
    private FloatingActionButton floatingActionButton;
    private RecyclerView recyclerView;
    private ArrayList<AtravessadorListaEntidade> list;
    private View view;
    private ImageView trocarParaOLado;
    private AdaptadorGeralReciclagem adaptadorReciclagemParaFazer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lista, container, false);
        iniciarComponentes();
        iniciarReciclagem();
        click();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        iniciarComponentes();
        iniciarReciclagem();
    }

    private void iniciarReciclagem() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(layoutManager);
        adaptadorReciclagemParaFazer = new AdaptadorGeralReciclagem(list, requireContext(), this,AdaptadorGeralReciclagem.PARA_FAZER);
        recyclerView.setAdapter(adaptadorReciclagemParaFazer);
    }

    private void click() {
        floatingActionButton.setOnClickListener(v -> {
            var intencao = new Intent(requireContext(), AdicionarTarefa.class);
            requisicaoActivityResult.launch(intencao);
        });
    }

    private void iniciarComponentes() {
        recyclerView = view.findViewById(R.id.reciclagem);
        floatingActionButton = view.findViewById(R.id.addTarefa);
        list = new PegaTarefasController(requireContext()).getParaFazer();
    }

    private final ActivityResultLauncher<Intent> requisicaoActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), resultado -> {
        if (resultado.getResultCode() == Activity.RESULT_OK) {
            iniciarComponentes();
            iniciarReciclagem();
        }
    });

    @Override
    public void atualizar() {
        iniciarComponentes();
        iniciarReciclagem();
    }
}
