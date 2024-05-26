package com.example.livemessenger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

public class ChatDataAdapter(private val itemList: List<ChatData>) : RecyclerView.Adapter<ChatDataAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val largeImageView: ImageView = itemView.findViewById(R.id.large_image)
        val smallImageView: ImageView = itemView.findViewById(R.id.small_image)
        val titleTextView: TextView = itemView.findViewById(R.id.title_text)
        val descriptionTextView: TextView = itemView.findViewById(R.id.description_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.largeImageView.setImageResource(currentItem.largeImageResId)
        holder.smallImageView.setImageResource(currentItem.smallImageResId)
        holder.titleTextView.text = currentItem.title
        holder.descriptionTextView.text = currentItem.description
    }

    override fun getItemCount() = itemList.size
}

