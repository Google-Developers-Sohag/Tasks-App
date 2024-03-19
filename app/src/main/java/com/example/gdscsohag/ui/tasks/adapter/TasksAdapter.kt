package com.example.gdscsohag.ui.tasks.adapter

import com.example.gdscsohag.R
import com.example.gdscsohag.databinding.ItemTaskBinding
import com.example.gdscsohag.domain.entity.Task
import com.example.gdscsohag.ui.base.BaseAdapter

class TasksAdapter : BaseAdapter<Task>() {
    override val layoutId = R.layout.item_task

    override fun bindData(holder: BaseViewHolder, position: Int) {
        (holder.binding as ItemTaskBinding).apply {
            item = getItem(position)
            taskNumber.text = "Task ${position + 1}"
        }
    }
}