package com.example.gdscsohag.ui.home

import com.example.gdscsohag.R
import com.example.gdscsohag.databinding.FragmentHomeBinding
import com.example.gdscsohag.ui.base.BaseFragment

class HomeFragment :  BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val layoutId = R.layout.fragment_home
    override val viewModel by lazy { HomeViewModel() }

}