package com.example.gdscsohag.ui.profile

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.example.gdscsohag.R
import com.example.gdscsohag.databinding.FragmentProfileBinding
import com.example.gdscsohag.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>() {
    override val layoutId = R.layout.fragment_profile
    override val viewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getTrainee()
    }
}