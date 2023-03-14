package tech.leonam.listando.view.fragmentos;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import tech.leonam.listando.R;
import tech.leonam.listando.view.atividades.AdicionarTarefa;

public class ListaFragmento extends Fragment {
    private FloatingActionButton floatingActionButton;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        var view = inflater.inflate(R.layout.fragment_lista, container, false);
        iniciarComponentes(view);
        click();
        return view;
    }

    private void click() {
        floatingActionButton.setOnClickListener(e->{
            var intencao = new Intent();
            intencao.setClass(e.getContext(), AdicionarTarefa.class);
            startActivity(intencao);
        });
    }

    private void iniciarComponentes(View view) {
        floatingActionButton = view.findViewById(R.id.floatingActionButton);
    }
}