package tech.leonam.listando.view.fragmentos

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import tech.leonam.listando.R
import tech.leonam.listando.controller.AtravessadorListaEntidade
import tech.leonam.listando.controller.PegaTarefasController
import tech.leonam.listando.view.adaptadores.AdaptadorReciclagem
import tech.leonam.listando.view.adaptadores.InterfaceExcluir
import tech.leonam.listando.view.atividades.AdicionarTarefa

class ListaFragmento : Fragment(),InterfaceExcluir {
    private var floatingActionButton: FloatingActionButton?=null
    private var recyclerView:RecyclerView?=null
    private var list: ArrayList<AtravessadorListaEntidade>?=null
    private var view: View?=null
    private var trocarParaOLado: ImageView?=null
    private var adaptadorReciclagem: AdaptadorReciclagem?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        view = inflater.inflate(R.layout.fragment_lista, container, false)
        iniciarComponentes()
        iniciarReciclagem()
        click()
        return view
    }
    private fun iniciarReciclagem() {
        val layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        recyclerView!!.setHasFixedSize(false)
        recyclerView!!.layoutManager = layoutManager
        adaptadorReciclagem = AdaptadorReciclagem(list!!,context,this)
        recyclerView!!.adapter = adaptadorReciclagem
    }

    private fun click() {
        floatingActionButton!!.setOnClickListener {
            val intencao = Intent(context,AdicionarTarefa::class.java)
            requisicaoActivityResult.launch(intencao)
        }

    }
    private fun iniciarComponentes() {
        recyclerView = view?.requireViewById(R.id.reciclagem)
        floatingActionButton = view?.requireViewById(R.id.addTarefa)
        list = PegaTarefasController(context).tudo
    }
    private val requisicaoActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { resultado ->
        if (resultado.resultCode == Activity.RESULT_OK) {
            iniciarComponentes()
            iniciarReciclagem()
        }
    }
    override fun onExcluirItem() {
        iniciarComponentes()
        iniciarReciclagem()
    }
}