package com.example.gdscsohag.ui.tasks.adapter

import android.view.ViewGroup
import com.example.gdscsohag.R
import com.example.gdscsohag.databinding.ItemTaskBinding
import com.example.gdscsohag.domain.Task
import com.example.gdscsohag.ui.base.BaseAdapter

class TasksAdapter : BaseAdapter<Task>() {
    override val layoutId = R.layout.item_task

    override fun bindData(holder: BaseViewHolder, position: Int) {
        (holder.binding as ItemTaskBinding).apply {
            item = getItem(position)
            taskNumber.text = "Task ${position + 1}"
            if (position != 0) {
                val param = mainCard.layoutParams as ViewGroup.MarginLayoutParams
                param.topMargin = 32
                mainCard.layoutParams = param
            }
        }
    }
}