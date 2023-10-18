package com.my.dzikirapp.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.my.dzikirapp.databinding.ItemArticleBinding
import android.view.LayoutInflater
import com.my.dzikirapp.Utills.OnItemCallback
import com.my.dzikirapp.model.Artikel

class ArtikelAdapter : RecyclerView.Adapter<ArtikelAdapter.ArtikelViewHolder>() {

    private val listArtikel = ArrayList<Artikel>()
    private var onItemClickCallback: OnItemCallback? = null

    fun setData(list: ArrayList<Artikel>) {
        listArtikel.clear()
        listArtikel.addAll(list)
    }


    inner class ArtikelViewHolder(val view: ItemArticleBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtikelViewHolder {
        return ArtikelViewHolder(
            ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listArtikel.size
    }

    override fun onBindViewHolder(holder: ArtikelViewHolder, position: Int) {
        val data = listArtikel[position]
        holder.view.imgArtikel.setImageResource(data.imageArtikel)
        holder.itemView.setOnClickListener {
            onItemClickCallback?.onItemClicked(data)
        }
    }

    // Tambahkan fungsi berikut untuk memperbarui daftar artikel
    fun setArtikelList(artikelList: List<Artikel>) {
        listArtikel.clear()
        listArtikel.addAll(artikelList)
        notifyDataSetChanged()
    }

    // Tambahkan fungsi untuk mengatur callback klik item
    fun setOnItemClickCallback(callback: OnItemCallback) {
        this.onItemClickCallback = callback
    }
}
