package com.example.gdscsohag.ui.tasks

import android.os.Bundle
import android.view.View
import com.example.gdscsohag.R
import com.example.gdscsohag.databinding.FragmentTasksBinding
import com.example.gdscsohag.ui.base.BaseFragment
import com.example.gdscsohag.ui.tasks.adapter.TasksAdapter

class TasksFragment : BaseFragment<FragmentTasksBinding, TasksViewModel>() {
    override val layoutId = R.layout.fragment_tasks
    override val viewModel by lazy { TasksViewModel() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTasksRecycler()
    }

    private fun setupTasksRecycler() {
        binding.tasksRecycler.adapter = TasksAdapter()
    }
}