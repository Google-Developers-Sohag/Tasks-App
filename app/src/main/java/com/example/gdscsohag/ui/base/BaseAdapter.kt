package com.example.gdscsohag.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class BaseAdapter<T> : ListAdapter<T, BaseAdapter<T>.BaseViewHolder>(BaseDiffUtils()) {
    abstract val layoutId: Int
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        bindData(holder, position)
    }

    abstract fun bindData(holder: BaseViewHolder, position: Int)


    inner class BaseViewHolder(val binding: ViewDataBinding) : ViewHolder(binding.root)
}
