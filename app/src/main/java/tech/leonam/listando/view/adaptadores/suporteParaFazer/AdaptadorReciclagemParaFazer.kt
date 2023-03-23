package tech.leonam.listando.view.adaptadores.suporteParaFazer

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.recyclerview.widget.RecyclerView
import tech.leonam.listando.R
import tech.leonam.listando.controller.AtravessadorListaEntidade
import tech.leonam.listando.controller.ExcluirController
import tech.leonam.listando.controller.TrocarLadoController
import tech.leonam.listando.view.adaptadores.Interfaces

class AdaptadorReciclagemParaFazer(
    private val lista: ArrayList<AtravessadorListaEntidade>,
    private val context: Context?,
    private val listener: Interfaces
) : RecyclerView.Adapter<SuporteReciclagemParaFazer>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuporteReciclagemParaFazer {
        return SuporteReciclagemParaFazer(
            LayoutInflater.from(context).inflate(R.layout.layout_reciclavel, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SuporteReciclagemParaFazer, position: Int) {
        try {
            val tarefa = lista[position]
            holder.titulo.text = tarefa.titulo
            holder.descricao.text = tarefa.descricao
            holder.prioridade.text = tarefa.prioridade
            if (tarefa.prioridade.equals(holder.itemView.context.getString(R.string.prioridade_baixa))) {
                holder.prioridade.setTextColor(Color.GREEN)
            } else if (tarefa.prioridade.equals(holder.itemView.context.getString(R.string.prioridade_media))) {
                holder.prioridade.setTextColor(Color.YELLOW)
            } else if (tarefa.prioridade.equals(holder.itemView.context.getString(R.string.prioridade_alta))) {
                holder.prioridade.setTextColor(Color.RED)
            } else if (tarefa.prioridade.equals(holder.itemView.context.getString(R.string.sem_prioridade))) {
                holder.prioridade.setTextColor(Color.GRAY)
            }

            holder.excluir.setOnClickListener {
                val builder = AlertDialog.Builder(context)
                builder.setTitle("Excluir item")
                builder.setMessage("Você tem certeza de que deseja excluir este item?")
                builder.setPositiveButton("Sim") { _, _ ->
                    ExcluirController(tarefa.id!!, context,"paraFazer")
                    listener.atualizar()
                    makeText(context, "Removido com Sucesso", Toast.LENGTH_SHORT).show()
                }
                builder.setNegativeButton("Não") { _, _ -> }
                builder.create().show()
            }
            holder.trocarDeLado.setOnClickListener {
                TrocarLadoController().paraMeio(tarefa.id!!,context)
                listener.atualizar()
                makeText(context,"Beleza! :)",Toast.LENGTH_SHORT).show()
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