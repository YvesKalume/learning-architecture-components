package com.yveskalumenoble.architecturecomponents.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("bindImage")
fun bindImage(imageView: ImageView, imageUrl: String?){
    Glide.with(imageView.context).load(imageUrl).into(imageView)
}