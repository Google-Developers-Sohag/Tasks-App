package com.example.gdscsohag.ui.utils

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gdscsohag.R
import com.example.gdscsohag.ui.base.BaseAdapter
import com.example.gdscsohag.ui.base.ContentStatus
import com.example.gdscsohag.ui.base.ContentStatus.ERROR
import com.example.gdscsohag.ui.base.ContentStatus.LOADING
import com.example.gdscsohag.ui.base.ContentStatus.VISIBLE
import com.example.gdscsohag.ui.home.HomeUiState
import com.example.gdscsohag.ui.home.adapter.HomeAdapter
import com.example.gdscsohag.ui.profile.ProfileUiState
import com.example.gdscsohag.ui.profile.adapter.ProfileAdapter
import com.example.gdscsohag.ui.tasks.TasksUiState
import com.example.gdscsohag.ui.tasks.adapter.TasksAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter(value = ["app:setImageUrl"])
fun ImageView.setImageUrl(url: String?) {
    if (url.isNullOrBlank()) {
        setImageResource(R.drawable.ic_student)
    } else Glide.with(this).load(url).placeholder(R.drawable.image_place_holder).into(this)
}

@BindingAdapter(value = ["app:setRecyclerItems"])
fun <T> RecyclerView.setRecyclerItems(items: List<T?>?) {
    (this.adapter as BaseAdapter<T?>?)?.submitList(items)
}

@BindingAdapter(value = ["app:setHomeAdapter"])
fun RecyclerView.setHomeAdapter(state: HomeUiState) {
    adapter = HomeAdapter(state)
}

@BindingAdapter(value = ["app:setTasksAdapter"])
fun RecyclerView.setTasksAdapter(state: TasksUiState) {
    adapter = TasksAdapter(state)
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


@BindingAdapter(value = ["app:checkFiled"])
fun TextInputLayout.checkFiled(state: String?) {
    helperText = if (state != null) context.getString(R.string.required) else null
}



