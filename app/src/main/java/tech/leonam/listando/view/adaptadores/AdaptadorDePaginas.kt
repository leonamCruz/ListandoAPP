package tech.leonam.listando.view.adaptadores

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import tech.leonam.listando.view.fragmentos.FazendoFragmento
import tech.leonam.listando.view.fragmentos.FeitoFragmento
import tech.leonam.listando.view.fragmentos.ListaFragmento

class AdaptadorDePaginas(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    private var listaFragmento: ListaFragmento? = null
    private var fazendoFragmento: FazendoFragmento? = null
    private var feitoFragmento: FeitoFragmento? = null
    private fun iniciarComponentes() {
        listaFragmento = ListaFragmento()
        fazendoFragmento = FazendoFragmento()
        feitoFragmento = FeitoFragmento()
    }
    override fun createFragment(position: Int): Fragment {
        iniciarComponentes()
        return when (position) {
            1 -> fazendoFragmento!!
            2 -> feitoFragmento!!
            else -> listaFragmento!!
        }
    }
    override fun getItemCount(): Int {
        return 3
    }
}