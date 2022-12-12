package com.example.vocabulary20.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vocabulary20.R
import com.example.vocabulary20.data.Vocab

class ListAdapter(private val vocabList: List<Vocab>, private val vocabClickListener: VocabClickListener) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val ids = itemView.findViewById<TextView>(R.id.txt_id)
        val wrd = itemView.findViewById<TextView>(R.id.txt_word)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentList = vocabList[position]

        holder.ids.text = currentList.id.toString()
        holder.wrd.text = currentList.word

        holder.itemView.setOnClickListener{
            vocabClickListener.clickListener(currentList.id)
        }


    }

    override fun getItemCount(): Int {
        return vocabList.size
    }
}