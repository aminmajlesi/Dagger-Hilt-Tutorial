package com.example.daggerhilt.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.daggerhilt.R
import com.example.daggerhilt.data.model.User
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {


    inner class DataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


    private val differCallback = object : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data1 = differ.currentList[position]
        holder.itemView.apply {
            textViewUserName.text = data1.name
            textViewUserEmail.text = data1.email
            Glide.with(imageViewAvatar.context)
                .load(data1.avatar)
                .into(imageViewAvatar)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}