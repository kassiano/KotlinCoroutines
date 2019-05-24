package br.com.coroutines.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.coroutines.R
import br.com.coroutines.model.Repository

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    private lateinit var items:List<Repository>

    fun setItems(newItems:List<Repository>){
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_repository, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return if(::items.isInitialized) items.size else 0
    }

    override fun onBindViewHolder(holder: RepositoryAdapter.ViewHolder, position: Int) {

        val item = items[position]
        holder.tvRepository.text = item.name
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvRepository = itemView.findViewById<TextView>(R.id.tvRepository)
    }

}