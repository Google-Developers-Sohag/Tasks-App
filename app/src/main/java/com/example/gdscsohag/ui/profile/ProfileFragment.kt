package com.example.gdscsohag.ui.profile

import com.example.gdscsohag.R
import com.example.gdscsohag.databinding.FragmentProfileBinding
import com.example.gdscsohag.ui.base.BaseFragment

class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>() {
    override val layoutId = R.layout.fragment_profile
    override val viewModel by lazy { ProfileViewModel() }
}