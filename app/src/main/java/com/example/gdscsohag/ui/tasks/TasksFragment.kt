package com.example.gdscsohag.ui.tasks

import androidx.fragment.app.viewModels
import com.example.gdscsohag.R
import com.example.gdscsohag.databinding.FragmentTasksBinding
import com.example.gdscsohag.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TasksFragment : BaseFragment<FragmentTasksBinding, TasksViewModel>() {
    override val layoutId = R.layout.fragment_tasks
    override val viewModel: TasksViewModel by viewModels()
}