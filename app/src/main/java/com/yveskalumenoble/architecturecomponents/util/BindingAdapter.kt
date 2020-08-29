package com.yveskalumenoble.architecturecomponents.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

@BindingAdapter("bindImage")
fun bindImage(imageView: ImageView, imageUrl: String?){
    Glide.with(imageView.context).load(imageUrl).into(imageView)
}

@BindingAdapter("setAdapter")
fun RecyclerView.setAdapter(adapter: RecyclerView.Adapter<*>) {
    this.adapter = adapter
}