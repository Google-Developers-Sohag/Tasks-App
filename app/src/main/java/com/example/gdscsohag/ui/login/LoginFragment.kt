package com.example.gdscsohag.ui.login

import android.os.Bundle
import android.view.View
import com.example.gdscsohag.MainActivity
import com.example.gdscsohag.R
import com.example.gdscsohag.databinding.FragmentLoginBinding
import com.example.gdscsohag.ui.base.BaseFragment

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {
    override val layoutId = R.layout.fragment_login
    override val viewModel by lazy { LoginViewModel() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).controlBottomNavVisibility(false)
    }

}