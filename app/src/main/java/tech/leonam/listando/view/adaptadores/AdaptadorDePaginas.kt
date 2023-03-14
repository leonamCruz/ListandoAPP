package tech.leonam.listando.view.adaptadores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import tech.leonam.listando.view.fragmentos.Fazendo;
import tech.leonam.listando.view.fragmentos.Feito;
import tech.leonam.listando.view.fragmentos.Lista;

public class AdaptadorDePaginas extends FragmentStateAdapter {
    private Lista lista;
    private Fazendo fazendo;
    private Feito feito;
    public AdaptadorDePaginas(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    private void iniciarComponentes() {
        lista = new Lista();
        fazendo = new Fazendo();
        feito = new Feito();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        iniciarComponentes();
        switch (position){
            default: return lista;
            case 1: return fazendo;
            case 2: return feito;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
