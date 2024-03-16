package com.example.gdscsohag.ui.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gdscsohag.ui.base.BaseAdapter

@BindingAdapter(value = ["app:setImageUrl"])
fun ImageView.setImageUrl(url: String) {
    Glide.with(this).load(url).into(this)
}

@BindingAdapter(value = ["app:setRecyclerItems"])
fun <T> RecyclerView.setRecyclerItems(items: List<T>) {
    (this.adapter as BaseAdapter<T>).submitList(items)
}