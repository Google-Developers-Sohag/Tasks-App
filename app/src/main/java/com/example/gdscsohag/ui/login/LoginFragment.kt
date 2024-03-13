package com.example.gdscsohag.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gdscsohag.R
import com.example.gdscsohag.databinding.FragmentLoginBinding
import com.example.gdscsohag.ui.base.BaseFragment

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {
    override val layoutId = R.layout.fragment_login
    override val viewModel by lazy { LoginViewModel() }

}