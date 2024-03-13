package com.example.gdscsohag.ui.tasks

import com.example.gdscsohag.R
import com.example.gdscsohag.databinding.FragmentTasksBinding
import com.example.gdscsohag.ui.base.BaseFragment

class TasksFragment : BaseFragment<FragmentTasksBinding, TasksViewModel>() {
    override val layoutId = R.layout.fragment_tasks
    override val viewModel by lazy { TasksViewModel() }
}