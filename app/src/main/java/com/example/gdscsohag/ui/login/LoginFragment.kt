package com.example.gdscsohag.ui.login

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.gdscsohag.MainActivity
import com.example.gdscsohag.R
import com.example.gdscsohag.databinding.FragmentLoginBinding
import com.example.gdscsohag.ui.base.BaseFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {
    override val layoutId = R.layout.fragment_login
    override val viewModel by lazy { LoginViewModel() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewAppearance()
        viewModel.apply {
            viewModelScope.launch {
                events.collectLatest {
                    if (it) {
                        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment2())
                    }

                }
            }
        }
    }


    private fun setupViewAppearance() {
        (activity as MainActivity).apply {
            window.statusBarColor = getColor(R.color.primary)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                window.insetsController?.setSystemBarsAppearance(
                    0,
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                )
            }
            controlBottomNavVisibility(false)
        }
    }

}