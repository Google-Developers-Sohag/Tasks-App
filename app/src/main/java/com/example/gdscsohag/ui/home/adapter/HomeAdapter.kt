package com.example.gdscsohag.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.gdscsohag.R
import com.example.gdscsohag.databinding.ChildHomeLogoCardBinding
import com.example.gdscsohag.databinding.ChildHomeProgressBinding
import com.example.gdscsohag.ui.home.HomeUiState

class HomeAdapter(private val homeState: HomeUiState) :
    RecyclerView.Adapter<HomeAdapter.BaseHomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHomeViewHolder {
        return when (viewType) {
            FIRST_ITEM -> GDSCLogoViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.child_home_logo_card,
                    parent,
                    false
                )
            )

            else -> ProgressViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.child_home_progress,
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount() = ITEMS_COUNT
    override fun getItemViewType(position: Int) = position

    override fun onBindViewHolder(holder: BaseHomeViewHolder, position: Int) {
        when (holder) {
            is ProgressViewHolder -> onBindProgress(holder)
        }
    }

    private fun onBindProgress(holder: ProgressViewHolder) {
        holder.binding.apply {
            state = homeState
            progressRecycler.adapter = ProgressAdapter()
        }
    }


    abstract inner class BaseHomeViewHolder(view: ViewDataBinding) : ViewHolder(view.root)

    inner class GDSCLogoViewHolder(binding: ChildHomeLogoCardBinding) :
        BaseHomeViewHolder(binding)

    inner class ProgressViewHolder(val binding: ChildHomeProgressBinding) :
        BaseHomeViewHolder(binding)


    companion object {
        const val ITEMS_COUNT = 2
        const val FIRST_ITEM = 0
    }
}