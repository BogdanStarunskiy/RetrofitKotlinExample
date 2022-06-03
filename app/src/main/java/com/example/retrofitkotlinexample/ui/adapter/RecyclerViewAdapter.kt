package com.example.retrofitkotlinexample.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitkotlinexample.R
import com.example.retrofitkotlinexample.model.CommentModelItem

class RecyclerViewAdapter(private val commentList: ArrayList<CommentModelItem>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView? = itemView.findViewById(R.id.name)
        val body: TextView? = itemView.findViewById(R.id.body)
        val email: TextView? = itemView.findViewById(R.id.email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name!!.text = commentList[position].name
        holder.body!!.text = commentList[position].body
        holder.email!!.text = commentList[position].email
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

}