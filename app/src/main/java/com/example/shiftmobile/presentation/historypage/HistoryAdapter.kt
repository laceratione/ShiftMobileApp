package com.example.shiftmobile.presentation.historypage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shiftmobile.R
import com.example.shiftmobile.domain.model.HistoryEntity

//адаптер истории запросов
class HistoryAdapter(): RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    private var history: List<HistoryEntity> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.history_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = history.get(position).bin
    }

    override fun getItemCount(): Int {
        return history.size
    }

    fun update(data: List<HistoryEntity>?){
        data?.let {
            history = it
            notifyDataSetChanged()
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.findViewById(R.id.tvHistoryItem)
    }
}