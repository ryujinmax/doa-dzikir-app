package com.my.dzikirapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.my.dzikirapp.R
import com.my.dzikirapp.model.DoadanDzikirItem

class DoadanDzikirAdapter : RecyclerView.Adapter<DoadanDzikirAdapter.DoadanDzikirViewHolder>() {
    private val listData = ArrayList<DoadanDzikirItem>()

    fun setData(list: List<DoadanDzikirItem>) {
        listData.clear()
        listData.addAll(list)
    }

    inner class DoadanDzikirViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val itemTitle = view.findViewById<TextView>(R.id.tv_desc)
        val textIsi = view.findViewById<TextView>(R.id.tv_lafaz)
        val textTerjemah = view.findViewById<TextView>(R.id.tv_terjemah)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoadanDzikirViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.row_item_dzikir_doa, parent, false).apply {
            return DoadanDzikirViewHolder(this)
        }
    }

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: DoadanDzikirViewHolder, position: Int) {
        holder.apply {
            itemTitle.text = listData[position].title
            textIsi.text = listData[position].isi
            textTerjemah.text = listData[position].terjemah }
    }
}