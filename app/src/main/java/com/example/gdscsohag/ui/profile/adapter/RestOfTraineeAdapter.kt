package com.example.gdscsohag.ui.profile.adapter

import com.example.gdscsohag.R
import com.example.gdscsohag.databinding.ItemRestOfTraineeBinding
import com.example.gdscsohag.domain.Trainee
import com.example.gdscsohag.ui.base.BaseAdapter

class RestOfTraineeAdapter : BaseAdapter<Trainee>() {
    override val layoutId = R.layout.item_rest_of_trainee

    override fun bindData(holder: BaseViewHolder, position: Int) {
        (holder.binding as ItemRestOfTraineeBinding).apply {
            item = getItem(position)
            number.text = "${position + 2}-"
        }
    }
}