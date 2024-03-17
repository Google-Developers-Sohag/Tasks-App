package com.example.gdscsohag.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.gdscsohag.R
import com.example.gdscsohag.databinding.ChildHomeLogoCardBinding
import com.example.gdscsohag.databinding.ChildHomeProgressBinding
import com.example.gdscsohag.ui.base.BaseAdapter
import com.example.gdscsohag.ui.home.HomeUiState

class HomeAdapter(private val homeState: HomeUiState) :
    BaseAdapter<HomeUiState>() {
    override val layoutId = R.layout.fragment_home

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
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

    override fun bindData(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is ProgressViewHolder -> onBindProgress(holder)
        }
    }

    override fun getItemCount() = ITEMS_COUNT
    override fun getItemViewType(position: Int) = position

    private fun onBindProgress(holder: ProgressViewHolder) {
        (holder.binding as ChildHomeProgressBinding).apply {
            state = homeState
            progressRecycler.adapter = ProgressAdapter()
        }
    }

    inner class GDSCLogoViewHolder(binding: ChildHomeLogoCardBinding) : BaseViewHolder(binding)
    inner class ProgressViewHolder(binding: ChildHomeProgressBinding) : BaseViewHolder(binding)


    companion object {
        const val ITEMS_COUNT = 2
        const val FIRST_ITEM = 0
    }
}