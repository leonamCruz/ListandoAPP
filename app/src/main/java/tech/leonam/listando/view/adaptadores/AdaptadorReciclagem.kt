package tech.leonam.listando.view.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.leonam.listando.R
import tech.leonam.listando.controller.AtravessadorListaEntidade
import tech.leonam.listando.controller.ExcluirController

class AdaptadorReciclagem(
    private val lista: ArrayList<AtravessadorListaEntidade>,
    private val context: Context?
) : RecyclerView.Adapter<SuporteReciclagem>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuporteReciclagem {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_reciclavel, parent, false)
        return SuporteReciclagem(view)
    }

    override fun onBindViewHolder(holder: SuporteReciclagem, position: Int) {
        try {
            val tarefa = lista[position]
            holder.titulo.text = tarefa.titulo
            holder.descricao.text = tarefa.descricao
            holder.prioridade.text = tarefa.prioridade
            holder.excluir.setOnClickListener {
                ExcluirController(tarefa.id!!, context)
            }
        } catch (ex: IndexOutOfBoundsException) {
            holder.titulo.setText(R.string.nenhuma_tarefa)
            holder.descricao.setText(R.string.inserar_novas_tarefas)
            holder.prioridade.text = ""
        }
    }

    override fun getItemCount(): Int {
        return if (lista.size == 0) {
            1
        } else lista.size
    }
}