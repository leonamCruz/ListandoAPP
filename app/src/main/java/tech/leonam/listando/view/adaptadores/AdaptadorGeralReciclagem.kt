package tech.leonam.listando.view.adaptadores

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.recyclerview.widget.RecyclerView
import tech.leonam.listando.R
import tech.leonam.listando.controller.AtravessadorListaEntidade
import tech.leonam.listando.controller.ExcluirController
import tech.leonam.listando.controller.TrocarLadoController

class AdaptadorGeralReciclagem(
    private val lista: ArrayList<AtravessadorListaEntidade>,
    private val context: Context?,
    private val listener: Interfaces,
    private val opc: Int
) : RecyclerView.Adapter<SuporteGeralReciclagem>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuporteGeralReciclagem {
        return SuporteGeralReciclagem(
            LayoutInflater.from(context).inflate(R.layout.layout_reciclavel, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SuporteGeralReciclagem, position: Int) {
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
                val builder = AlertDialog.Builder(context!!)
                builder.setTitle(context.getString(R.string.excluir_item))
                builder.setMessage(context.getString(R.string.certeza_excluir))
                builder.setPositiveButton(context.getString(R.string.sim)) { _, _ ->
                    when (opc) {
                        1 -> ExcluirController(tarefa.id!!, context, "paraFazer")
                        2 -> ExcluirController(tarefa.id!!, context, "fazendo")
                        3 -> ExcluirController(tarefa.id!!, context, "concluido")
                    }
                    listener.atualizar()
                    makeText(
                        context,
                        context.getString(R.string.removido_sucesso),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                builder.setNegativeButton(context.getString(R.string.nao)) { _, _ -> }
                builder.create().show()
            }
            holder.trocarDeLado.setOnClickListener {
                when (opc) {
                    1 -> TrocarLadoController().paraMeio(tarefa.id!!, context!!)
                    2 -> TrocarLadoController().paraFim(tarefa.id!!, context!!)
                }
                listener.atualizar()
                makeText(context!!, context.getString(R.string.beleza), Toast.LENGTH_SHORT).show()
            }

        } catch (ex: IndexOutOfBoundsException) {
            holder.titulo.setText(R.string.nenhuma_tarefa)
            holder.descricao.setText(R.string.inserar_novas_tarefas)
            holder.prioridade.text = ""
            holder.trocarDeLado.visibility = View.INVISIBLE
            holder.trocarDeLado.isClickable = false
            holder.excluir.visibility = View.INVISIBLE
            holder.excluir.isClickable = false
        }
    }

    override fun getItemCount(): Int {
        return if (lista.size == 0) {
            1
        } else lista.size
    }

    companion object {
        const val PARA_FAZER = 1
        const val FAZENDO = 2
        const val CONCLUIDO = 3
    }
}