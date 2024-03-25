package com.example.gdscsohag.ui.tasks.adapter

import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.gdscsohag.R
import com.example.gdscsohag.databinding.ChildTasksSessionInfoBinding
import com.example.gdscsohag.databinding.ChildTasksTasksItemsBinding
import com.example.gdscsohag.domain.entity.Session
import com.example.gdscsohag.ui.base.BaseAdapter
import com.example.gdscsohag.ui.tasks.TasksUiState
import java.util.Date

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
            val session = state.sessions.first()
            item = session
            val currentDate = Date()
            val endDate = Date(session.endDate.refactorDateInSeconds() * 1000)
            val seconds = endDate.time - currentDate.time
            val counter = object : CountDownTimer(seconds, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    deadLine.text = refactorDeadLine(millisUntilFinished / 1000)
                }

                override fun onFinish() {
                    deadLine.text = "Best Wishes"
                    counterHint.visibility = View.GONE
                }
            }
            counter.start()
        }
    }

    private fun refactorDeadLine(seconds: Long): String {
        val days = seconds / (24 * 3600)
        val hours = (seconds % (24 * 3600)) / 3600
        val minutes = (seconds % 3600) / 60
        return "$days : $hours : $minutes"
    }

    private fun String.refactorDateInSeconds() =
        this.substringAfter('=').substringBefore(',').toLong()

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