package com.yveskalumenoble.architecturecomponents.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yveskalumenoble.architecturecomponents.data.entity.Picture
import com.yveskalumenoble.architecturecomponents.databinding.PictureItemBinding

class PictureAdapter : ListAdapter<Picture,PictureAdapter.PictureViewHolder>(Companion) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PictureItemBinding.inflate(layoutInflater,parent,false)
        return PictureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        val picture = getItem(position)
        val binding = holder.binding
        binding.picture = picture
    }

    companion object : DiffUtil.ItemCallback<Picture>(){
        override fun areItemsTheSame(oldItem: Picture, newItem: Picture): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Picture, newItem: Picture): Boolean {
            return oldItem == newItem
        }

    }

    class PictureViewHolder(val binding: PictureItemBinding) : RecyclerView.ViewHolder(binding.root)
}