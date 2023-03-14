package tech.leonam.listando.view.fragmentos

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import tech.leonam.listando.R
import tech.leonam.listando.controller.AtravessadorListaEntidade
import tech.leonam.listando.controller.PegaTarefasController
import tech.leonam.listando.view.adaptadores.AdaptadorReciclagem
import tech.leonam.listando.view.atividades.AdicionarTarefa

class ListaFragmento : Fragment() {
    private var floatingActionButton: FloatingActionButton?=null
    private var recyclerView:RecyclerView?=null
    private var list: ArrayList<AtravessadorListaEntidade>?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lista, container, false)
        iniciarComponentes(view)
        iniciarReciclagem()
        click()
        return view
    }

    private fun iniciarReciclagem() {
        val layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        recyclerView!!.setHasFixedSize(false)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = AdaptadorReciclagem(list!!,context)
    }

    private fun click() {
        floatingActionButton!!.setOnClickListener {
            val intencao = Intent(context,AdicionarTarefa::class.java)
            startActivity(intencao)
        }
    }
    private fun iniciarComponentes(view: View) {
        recyclerView = view.requireViewById(R.id.reciclagem)
        floatingActionButton = view.requireViewById(R.id.addTarefa)
        list = PegaTarefasController(context).tudo
    }
}