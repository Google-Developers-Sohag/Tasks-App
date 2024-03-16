package com.example.gdscsohag.ui.home.adapter

import com.example.gdscsohag.R
import com.example.gdscsohag.databinding.ItemHomeProgressBinding
import com.example.gdscsohag.domain.Progress
import com.example.gdscsohag.ui.base.BaseAdapter

class ProgressAdapter : BaseAdapter<Progress>() {
    override val layoutId = R.layout.item_home_progress

    override fun bindData(holder: BaseViewHolder, position: Int) {
        (holder.binding as ItemHomeProgressBinding).apply {
            item = getItem(position)
        }
    }
}