package com.example.gdscsohag.ui.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gdscsohag.ui.base.BaseAdapter
import com.example.gdscsohag.ui.home.HomeUiState
import com.example.gdscsohag.ui.home.adapter.HomeAdapter
import com.example.gdscsohag.ui.profile.ProfileUiState
import com.example.gdscsohag.ui.profile.adapter.ProfileAdapter
import com.example.gdscsohag.ui.tasks.TasksUiState
import com.example.gdscsohag.ui.tasks.adapter.TasksAdapter

@BindingAdapter(value = ["app:setImageUrl"])
fun ImageView.setImageUrl(url: String?) {
    url?.let { Glide.with(this).load(it).into(this) }

}

@BindingAdapter(value = ["app:setRecyclerItems"])
fun <T> RecyclerView.setRecyclerItems(items: List<T?>?) {
    (this.adapter as BaseAdapter<T?>?)?.submitList(items)
}

@BindingAdapter(value = ["app:setHomeAdapter"])
fun RecyclerView.setHomeAdapter(state: HomeUiState) {
    adapter = HomeAdapter(state)
}

@BindingAdapter(value = ["app:setProfileAdapter"])
fun RecyclerView.setProfileAdapter(state: ProfileUiState) {
    adapter = ProfileAdapter(state)
}

