package com.example.gdscsohag.ui.utils

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gdscsohag.ui.base.BaseAdapter
import com.example.gdscsohag.ui.base.ContentStatus
import com.example.gdscsohag.ui.base.ContentStatus.ERROR
import com.example.gdscsohag.ui.base.ContentStatus.LOADING
import com.example.gdscsohag.ui.base.ContentStatus.VISIBLE
import com.example.gdscsohag.ui.home.HomeUiState
import com.example.gdscsohag.ui.home.adapter.HomeAdapter
import com.example.gdscsohag.ui.profile.ProfileUiState
import com.example.gdscsohag.ui.profile.adapter.ProfileAdapter

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

@BindingAdapter(value = ["app:loadingVisibility"])
fun ProgressBar.loadingVisibility(state: ContentStatus) {
    visibility = when (state) {
        LOADING -> View.VISIBLE
        else -> View.GONE
    }
}

@BindingAdapter(value = ["app:controlVisibility"])
fun View.controlVisibility(state: ContentStatus) {
    visibility = when (state) {
        VISIBLE -> View.VISIBLE
        else -> View.GONE
    }
}

@BindingAdapter(value = ["app:controlErrorVisibility"])
fun View.controlErrorVisibility(state: ContentStatus) {
    visibility = when (state) {
        ERROR -> View.VISIBLE
        else -> View.GONE
    }
}


