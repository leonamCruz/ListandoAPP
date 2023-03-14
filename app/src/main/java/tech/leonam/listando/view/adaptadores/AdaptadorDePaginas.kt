package tech.leonam.listando.view.adaptadores

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import tech.leonam.listando.view.fragmentos.Fazendo
import tech.leonam.listando.view.fragmentos.Feito
import tech.leonam.listando.view.fragmentos.Lista

class AdaptadorDePaginas(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    private var lista: Lista? = null
    private var fazendo: Fazendo? = null
    private var feito: Feito? = null
    private fun iniciarComponentes() {
        lista = Lista()
        fazendo = Fazendo()
        feito = Feito()
    }
    override fun createFragment(position: Int): Fragment {
        iniciarComponentes()
        return when (position) {
            1 -> fazendo!!
            2 -> feito!!
            else -> lista!!
        }
    }
    override fun getItemCount(): Int {
        return 3
    }
}