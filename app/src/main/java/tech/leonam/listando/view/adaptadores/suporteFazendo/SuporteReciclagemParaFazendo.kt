package tech.leonam.listando.view.adaptadores.suporteFazendo

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tech.leonam.listando.R

class SuporteReciclagemParaFazendo(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titulo: TextView
    val descricao: TextView
    val prioridade: TextView
    val excluir: ImageView
    val trocarDeLado: ImageView

    init {
        titulo = itemView.requireViewById(R.id.tituloSet)
        descricao = itemView.requireViewById(R.id.descricaoSet)
        prioridade = itemView.requireViewById(R.id.prioridadeSet)
        excluir = itemView.requireViewById(R.id.excluir)
        trocarDeLado = itemView.requireViewById(R.id.trocarDeLado)
    }
}