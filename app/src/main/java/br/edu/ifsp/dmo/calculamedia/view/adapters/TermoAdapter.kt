package br.edu.ifsp.dmo.calculamedia.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.dmo.calculamedia.model.Termo
import br.edu.ifsp.dmo.calculamedia.view.listeners.TermoItemClickListener
import br.edu.ifsp.dmo.calculamedia.databinding.ItemViewAritmeticaBinding
import br.edu.ifsp.dmo.calculamedia.R
class TermoAdapter(val context: Context, val dataset: List<Termo>, val listener: TermoItemClickListener) : RecyclerView.Adapter<TermoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //Atributo do objeto
        val binding: ItemViewAritmeticaBinding = ItemViewAritmeticaBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_aritmetica,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset[position]
        holder.binding.textviewTermo.setText(item.valor.toString())

        holder.binding.imgDelete.setColorFilter(context.getColor(R.color.gray))
        holder.binding.imgDelete.setOnClickListener{listener.clickDeletetTermoItem(position)}

    }

    override fun getItemCount(): Int {
       return dataset.size
    }
}