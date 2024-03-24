package com.example.gdscsohag.ui.tasks.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.gdscsohag.R
import com.example.gdscsohag.databinding.ChildTasksSessionInfoBinding
import com.example.gdscsohag.databinding.ChildTasksTasksItemsBinding
import com.example.gdscsohag.domain.entity.Session
import com.example.gdscsohag.ui.base.BaseAdapter
import com.example.gdscsohag.ui.tasks.TasksUiState

class TasksAdapter(
    val state: TasksUiState
) : BaseAdapter<Session>() {
    override val layoutId = R.layout.fragment_tasks

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            FIRST_ITEM -> SessionInfoViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.child_tasks_session_info,
                    parent,
                    false
                )
            )

            else -> TasksItemsViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.child_tasks_tasks_items,
                    parent,
                    false
                )
            )
        }
    }

    override fun bindData(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is SessionInfoViewHolder -> bindSessionInfo(holder)
            is TasksItemsViewHolder -> bindTasksItems((holder))
        }
    }

    private fun bindSessionInfo(holder: SessionInfoViewHolder) {
        (holder.binding as ChildTasksSessionInfoBinding).apply {
            if (state.sessions.isNotEmpty())
                item = state.sessions.first()
        }
    }

    private fun bindTasksItems(holder: TasksItemsViewHolder) {
        (holder.binding as ChildTasksTasksItemsBinding).apply {
            if (state.sessions.isNotEmpty())
                tasks = state.sessions.first().tasks
            tasksRecycler.adapter = TasksItemsAdapter()
        }
    }

    override fun getItemCount() = ITEMS_COUNT
    override fun getItemViewType(position: Int) = position
    inner class SessionInfoViewHolder(binding: ChildTasksSessionInfoBinding) :
        BaseViewHolder(binding)

    inner class TasksItemsViewHolder(binding: ChildTasksTasksItemsBinding) : BaseViewHolder(binding)

    companion object {
        const val ITEMS_COUNT = 2
        const val FIRST_ITEM = 0
    }

}