package com.example.gdscsohag.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.gdscsohag.BR

abstract class BaseFragment<DB : ViewDataBinding, VM : ViewModel> : Fragment() {
    private var _binding: DB? = null
    protected val binding: DB
    get() = _binding!!

    abstract val layoutId: Int
    abstract val viewModel: VM
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate<DB>(inflater, layoutId, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner
                setVariable(BR.viewModel, viewModel)
            }
        return _binding?.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}