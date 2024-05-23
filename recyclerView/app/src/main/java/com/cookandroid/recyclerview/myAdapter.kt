package com.cookandroid.recyclerview

import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView

class myAdapter(val items : ArrayList<myData>) : RecyclerView.Adapter<myAdapter.ViewHolder>() {
    inner class ViewHolder(binding: ) : RecyclerView.ViewHolder(itemView) {
        fun bind(){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}