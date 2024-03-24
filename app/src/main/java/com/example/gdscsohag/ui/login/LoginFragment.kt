package com.example.gdscsohag.ui.login

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.gdscsohag.MainActivity
import com.example.gdscsohag.R
import com.example.gdscsohag.databinding.FragmentLoginBinding
import com.example.gdscsohag.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {
    override val layoutId = R.layout.fragment_login
    override val viewModel: LoginViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewAppearance()
        loginObserve()
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

    private fun loginObserve() {
        viewModel.apply {
            viewModelScope.launch {
                events.collectLatest {
                    if (it) {
                        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment2())
                    } else showInvalidLoginToast()
                }
            }
        }
    }

    private fun showInvalidLoginToast() {
        Toast.makeText(
            context,
            getString(R.string.wrong_email_or_password_check_and_try_again),
            Toast.LENGTH_SHORT
        ).show()
    }
}