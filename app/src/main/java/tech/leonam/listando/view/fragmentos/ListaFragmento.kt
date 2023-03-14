package tech.leonam.listando.view.fragmentos

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import tech.leonam.listando.R
import tech.leonam.listando.view.atividades.AdicionarTarefa

class ListaFragmento : Fragment() {
    private var floatingActionButton: FloatingActionButton? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lista, container, false)
        iniciarComponentes(view)
        click()
        return view
    }

    private fun click() {
        floatingActionButton!!.setOnClickListener {
            val intencao = Intent(context,AdicionarTarefa::class.java)
            startActivity(intencao)
        }
    }
    private fun iniciarComponentes(view: View) {
        floatingActionButton = view.findViewById(R.id.addTarefa)
    }
}